package com.example.michal.mob_la04.OpenHelpers;

import com.example.michal.mob_la04.Models.Project;

public class ProjectOpenHelper {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + Project.TABLE_NAME + " (" +
                    Project.ID_COLUMN + " INTEGER PRIMARY KEY," +
                    Project.PROJECT_NAME_COLUMN + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Project.TABLE_NAME;
}
