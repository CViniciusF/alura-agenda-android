package com.example.agenda.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    private int id = 0;
    private String name;
    private String phone;
    private String email;

    public Student(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Student() {

    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + name + " - Phone: " + phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
            return name;
        }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean hasValidId() {
        return id > 0;
    }

}
