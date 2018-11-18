package com.example.michal.mob_la04.Models;

import com.example.michal.mob_la04.ModelLists.ModelList;

public class Student extends Model {

    private int id;
    private String name;
    private String surname;
    private ModelList<Project> projects;

    public final static String TABLE_NAME = "STUDENTS";
    public final static String ID_COLUMN = "ID_STUDENT";
    public final static String NAME_COLUMN = "STUDENT_NAME";
    public final static String SURNAME_COLUMN = "STUDENT_SURNAME";
    public final static  String[] PROJECTION = {
            "ID_STUDENT",
            "STUDENT_NAME",
            "STUDENT_SURNAME"
    };

    public Student(int id, String name, String surname, ModelList projects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }

    public ModelList<Project> getProjectList() {
        return projects;
    }

}
