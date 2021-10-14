package com.example.agenda.ui.activity;

import static com.example.agenda.ui.activity.ConstantsActivities.STUDENTS_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDao;
import com.example.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    private static final String TITLE_APP_BAR = "New Student";
    private static final String TITLE_APP_BAR_EDIT_STUDENT = "Edit Student";
    private EditText nameField;
    private EditText phoneField;
    private EditText emailField;
    private Student student;
    final StudentDao dao = new StudentDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        setTitle(TITLE_APP_BAR);
        initializeFields();
        configureSaveButton();
        loadStudent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_student_form_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_student_form_menu_save) {
            finishForm();
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadStudent() {
        Intent data = getIntent();
        if (data.hasExtra(STUDENTS_KEY)) {
            setTitle(TITLE_APP_BAR_EDIT_STUDENT);
            student = (Student) data.getSerializableExtra(STUDENTS_KEY);
            nameField.setText(student.getName());
            phoneField.setText(student.getPhone());
            emailField.setText(student.getEmail());
        } else {
            setTitle(TITLE_APP_BAR);
            student = new Student();
        }
    }

    private void configureSaveButton() {
        Button submitButton = findViewById(R.id.activity_student_form_button_submit);

        submitButton.setOnClickListener(view -> finishForm());
    }

    private void finishForm() {
        fillStudent();
        if (student.hasValidId()) {
            dao.edit(student);
        } else {
            dao.saveStudent(student);
        }
        finish();
    }

    private void initializeFields() {
        nameField = findViewById(R.id.activity_student_form_name);
        phoneField = findViewById(R.id.activity_student_form_phone);
        emailField = findViewById(R.id.activity_student_form_email);
    }

    private void fillStudent() {
        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String email = emailField.getText().toString();

        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
    }
}