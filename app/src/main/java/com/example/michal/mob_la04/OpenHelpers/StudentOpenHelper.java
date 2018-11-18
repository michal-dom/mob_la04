package com.example.michal.mob_la04.OpenHelpers;

import com.example.michal.mob_la04.Models.Student;

public class StudentOpenHelper {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + Student.TABLE_NAME + " (" +
                    Student.ID_COLUMN + " INTEGER PRIMARY KEY," +
                    Student.NAME_COLUMN + " TEXT, " +
                    Student.SURNAME_COLUMN + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Student.TABLE_NAME;

}
