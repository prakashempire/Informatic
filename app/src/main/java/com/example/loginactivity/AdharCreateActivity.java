package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AdharCreateActivity extends AppCompatActivity {

    EditText acName,acAdharNo,acAddress;
    Button acSave,acCancel;
    String acnName,acnAdharNo,acnAdharAddress;
    Task<Void> databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhar_create);

        acName=findViewById(R.id.etAdharCreateName);
        acAdharNo=findViewById(R.id.etAdharCreateAdharNo);
        acAddress=findViewById(R.id.etAdharCreateAddress);
        acSave=findViewById(R.id.btnAdharCreateSaveId);
        acCancel=findViewById(R.id.btnAdharCreatecancelId);


        acnName=acName.getText().toString();
        acnAdharNo=acAdharNo.getText().toString();
        acnAdharAddress=acAddress.getText().toString();


        acCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdharCreateActivity.this,AdharActivity.class);
                startActivity(intent);
                finish();
            }
        });
        acSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AdharNameValidate()) {
                    saveAdharCreateActivity();
                }
            }
        });
    }
    private void saveAdharCreateActivity() {
        acnName=acName.getText().toString();
        acnAdharNo=acAdharNo.getText().toString();
        acnAdharAddress=acAddress.getText().toString();

        HashMap<String,Object> map=new HashMap<>();
        map.put("Name",acnName);
        map.put("Number",acnAdharNo);
        map.put("Address",acnAdharAddress);

        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User").child(firebaseAuth.getUid()).child("AdharDeatails").child(acnAdharNo).updateChildren(map);
        Toast.makeText(AdharCreateActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(AdharCreateActivity.this,AdharActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean AdharNameValidate(){
        String s1= acName.getText().toString();
        String s2 =acAdharNo.getText().toString();
        String s3 =acAddress.getText().toString();
        if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() ){
            Toast.makeText(AdharCreateActivity.this, "filed can't be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }
}