package com.example.michal.mob_la04.Models;

public class ProjectXStudent extends Model {
    public final static String TABLE_NAME = "PROJECT_X_STUDENT";
    public final static String STUDENT_ID_COLUMN = "STUDENT_ID";
    public final static String PROJECT_ID_COLUMN = "PROJECT_ID";


    public final static  String[] PROJECTION = {
            "STUDENT_ID",
            "PROJECT_ID"
    };

    private int studentId;
    private int projectId;

    public ProjectXStudent(int studentId, int projectId) {
        this.studentId = studentId;
        this.projectId = projectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return studentId + "/" + projectId;
    }
}
