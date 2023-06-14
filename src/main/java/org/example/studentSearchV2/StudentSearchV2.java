package org.example.studentSearchV2;

import org.example.studentSearchV1.FileUtils;
import org.example.studentSearchV1.Student;


import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path (absolute path) to the input file: ");
        String inputFile = scanner.nextLine();

        RedBlackTree<Integer, Student> studentTree = new RedBlackTree<>();

        try {
            loadUnsortedFile(inputFile, studentTree);
        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
            return;
        }

        int numRedLinks = studentTree.countRedLinks();
        System.out.println("Number of red links: " + numRedLinks);

        int searchId;
        do {
            System.out.print("Enter a student ID to search (or -1 to exit): ");
            searchId = scanner.nextInt();

            if (searchId != -1) {
                Student student = studentTree.get(searchId);

                if (student != null) {
                    System.out.println("Student found!");
                    System.out.println("Student ID: " + student.getStudentId());
                    System.out.println("Full Name: " + student.getFullName());
                    System.out.println("Date of Birth: " + student.getDateOfBirth());
                    System.out.println("University Name: " + student.getUniversityName());
                    System.out.println("Department Code: " + student.getDepartmentCode());
                    System.out.println("Department Name: " + student.getDepartmentName());
                    System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                    System.out.println("Number of Steps: " + studentTree.numSteps);
                } else {
                    System.out.println("Student not found!");
                    System.out.println("Number of Steps: " + studentTree.numSteps);
                }
            }
        } while (searchId != -1);

        System.out.println("Program terminated.");
    }

    private static void loadUnsortedFile(String inputFile, RedBlackTree<Integer, Student> studentTree) throws IOException {
        Student[] students = FileUtils.readFile(inputFile);
        for (Student student : students) {
            studentTree.put(student.getStudentId(), student);
        }
    }
}
