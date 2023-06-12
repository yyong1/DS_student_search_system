package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static Student[] readFile(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            int studentId = Integer.parseInt(data[0]);
            String fullName = data[1];
            LocalDate dateOfBirth = LocalDate.parse(data[2], DATE_FORMAT);
            String universityName = data[3];
            String departmentCode = data[4];
            String departmentName = data[5];
            int yearOfEnrollment = Integer.parseInt(data[6]);

            Student student = new Student(
                    studentId,
                    fullName,
                    dateOfBirth,
                    universityName,
                    departmentCode,
                    departmentName,
                    yearOfEnrollment
            );
            students.add(student);
        }

        reader.close();

        return students.toArray(new Student[0]);
    }

    public static void writeToFile(Student[] students, String filePath) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for (Student student : students) {
            String line =
                    student.getStudentId() + ";" +
                    student.getFullName() + ";" +
                    student.getDateOfBirth().format(DATE_FORMAT) + ";" +
                    student.getUniversityName() + ";" +
                    student.getDepartmentCode() + ";" +
                    student.getDepartmentName() + ";" +
                    student.getYearOfEnrollment();

            writer.write(line);

            writer.newLine();
        }

        writer.close();
    }
}


