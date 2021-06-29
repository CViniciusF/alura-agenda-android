package com.example.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this, "Eaee", Toast.LENGTH_SHORT).show();

//        TextView aluno = new TextView(this);
//        aluno.setText("Carlos Vinicius");
//        setContentView(aluno);

//        setContentView(R.layout.activity_main);
//        List<String> students = new ArrayList<>(Arrays.asList("Carlos", "Vinicius", "Jose"));
//        TextView firstStudent = findViewById(R.id.firstStudent);
//        TextView secondStudent = findViewById(R.id.secondStudent);
//        TextView thirdStudent = findViewById(R.id.thirdStudent);
//        firstStudent.setText(students.get(0));
//        secondStudent.setText(students.get(1));
//        thirdStudent.setText(students.get(2));

        List<String> students = new ArrayList<>(Arrays.asList("Carlos", "Vinicius", "Jose"));
        ListView studentsListView = findViewById(R.id.activity_main_students_list);
        studentsListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students));
    }
}
