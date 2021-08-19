package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StudentsListActivity extends AppCompatActivity {

    public static final String TITLE_APP_BAR = "Students list";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 'setTitle' possible because of appcompatactivity extension
        setTitle(TITLE_APP_BAR);
        setContentView(R.layout.activity_students_list);

        configureFabStudent();

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

    }

    private void configureFabStudent() {
        FloatingActionButton newStudentButton = findViewById(R.id.activity_students_list_fab_new_student);

        newStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentFormActivity();
            }
        });
    }

    private void openStudentFormActivity() {
        startActivity(new Intent(this, StudentFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDao dao = new StudentDao();

        ListView studentsListView = findViewById(R.id.activity_students_list_listview);
        studentsListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.getAllStudents()));
    }
}
