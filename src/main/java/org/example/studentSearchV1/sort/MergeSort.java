package org.example.studentSearchV1.sort;

import org.example.studentSearchV1.Student;

public class MergeSort extends AbstractSort {

    /* Merge sort algorithm (public invocation) */
    public static void sort(Student[] students) {
        Student[] aux = new Student[students.length];
        sort(students, aux, 0, students.length - 1);
    }

    /* Recursive merge sort logic */
    private static void sort(Student[] students, Student[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(students, aux, low, mid);
        sort(students, aux, mid + 1, high);
        merge(students, aux, low, mid, high);
    }

    /* Merge the two sorted sub-arrays into a larger sorted (sub)array */
    private static void merge(Student[] students, Student[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = students[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                students[k] = aux[j++];
            } else if (j > high) {
                students[k] = aux[i++];
            } else if (less(aux[j].getStudentId(), aux[i].getStudentId())) {
                students[k] = aux[j++];
            } else {
                students[k] = aux[i++];
            }
        }
    }
}


