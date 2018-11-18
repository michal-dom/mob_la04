package com.example.michal.mob_la04.Models;

import com.example.michal.mob_la04.ModelLists.ModelList;

import java.util.ArrayList;

public class Project extends Model {
    private int id;
    private String projectName;
    private ModelList<Student> students;

    public final static String TABLE_NAME = "PROJECTS";
    public final static String ID_COLUMN = "ID_PROJECT";
    public final static String PROJECT_NAME_COLUMN = "PROJECT_NAME";
    public final static  String[] PROJECTION = {
            "ID_PROJECT",
            "PROJECT_NAME"
    };

    public Project(int id, String projectName, ModelList students) {
        this.id = id;
        this.projectName = projectName;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public String toString() {
        return id + " " + projectName;
    }

    public ModelList<Student> getStudentList() {
        return students;
    }

}
