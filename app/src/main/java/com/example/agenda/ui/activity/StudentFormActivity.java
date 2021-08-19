package com.example.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDao;
import com.example.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    public static final String TITLE_APP_BAR = "New Student";
    private EditText nameField;
    private EditText phoneField;
    private EditText emailField;
    final StudentDao dao = new StudentDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        setTitle(TITLE_APP_BAR);
        initializeFields();


        configureSaveButton();
    }

    private void configureSaveButton() {
        Button submitButton = findViewById(R.id.activity_student_form_button_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student createdStudent = createStudent();

                save(createdStudent);
            }
        });
    }

    private void initializeFields() {
        nameField = findViewById(R.id.activity_student_form_name);
        phoneField = findViewById(R.id.activity_student_form_phone);
        emailField = findViewById(R.id.activity_student_form_email);
    }

    private void save(Student student) {
        dao.saveStudent(student);
        finish();
    }

    @NonNull
    private Student createStudent() {
        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String email = emailField.getText().toString();

        Student createdStudent = new Student(name, phone, email);
        return createdStudent;
    }
}