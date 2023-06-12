
package org.example;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
    public int studentID;
    public String fullName;
    public LocalDate dateOfBirth;
    public String universityName;
    public String departmentCode;
    public String departmentName;
    public int enrolmentYear;

    public Student(
            int studentID,
            String fullName,
            LocalDate dateOfBirth,
            String universityName,
            String departmentCode,
            String departmentName,
            int enrolmentYear
    ) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.enrolmentYear = enrolmentYear;
    }

    public int getStudentId() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getYearOfEnrollment() {
        return enrolmentYear;
    }

    @Override
    public int compareTo(Student that) {
        return Integer.compare(this.studentID, that.studentID);
    }
}
