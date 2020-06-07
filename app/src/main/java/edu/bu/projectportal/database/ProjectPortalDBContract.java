package edu.bu.projectportal.database;

public final class ProjectPortalDBContract {
    public static final String DBName = "projectportal.dB";
    public static final int DB_VERSION = 1;

    public static final class ProjectContract{
        public static final String TABLE_NAME = "projects";
        public static final String COLUMN_PROJECT_ID = "project_id";
        public static final String COLUMN_PROJECT_Title = "project_title";
        public static final String COLUMN_PROJECT_SUMMARY = "project_summary";
        public static final String COLUMN_PROJECT_Author= "project_author";
        public static final String COLUMN_PROJECT_Isfavorite = "project_isfavorite";
        public static final String COLUMN_PROJECT_Link = "project_link";
        public static final String COLUMN_PROJECT_Keyword = "project_keyword";
        public static final String COLUMN_PROJECT_AdditionInformation = "project_additionalinformation";


    }
    public static final String CREATE_PROJECT_TABLE = "CREATE TABLE" +
            ProjectPortalDBContract.ProjectContract.TABLE_NAME +
            "(" +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Title +
            " TEXT," +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_SUMMARY +
            " TEXT," +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Author +
            "TEXT," +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Isfavorite +
            "INTEGER," +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Link +
            "TEXT," +
            ProjectPortalDBContract.ProjectContract.COLUMN_PROJECT_Keyword +
            "TEXT," +
            ProjectContract.COLUMN_PROJECT_AdditionInformation +
            "TEXT);";
    public static final String DROP_PROJECT_TABLE = "DROP TABLE IF EXISTS " +
            + ProjectPortalDBContract.ProjectContract.TABLE_NAME;
}
