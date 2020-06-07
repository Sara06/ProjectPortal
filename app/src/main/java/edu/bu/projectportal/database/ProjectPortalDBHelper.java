package edu.bu.projectportal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProjectPortalDBHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    public ProjectPortalDBHelper(Context context){
        super(Context,ProjectPortalDBContract.DBName, null, ProjectPortalDBContract.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ProjectPortalDBContract.CREATE_PROJECT_TABLE);
        sqLiteDatabase.execSQL("INSERT INTO projects VALUES (1, 'Weather Forecast','Weather Forcast is an app ...','Peter',1,'https://www.weather.com','Sunny', 'best sunny day')");
        sqLiteDatabase.execSQL("INSERT INTO projects VALUES (2, 'Connect Me','Connect Me is an app ... ','John',0, 'https://www.connectme.com','connect','communication is best')");
        sqLiteDatabase.execSQL("INSERT INTO projects VALUES (3, 'What to Eat', 'What to Eat is an app ...', 'Josh',1, 'https://www.food.com','eatoutside','eating outside is fun' )");
        sqLiteDatabase.execSQL("INSERT INTO projects VALUES (4, 'Project Portal', 'Project Portal is an app ...', 'arun', 1 , 'https://www.information.com','information','this is best project')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(ProjectPortalDBContract.DROP_PROJECT_TABLE);
        onCreate(sqLiteDatabase);

    }
}
