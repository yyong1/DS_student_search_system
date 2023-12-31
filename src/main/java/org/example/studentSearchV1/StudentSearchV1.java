package org.example.studentSearchV1;

import org.example.studentSearchV1.search.BinarySearch;
import org.example.studentSearchV1.sort.MergeSort;

import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV1 {

//    Expected data CSV
//    1053337;Hershel Breitenberg;26-05-1997;Global University of United States;BUS;Business;2020
//    7090334;Nikola Adamić;22-02-1992;Global University of Croatia;AM;Applied Mathematics;2016

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path (absolute path) to the input file: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the path (absolute path) to the output file: ");
        String outputFile = scanner.nextLine();

        Student[] students;
        try {
            students = FileUtils.readFile(inputFile);
        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
            return;
        }

        MergeSort.sort(students);

        try {
            FileUtils.writeToFile(students, outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to the output file: " + e.getMessage());
            return;
        }

        int searchId;
        do {
            System.out.print("Enter a student ID to search (or -1 to exit): ");
            searchId = scanner.nextInt();

            if (searchId != -1) {
                int index = BinarySearch.search(students, searchId);

                if (index != -1) {
                    Student student = students[index];
                    System.out.println("Student found!");
                    System.out.println("Student ID: " + student.getStudentId());
                    System.out.println("Full Name: " + student.getFullName());
                    System.out.println("Date of Birth: " + student.getDateOfBirth());
                    System.out.println("University Name: " + student.getUniversityName());
                    System.out.println("Department Code: " + student.getDepartmentCode());
                    System.out.println("Department Name: " + student.getDepartmentName());
                    System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                    System.out.println("Number of Steps: " + BinarySearch.numSteps);
                } else {
                    System.out.println("Student not found!");
                    System.out.println("Number of Steps: " + BinarySearch.numSteps);
                }
            }
        } while (searchId != -1);

        System.out.println("Program terminated.");
    }
}
