package com.example.agenda.dao;

import com.example.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final static List<Student> students = new ArrayList<>();
    private static int idCounter = 1;

    public void saveStudent(Student student) {
        student.setId(idCounter);
        students.add(student);
        idCounter++;
    }

    public void edit(Student student) {
        Student studentFound = null;
        for (Student s :
                students) {
            if (s.getId() == student.getId()) {
                studentFound = s;
            }
        }
        if (studentFound != null) {
            int studentIndex = students.indexOf(studentFound);
            students.set(studentIndex, student);
        }
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void remove(Student student) {
        Student studentFound = null;
        for (Student s :
                students) {
            if (s.getId() == student.getId()) {
                studentFound = s;
            }
        }
        if (studentFound != null) {
            students.remove(studentFound);
        }
    }
}
