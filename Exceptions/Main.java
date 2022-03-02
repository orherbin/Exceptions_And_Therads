// Or Herbin 206092835
//Omri Millo 206093833

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        Student student = null;
        do {
            System.out.println("Please enter student name:");
            String name = input.next();
            System.out.println("Please enter student ID:");
            String id = input.next();
            try {
                student = new Student(id, name);
                flag = true;
            } catch (Exception m) {
                System.out.println("Exception occurred: " + m);
            }
        } while (!flag);

        student.calculateAverage();
        Course course1 = new Course("Statistics", 70);
        student.addCourse(course1);
        Course course2 = new Course("Computer Networks", 85);
        student.addCourse(course2);
        Course course3 = new Course("Java OOP", 100);
        student.addCourse(course3);
        Course c3 = new Course("Liner Algebra", 80);
        student.addCourse(c3);

        Course course4 = new Course("Intro to Computer Science", 95);
        try {
            student.findCourseAndPrint(course4);
        } catch (NullPointerException e) {
            System.out.println("Course" + course4.getCourseName() + " doesn’t exist for student " + student.getName());
        } finally {
            System.out.println(course4.toString());
        }
    }
}
