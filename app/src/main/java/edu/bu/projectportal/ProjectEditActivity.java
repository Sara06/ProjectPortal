package edu.bu.projectportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ProjectEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_edit);


        EditText titleEditText,detailEditText,authorEditText,linkEditText,keywordEditText,additionalEditText;
        int  projectId;
        CheckBox favCheckBox;

        Button submit;
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleEditText = (EditText) findViewById(R.id.projTitleEditText);
                String title = titleEditText.getText().toString();
                Project.projects[projectId].setTitle(title);


                detailEditText = (EditText) findViewById(R.id.projDetailEditTextId);
                String detail= detailEditText.getText().toString();
                Project.projects[projectId].setSummary(detail);


                authorEditText = (EditText) findViewById(R.id.authorEditTextId);
                String author = authorEditText.getText().toString();
                Project.projects[projectId].setAuthor(author);

                linkEditText = (EditText) findViewById(R.id.projLinkEditText);
                String link = linkEditText.getText().toString();
                Project.projects[projectId].setLink(link);

                keywordEditText = (EditText) findViewById(R.id.keywordEditTextId);
                String keyword = keywordEditText.getText().toString();
                Project.projects[projectId].setKeyword(keyword);


                additionalEditText = (EditText) findViewById(R.id.additionalEditTextId);
                String additional = additionalEditText.getText().toString();
                Project.projects[projectId].setAdditionalInformation(additional);


                favCheckBox = (CheckBox) findViewById(R.id.projFavoriteCheckBoxId);
                Boolean fav = favCheckBox.isChecked();
                Project.projects[projectId].setFavorite(fav);


            }
        });


    }
}