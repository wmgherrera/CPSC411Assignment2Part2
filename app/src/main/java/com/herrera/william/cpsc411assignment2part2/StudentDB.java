package com.herrera.william.cpsc411assignment2part2;

import java.util.ArrayList;

public class StudentDB {

    private static final StudentDB ourInstance = new StudentDB();

    protected ArrayList<Student> mStudents;

    public static StudentDB getOurInstance() {
        return ourInstance;
    }

    public ArrayList<Student> getStudents() {
        return mStudents;
    }

    public void setStudents(ArrayList<Student> students) {
        mStudents = students;
    }
}
