package com.example.michal.mob_la04.OpenHelpers;

import com.example.michal.mob_la04.Models.ProjectXStudent;

public class ProjectXStudentOpenHelper {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ProjectXStudent.TABLE_NAME + " (" +
                    ProjectXStudent.STUDENT_ID_COLUMN + " INTEGER," +
                    ProjectXStudent.PROJECT_ID_COLUMN + " INTEGER)";


    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ProjectXStudent.TABLE_NAME;

}
