package com.example.attendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectUserCategoryActivity extends AppCompatActivity {

    Button mButtonAdmin;
    Button mButtonUniversity;
    Button mButtonTeacher;
    Button mButtonStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user_category);

        mButtonAdmin = (Button)findViewById(R.id.button_admin);
        mButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminIntent = new Intent(SelectUserCategoryActivity.this,AdminActivity.class);
                startActivity(adminIntent);
            }
        });

        mButtonUniversity = (Button)findViewById(R.id.button_university);
        mButtonUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent universityIntent = new Intent(SelectUserCategoryActivity.this,UniversityActivity.class);
                startActivity(universityIntent);
            }
        });

        mButtonTeacher = (Button)findViewById(R.id.button_teacher);
        mButtonTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teacherIntent = new Intent(SelectUserCategoryActivity.this,TeacherActivity.class);
                startActivity(teacherIntent);
            }
        });

        mButtonStudent = (Button)findViewById(R.id.button_student);
        mButtonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent studentIntent = new Intent(SelectUserCategoryActivity.this,StudentActivity.class);
                startActivity(studentIntent);
            }
        });

    }
}
