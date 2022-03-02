package com.company;

public class Student {
    protected String id;
    protected String name;
    protected Course[] courses;

    public Student(String id, String name) throws FirstCharNoneAlphabeticException, IdLessThenigitsException, NotAllIsNumException {
        boolean isIdANumber = true;
        for (int i = 0; i < id.length(); i++) {
            isIdANumber = id.charAt(i) >= '0' && id.charAt(i) <= '9';
        }
        if (id.length() != 9) throw new IdLessThenigitsException("The ID should contain 9 numbers");
        else if (!isIdANumber) throw new NotAllIsNumException("The ID must contain numbers only.");
        else this.id = id;

        if ((name.charAt(0) >= 'a' && name.charAt(0) <= 'z') || (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
            this.name = name;
        } else throw new FirstCharNoneAlphabeticException("The first character must be a letter.");
        this.courses = new Course[3];
    }

    public void addCourse(Course newCourse) {

        try {
            int coursesIndex = 0;
            for (Course course : this.courses) {
                if (course != null) {
                    coursesIndex++;
                }
            }
            this.courses[coursesIndex] = newCourse;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You reached " + this.courses.length + ". The maximum amount of courses is now " + this.courses.length * 2);
            Course[] newCoursesArr = new Course[this.courses.length * 2];
            System.arraycopy(courses, 0, newCoursesArr, 0, this.courses.length);
            newCoursesArr[this.courses.length] = newCourse;
            this.courses = newCoursesArr;
        }
    }

    public double calculateAverage() {
        try {
            double average = 0;
            int num1 = 0;
            int num2 = 0;

            for (Course course : this.courses) {
                if (course != null) {
                    num1 = +course.getStudentFinalGrade();
                    num2++;
                }
            }
            average = num1 / num2;
            return average;
        } catch (ArithmeticException e) {
            System.out.println("There are no courses.");
            return 0;
        }
    }

    private Course findCourse(Course course) {
        Course replica = null;
        for (int i = 0; i < this.courses.length; i++) {
            if (this.courses[i] != null && this.courses[i].equals(course)) {
                replica = course;
            }
        }
        return replica;
    }

    public void findCourseAndPrint(Course course) {
        try {
            System.out.println(this.findCourse(course).toString());
        } catch (NullPointerException e) {
            System.out.println("The selected course isn't in our system.");
            throw new NullPointerException();
        }
    }

    public String getName() {
        return name;
    }
}
