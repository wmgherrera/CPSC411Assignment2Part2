package com.herrera.william.cpsc411assignment2part2;

public class Course {

    protected String mCourseID;
    protected String mGrade;

    public Course(String courseID, String grade) {
        mCourseID = courseID;
        mGrade = grade;
    }

    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String courseID) {
        mCourseID = courseID;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }
}
