package com.example.michal.mob_la04.DataMapper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.michal.mob_la04.Factories.Factory;
import com.example.michal.mob_la04.ModelLists.ModelList;
import com.example.michal.mob_la04.Models.Model;

public abstract class DataMapper {

    protected String[] projection;
    protected SQLiteDatabase db;
    private String tableName;
    private Factory factory;

    public DataMapper(SQLiteOpenHelper openHelper, String[] projection, String tableName, Factory factory){
        this.db = openHelper.getReadableDatabase();
        this.tableName = tableName;
        this.projection = projection;
        this.factory = factory;
    }

    public long insert(Model model){
        ContentValues values = createValues(model);
        return db.insert(this.tableName, null, values);
    }

    public Model select(int id){

        Cursor cursor = db.query(
                this.tableName,         // The table to query
                this.projection,        // The array of columns to return (pass null to get all)
                createSelection(),              // The columns for the WHERE clause
                createSelectionArgs(id),          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                null               // The sort order
        );
        return factory.createModel(cursor);
    }

    public ModelList selectAll(){

        Cursor cursor = db.query(
                this.tableName,         // The table to query
                this.projection,        // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                null               // The sort order
        );

        return factory.createAllModels(cursor);
    }

    public ModelList selectAllJoined(int id){

        Cursor cursor = db.rawQuery(createRawQuery(), createSelectionArgs(id));
        return factory.createAllJoinedModels(cursor);
    }

    protected abstract ContentValues createValues(Model model);
    protected abstract String createSelection();
    protected abstract String[] createSelectionArgs(int id);
    protected abstract String createRawQuery();
    public abstract boolean delete(Model model);
    public abstract boolean update(Model model);


}
