package com.example.michal.mob_la04.DataMapper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.michal.mob_la04.Factories.Factory;
import com.example.michal.mob_la04.MainActivity;
import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.Models.Project;
import com.example.michal.mob_la04.Models.Student;

public class StudentMapper extends DataMapper{

    public StudentMapper(SQLiteOpenHelper openHelper, Factory factory) {
        super(openHelper, Student.PROJECTION, Student.TABLE_NAME, factory);
    }

    @Override
    protected ContentValues createValues(Model model) {
        Student student = (Student) model;
        ContentValues values = new ContentValues();

        values.put(Student.NAME_COLUMN, student.getName());
        values.put(Student.SURNAME_COLUMN, student.getSurname());
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
        rawQuery = "SELECT * FROM " + Student.TABLE_NAME
                +" INNER JOIN PROJECT_X_STUDENT ON PROJECT_X_STUDENT.STUDENT_ID = STUDENTS.ID_STUDENT"
                +" WHERE PROJECT_X_STUDENT.PROJECT_ID = ?";
        return rawQuery;
    }

    @Override
    public boolean delete(Model model) {
        Student s = (Student) model;
        return db.delete(Student.TABLE_NAME, Student.ID_COLUMN + "=" + s.getId(), null) > 0;
    }

    @Override
    public boolean update(Model model) {
        Student s = (Student) model;
        return db.update(Student.TABLE_NAME, createValues(model), Student.ID_COLUMN + "=" + s.getId(), null ) > 0;

    }
}
