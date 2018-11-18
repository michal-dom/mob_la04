package com.example.michal.mob_la04.OpenHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FullOpenHelper extends SQLiteOpenHelper {


    public FullOpenHelper(Context context) {
        super(context, "pm04.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(StudentOpenHelper.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(ProjectOpenHelper.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(ProjectXStudentOpenHelper.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(StudentOpenHelper.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(ProjectOpenHelper.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(ProjectXStudentOpenHelper.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}

