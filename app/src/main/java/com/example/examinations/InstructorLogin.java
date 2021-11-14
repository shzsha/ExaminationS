package com.example.examinations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class InstructorLogin extends AppCompatActivity {
        TextView username;
    TextView password ;
    TextView wrongCred;
   // FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_login);
        password = (TextView) findViewById(R.id.Password);
        username = (TextView) findViewById(R.id.username);
        wrongCred = (TextView) findViewById(R.id.wrongCred);
    }

    public void Login(View view) {
     // rootNode = FirebaseDatabase.getInstance();
       reference = FirebaseDatabase.getInstance().getReference();

        String usernameByUser = username.getText().toString();
        String passwordByUser = password.getText().toString();

        //Query checkUser = reference.orderByChild("username").equalTo(usernameByUser);
        Toast.makeText(InstructorLogin.this, reference.orderByChild("username").toString(),
                Toast.LENGTH_LONG).show();




        ValueEventListener instructorsListener = new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String passwordByDB = dataSnapshot.child(usernameByUser).getValue(String.class);
                    Toast.makeText(InstructorLogin.this, passwordByDB,
                            Toast.LENGTH_LONG).show();

                   /* if(passwordByDB.equals(passwordByUser)){
                        Intent intent = new Intent(InstructorLogin.this, InstructorMain.class);
                        intent.putExtra("welcomeName", usernameByUser);
                        startActivity(intent);
                    }
                    else {
                        wrongCred.setVisibility(TextView.VISIBLE);
                        password.requestFocus();
                    }*/

                }
                else {
                    Toast.makeText(InstructorLogin.this, "No such user exist..!",
                            Toast.LENGTH_LONG).show();
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(InstructorLogin.this, "onCancelled..!",
                        Toast.LENGTH_LONG).show();
            }

        };

       reference.addValueEventListener(instructorsListener);




    }

}