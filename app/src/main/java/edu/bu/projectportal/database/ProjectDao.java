package edu.bu.projectportal.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    public static ProjectDao instance;

    public ProjectPortalDBHelper projectPortalDBHelper;
    public SQLiteDatabase mReadableDB, mWritableDB;

    public ProjectDao(Context context) {
        projectPortalDBHelper = new ProjectPortalDBHelper(context);
    }

    public void openDb() {
        mReadableDB.close();
        mWritableDB.close();
    }

    public static ProjectDao getInstance(Context context) {
        if (instance == null)
            instance = new ProjectDao(context);
        return instance;
    }
}

    public List<Project> getAllProject() {
        String[] projection = {
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_ID,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Title,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_SUMMARY,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Author,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Author,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Isfavorite,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Link,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Keyword,
                ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_AdditionInformation};


        Cursor cursor = mReadableDB.query(ProjectPortalDBContract.ProjectContract.TABLE_NAME,
                projection, null, null, null, null, null);

        List<Project> projects = new ArrayList<Project>();

        while(cursor.moveToNext()){
            int projectId = cursor.getInt(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_ID));
            String projectTitle = cursor.getString(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Title));
            String projectSummary = cursor.getString(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_SUMMARY));

            String projectAuthor = cursor.getString(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Author));

            String projectIsfavorite = cursor.getString(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Isfavorite));
            String projectLink = cursor.getString(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Link));
            String projectKeyword = cursor.getString(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Keyword));

            String projectAdditioninformation = cursor.getString(cursor.getColumnIndex(
                    ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_AdditionInformation));

            projects.add(new Project(projectId, projectTitle, projectSummary, projectAuthor, projectIsfavorite, projectLink, projectKeyword, projectAdditioninformation));

        }
        cursor.close();
        return projects;
    }





