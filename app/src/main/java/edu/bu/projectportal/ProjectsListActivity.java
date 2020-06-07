package edu.bu.projectportal;

/**
 * Created by danazh on 4/23/18.
 */

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.bu.projectportal.database.ProjectPortalDBHelper;

public class ProjectsListActivity extends AppCompatActivity implements ProjectListAdapter.Listener {
    private static final String EXTRA_FAVORITEID = "favoriteId";
    ProjectPortalDBHelper projectPortalDBHelper;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter projectAdapter;
    private RecyclerView.LayoutManager layoutManager;


    List<Project> projectList;
    SQLiteDatabase sqLiteDatabase;
    public SQLiteDatabase mReadableDB, mWritableDB;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_list);


        projectPortalDBHelper = new ProjectPortalDBHelper(this);
        sqLiteDatabase = projectPortalDBHelper.getReadableDatabase();
        recyclerView = (RecyclerView)findViewById(R.id.projectlist_recyclerview);
        boolean isFavorite =(cursor.getInt(3)==1);
        CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
        favorite.setChecked(isFavorite);
        onFavoriteClicked();
        setupOptionsListView();
        setupFavoriteListView();

    }



    public void onFavoriteClicked(View view) {

        int favoriteId = (Integer) getIntent().getExtras().get(EXTRA_FAVORITEID);

        //get the value of the checkbox
        ContentValues favoriteValues = new ContentValues();
        Object favorite;
        favoriteValues.put("FAVORITE",favorite.ischecked());

        SQLiteOpenHelper ProjectPortalDBHelper =new ProjectPortalDBHelper(this);
        try{
            SQLiteDatabase sqLiteDatabase = ProjectPortalDBHelper.getWritableDatabase();
            sqLiteDatabase.update("project_isfavorite",favoriteValues,"_id =?", new String[]{Integer.toString(favoriteId)});
            sqLiteDatabase.close();
        }catch(SQLiteException e){
            Toast toast = Toast.makeText(this,"database unavailable", Toast.LENGTH_SHORT);
                toast.show();
        }
    }



    private void setupOptionsListView() {
        //create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Intent intent = new Intent(getContext(), ProjectDetailActivity.class);
               // intent.putExtra("projectid",i );
             //  startActivity(intent);
            }
        }
        //add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.favorite);
        listView.setOnItemClickListener(itemClickListener);

    }


    private void setupFavoriteListView() {
        //populate the list favorites listview from a cursor
        ListView listFavorites = (ListView)findViewById(R.id.favoriteList);
        try {
            SQLiteOpenHelper ProjectPortalDBHelper = new ProjectPortalDBHelper(this);
            sqLiteDatabase = ProjectPortalDBHelper.getReadableDatabase();
            Cursor favoritecursor = sqLiteDatabase.query("project_isfavorite", new String[]{
                            "_id", "Title"},
                    "project_isfavorite = 1",
                    null, null, null, null, null);
            CursorAdapter favoriteAdapter = new simpleCursorAdapter(ProjectsListActivity.this, android.R.layout.simple_list_item_1,
                    favoritecursor, new String[]{"Title"}, new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);
        }
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this,"database unavailable", Toast.LENGTH_SHORT);
            toast.show();

        }
    }






    @Override
    public void onClick(int position) {
        ProjectDetailFragment detailFragment =
                (ProjectDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailfragment);

        if (detailFragment != null) {
            detailFragment.setProject(position);
        } else {
            Intent intent = new Intent(this, ProjectDetailActivity.class);
            intent.putExtra("projectid", position);
            startActivity(intent);

        }

    }

    private class simpleCursorAdapter extends CursorAdapter {
        public simpleCursorAdapter(ProjectsListActivity projectsListActivity, int simple_list_item_1, Cursor favoritecursor, String[] strings, int[] ints, int i) {
            super();
        }
    }
}
