package com.company;

import java.util.Objects;

public class Course {
    private String courseName;
    private int studentFinalGrade;

    public Course(String courseName, int studentFinalGrade) {
        this.courseName = courseName;
        this.studentFinalGrade = studentFinalGrade;
    }

    public Course(Course course) {
        super();
        this.courseName = course.courseName;
        this.studentFinalGrade = course.studentFinalGrade;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", studentFinalGrade=" + studentFinalGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return studentFinalGrade == course.studentFinalGrade && Objects.equals(courseName, course.courseName);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getStudentFinalGrade() {
        return studentFinalGrade;
    }
}
