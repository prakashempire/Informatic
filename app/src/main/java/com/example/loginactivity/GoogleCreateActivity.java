package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class GoogleCreateActivity extends AppCompatActivity {
    private EditText Email, Password;
    private Button add, back;
    private FirebaseAuth firebaseAuth;
    private Task<Void> databaseReference;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_create);

        Email = findViewById(R.id.googleEmailid);
        Password = findViewById(R.id.googlePasswordid);
        add = findViewById(R.id.btngoogleAdd);
        back = findViewById(R.id.googleBackid);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(googleValidate()) {
                    uploadGoogledeatails();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GoogleCreateActivity.this,googleActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void uploadGoogledeatails() {

        String s1 = Email.getText().toString();
        String s2 = Password.getText().toString();
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(GoogleCreateActivity.this, "required to fill the above datails", Toast.LENGTH_SHORT).show();
        } else {

            HashMap<String, Object> map = new HashMap<>();

            map.put("Email", s1);
            map.put("Password", s2);

            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("User").child(firebaseAuth.getUid()).child("GoogleAccount").child(s2).updateChildren(map);

            Toast.makeText(GoogleCreateActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(GoogleCreateActivity.this,googleActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private  boolean googleValidate(){
        String s1 = Email.getText().toString();
        String s2 = Password.getText().toString();

        if(s1.isEmpty() || s2.isEmpty()){
            Toast.makeText(GoogleCreateActivity.this, "field can't be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

}