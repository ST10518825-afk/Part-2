/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import students.Students;

public class StudentsRecordManager {
    public static final String FILE_NAME = "students.csv";
    public static List<Students> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudentsFromCSV();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=================================================");
            System.out.println("      STUDENT RECORDS MANAGEMENT SYSTEM         ");
            System.out.println("=================================================");
            System.out.println("1. Display all student records");
            System.out.println("2. Search for a student using Student ID");
            System.out.println("3. Display all students enrolled in a course");
            System.out.println("4. Display students who have passed");
            System.out.println("5. Calculate basic statistics");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    searchStudentById(scanner);
                    break;
                case 3:
                    displayStudentsByCourse(scanner);
                    break;
                case 4:
                    displayPassedStudents();
                    break;
                case 5:
                    calculateStatistics();
                    break;
                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }

    public static void loadStudentsFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (isHeader) { 
                    isHeader = false;
                    continue; 
                }

                String[] data = line.split(",");
                if (data.length == 5) {
                    String id = data[0].trim();
                    String name = data[1].trim();
                    String course = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    double mark = Double.parseDouble(data[4].trim());

                    students.add(new Students(id, name, course, year, mark));
                }
            }
            System.out.println("Successfully loaded " + students.size() + " student records from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric data in CSV file: " + e.getMessage());
        }
    }

    public static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n--- ALL STUDENT RECORDS ---");
        for (Students s : students) {
            System.out.println(s);
        }
    }

    public static void searchStudentById(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        String searchId = scanner.nextLine().trim();
        boolean found = false;

        for (Students s : students) {
            if (s.getStudentId().equalsIgnoreCase(searchId)) {
                System.out.println("\nStudent Found:");
                System.out.println(s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with ID: " + searchId);
        }
    }

    public static void displayStudentsByCourse(Scanner scanner) {
        System.out.print("Enter Course Name: ");
        String searchCourse = scanner.nextLine().trim();
        boolean found = false;

        System.out.println("\n--- STUDENTS ENROLLED IN: " + searchCourse + " ---");
        for (Students s : students) {
            if (s.getCourse().equalsIgnoreCase(searchCourse)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found for course: " + searchCourse);
        }
    }

    public static void displayPassedStudents() {
        System.out.println("\n--- STUDENTS WHO PASSED (Mark >= 50) ---");
        boolean found = false;
        for (Students s : students) {
            if (s.isPassed()) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students passed.");
        }
    }

    public static void calculateStatistics() {
        if (students.isEmpty()) {
            System.out.println("No data available to calculate statistics.");
            return;
        }

        int totalStudents = students.size();
        double highestMark = students.get(0).getMark();
        double lowestMark = students.get(0).getMark();
        double sumMarks = 0;

        for (Students s : students) {
            double mark = s.getMark();
            sumMarks += mark;

            if (mark > highestMark) highestMark = mark;
            if (mark < lowestMark) lowestMark = mark;
        }

        double averageMark = sumMarks / totalStudents;

        System.out.println("\n--- BASIC STATISTICS ---");
        System.out.println("Total Number of Students : " + totalStudents);
        System.out.printf("Highest Mark              : %.2f\n", highestMark);
        System.out.printf("Lowest Mark               : %.2f\n", lowestMark);
        System.out.printf("Average Mark              : %.2f\n", averageMark);
    }
     
    
    
   
    
}
