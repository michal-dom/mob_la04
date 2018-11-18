package com.example.michal.mob_la04.Factories;

import android.database.Cursor;

import com.example.michal.mob_la04.ModelLists.ModelList;
import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.Models.Student;

import java.util.ArrayList;

public class StudentFactory extends Factory {


    @Override
    public Model createModel(Cursor cursor) {
        long itemId = 0;
        String itemName = "";
        String itemSurName = "";
        while(cursor.moveToNext()) {
            itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Student.ID_COLUMN));
            itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.NAME_COLUMN));
            itemSurName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.SURNAME_COLUMN));
        }
        cursor.close();

        Student student = new Student((int)itemId,itemName,itemSurName, null);
        return student;
    }

    @Override
    public ModelList<Student> createAllModels(Cursor cursor) {
        ArrayList<Student> students = new ArrayList<Student>();

        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Student.ID_COLUMN));
            String itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.NAME_COLUMN));
            String itemSurName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.SURNAME_COLUMN));

            students.add(new Student((int)itemId,itemName,itemSurName, null));
        }
        cursor.close();

        return new ModelList<Student>(students);
    }

    @Override
    public ModelList<Student> createAllJoinedModels(Cursor cursor) {
        return null;
    }
}
