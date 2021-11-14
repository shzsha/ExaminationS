package com.example.examinations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InstructorMain extends AppCompatActivity {
    TextView welcomeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_main);

        welcomeName = findViewById(R.id.welcomeName);
        Intent intent = getIntent();
        String getName = intent.getStringExtra("welcomeName");
        welcomeName.setText(getName);


    }

    public void AddQuiz(View view) {
        Toast.makeText(InstructorMain.this, "Add Quiz..!",
                Toast.LENGTH_LONG).show();
    }

    public void EditQuiz(View view) {
        Toast.makeText(InstructorMain.this, "Edit Quiz..!",
                Toast.LENGTH_LONG).show();
    }

    public void ViewRecords(View view) {
        Toast.makeText(InstructorMain.this, "View Records..!",
                Toast.LENGTH_LONG).show();
    }

    public void Logout(View view) {
        Intent logoutIntent = new Intent(InstructorMain.this, MainActivity.class);
        startActivity(logoutIntent);
    }
}