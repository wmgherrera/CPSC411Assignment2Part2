package com.herrera.william.cpsc411assignment2part2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected ListView mStudentList;
    protected Menu mMenu;
    protected MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createStudents();
        // Create DB so it is not null
        //ArrayList<Student> studentArrayList = new ArrayList<>();
        //StudentDB.getOurInstance().setStudents(studentArrayList);

        setContentView(R.layout.activity_main);
        mStudentList = findViewById(R.id.student_listview_id);
        adapter = new MainAdapter();
        mStudentList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        mMenu = menu;
        menu.findItem(R.id.action_add).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddStudent.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        // This does not seem to be working
        adapter.notifyDataSetChanged();
        super.onStart();
    }

    protected void createStudents()
    {
        ArrayList<Student> studentArrayList = new ArrayList<>();

        Student s1 = new Student("Will", "Herrera", "8675309");
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("CPSC 411", "A+"));
        s1.setCourses(courses);
        studentArrayList.add(s1);

        Student s2 = new Student("John", "Smith", "55547398");
        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC 464", "B"));
        s2.setCourses(courses);
        studentArrayList.add(s2);

        StudentDB.getOurInstance().setStudents(studentArrayList);
    }

}
