package com.example.michal.mob_la04.Factories;

import android.database.Cursor;

import com.example.michal.mob_la04.ModelLists.ModelList;
import com.example.michal.mob_la04.Models.Model;

public abstract class Factory {

    public abstract Model createModel(Cursor cursor);
    public abstract ModelList createAllModels(Cursor cursor);
    public abstract ModelList createAllJoinedModels(Cursor cursor);
}
