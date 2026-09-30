/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package students;


public class Students {
    public String studentId;
    public String name;
    public String course;
    public int year;
    public double mark;

    public Students(String studentId, String name, String course, int year, double mark) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
        this.mark = mark;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    public double getMark() {
        return mark;
    }

    public boolean isPassed() {
        return this.mark >= 50.0;
    }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-15s | Course: %-22s | Year: %d | Mark: %.2f", 
                studentId, name, course, year, mark);
    }
}

   
