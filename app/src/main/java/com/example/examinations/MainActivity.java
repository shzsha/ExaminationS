package com.example.examinations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button studentBtn;
    Button instructorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StudentApp(View view) {
        studentBtn = (Button) findViewById(R.id.studentBTN);
        Intent intent = new Intent(MainActivity.this, StudentLogin.class);
        startActivity(intent);


    }

    public void InstructorApp(View view){
        instructorBtn = (Button) findViewById(R.id.instructorBTN);
        Intent intent = new Intent(MainActivity.this, InstructorLogin.class);
        startActivity(intent);
    }


}