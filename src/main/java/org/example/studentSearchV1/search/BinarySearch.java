package org.example.studentSearchV1.search;

import org.example.studentSearchV1.Student;

public class BinarySearch {
    public static int numSteps = 1;

    public static int search(Student[] students, int key) {
        numSteps = 1;
        return binarySearch(students, key, 0, students.length - 1);
    }

    private static int binarySearch(Student[] students, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int currentId = students[mid].getStudentId();

        if (currentId == key) {
            return mid;
        } else if (currentId < key) {
            numSteps++;
            return binarySearch(students, key, mid + 1, high);
        } else {
            numSteps++;
            return binarySearch(students, key, low, mid - 1);
        }
    }
}
