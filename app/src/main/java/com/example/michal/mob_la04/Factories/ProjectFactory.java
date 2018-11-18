package com.example.michal.mob_la04.Factories;

import android.database.Cursor;

import com.example.michal.mob_la04.ModelLists.ModelList;
import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.Models.Project;
import com.example.michal.mob_la04.Models.Student;

import java.util.ArrayList;

public class ProjectFactory extends Factory {
    @Override
    public Model createModel(Cursor cursor) {
        long itemId = 0;
        String itemProName = "";
        while(cursor.moveToNext()) {
            itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Project.ID_COLUMN));
            itemProName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Project.PROJECT_NAME_COLUMN));
        }
        cursor.close();

        Project project = new Project((int)itemId, itemProName, null);
        return project;
    }

    @Override
    public ModelList<Project> createAllModels(Cursor cursor) {
        ArrayList<Project> projects = new ArrayList<>();

        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Project.ID_COLUMN));
            String itemProName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Project.PROJECT_NAME_COLUMN));

            projects.add(new Project((int)itemId, itemProName, null));

        }

        ModelList list = new ModelList(projects);

        return new ModelList<Project>(projects);
    }


    @Override
    public ModelList createAllJoinedModels(Cursor cursor) {
        return null;
    }
}
