package com.herrera.william.cpsc411assignment2part2;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudent extends AppCompatActivity {

    GridLayout mGridLayout;
    LinearLayout parentView;
    EditText firstName;
    EditText lastName;
    EditText CWID;
    EditText newClass;
    EditText grade;
    ArrayList<Course> courses;
    boolean needToSaveNewClass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        parentView = findViewById(R.id.parent_view);
        mGridLayout = findViewById(R.id.grid_layout);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        CWID = findViewById(R.id.cwid_text);


        courses = new ArrayList<>();

        final Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addView();
            }
        });


    }

    public void addView()
    {
        if(needToSaveNewClass == true)
        {
            courses.add(new Course(newClass.getText().toString(), grade.getText().toString()));
            newClass = null;
            grade = null;
            needToSaveNewClass = false;
            addView();
        }
        else
        {
            needToSaveNewClass = true;
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView classText = new TextView(this);
            classText.setText("Class:");
            classText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            ll.addView(classText);

            newClass = new EditText(this);
            newClass.setText("");
            newClass.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            ll.addView(newClass);

            TextView gradeText = new TextView(this);
            gradeText.setText("Grade:");
            gradeText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            ll.addView(gradeText);

            grade = new EditText(this);
            grade.setText("");
            grade.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            ll.addView(grade);

            parentView.addView(ll);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            ArrayList<Student> studentArrayList = StudentDB.getOurInstance().getStudents();
            Student student = new Student(firstName.getText().toString(), lastName.getText().toString(), CWID.getText().toString());
            courses.add(new Course(newClass.getText().toString(), grade.getText().toString()));
            student.setCourses(courses);
            studentArrayList.add(student);
            StudentDB.getOurInstance().setStudents(studentArrayList);

        }
        return super.onKeyDown(keyCode, event);
    }

}
