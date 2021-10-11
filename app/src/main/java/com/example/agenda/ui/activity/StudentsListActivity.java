package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDao;
import com.example.agenda.model.Student;
import com.example.agenda.ui.StudentsListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

@SuppressWarnings("CommentedOutCode")
public class StudentsListActivity extends AppCompatActivity {

    public static final String TITLE_APP_BAR = "Students list";
    private StudentDao dao;
    private final StudentsListView studentsListView = new StudentsListView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 'setTitle' possible because of appcompatactivity extension
        setTitle(TITLE_APP_BAR);
        setContentView(R.layout.activity_students_list);
        dao = new StudentDao();

        configureFabStudent();
        configureList();


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

    @Override
    protected void onResume() {
        super.onResume();
        studentsListView.update();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // attach a static layout to a menu because you can have many menus
        getMenuInflater().inflate(R.menu.activity_student_list_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.activity_student_list_menu_remove) {
            studentsListView.confirmStudentRemove(item);
        }

        return super.onContextItemSelected(item);
    }

    private void configureFabStudent() {
        FloatingActionButton newStudentButton = findViewById(R.id.activity_students_list_fab_new_student);

        newStudentButton.setOnClickListener(view -> openStudentFormActivity());
    }

    private void openStudentFormActivity() {
        startActivity(new Intent(this, StudentFormActivity.class));
    }



    private void configureList() {
        ListView studentsListListView = findViewById(R.id.activity_students_list_listview);
        studentsListView.configureAdapter(studentsListListView);
        configureListenerClickOnItem(studentsListListView);
//        configureLongClickListener(studentsListView);
        registerForContextMenu(studentsListListView);
    }

//    private void configureLongClickListener(ListView studentsListView) {
//        studentsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long l) {
//                // Log.i("Long Click", String.valueOf(index));
//                Student selectedStudent = (Student) adapterView.getItemAtPosition(index);
//
//                dao.remove(selectedStudent);
//                //remove from adapter to re-render and see the changes
//                adapter.remove(selectedStudent);
//                // return false will pass this event ahead, so "click" event will be fired as well.
//                return false;
//            }
//        });
//    }

    private void configureListenerClickOnItem(ListView studentsListView) {
        studentsListView.setOnItemClickListener((adapterView, view, index, id) -> {
            Student selectedStudent = (Student) adapterView.getItemAtPosition(index);
            Intent goToFormActivity = new Intent(StudentsListActivity.this, StudentFormActivity.class);
            goToFormActivity.putExtra("student", selectedStudent);
            startActivity(goToFormActivity);
        });
    }

}
