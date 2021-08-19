package com.example.agenda.dao;

import com.example.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final static List<Student> students = new ArrayList<>();

    public void saveStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
