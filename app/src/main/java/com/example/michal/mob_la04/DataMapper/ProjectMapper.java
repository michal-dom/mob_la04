package com.example.michal.mob_la04.DataMapper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.michal.mob_la04.Factories.Factory;
import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.Models.Project;
import com.example.michal.mob_la04.Models.Student;

public class ProjectMapper extends DataMapper {

    public ProjectMapper(SQLiteOpenHelper openHelper, Factory factory) {
        super(openHelper, Project.PROJECTION, Project.TABLE_NAME, factory);
    }


    @Override
    protected ContentValues createValues(Model model) {
        Project project = (Project) model;
        ContentValues values = new ContentValues();

        values.put(Project.PROJECT_NAME_COLUMN, project.getProjectName());
        return values;
    }

    @Override
    protected String createSelection() {
        String selection = Student.ID_COLUMN + " = ?";
        return selection;
    }

    @Override
    protected String[] createSelectionArgs(int id) {
        String[] selectionArgs = { id+"" };
        return selectionArgs;
    }

    @Override
    protected String createRawQuery() {
        String rawQuery;
        rawQuery = "SELECT * FROM " + Project.TABLE_NAME
                +" INNER JOIN PROJECT_X_STUDENT ON PROJECT_X_STUDENT.PROJECT_ID= PROJECTS.ID_PROJECT"
                +" WHERE PROJECT_X_STUDENT.STUDENT_ID = ?";

        return rawQuery;
    }

    @Override
    public boolean delete(Model model) {
        Project p = (Project) model;
        return db.delete(Project.TABLE_NAME, Project.ID_COLUMN + "=" + p.getId(), null) > 0;
    }

    @Override
    public boolean update(Model model) {
        Project p = (Project) model;
        return db.update(Project.TABLE_NAME, createValues(model), Project.ID_COLUMN + "=" + p.getId(), null ) > 0;

    }
}
