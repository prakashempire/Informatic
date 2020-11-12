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
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ImeiCreateActivity extends AppCompatActivity {

    private EditText etImeiCreateName,etImeiCreateno1,etImeiCreateno2;
    private Button btnimeicreateAdd,btnimeiCreateback;
    Task<Void> databaseReference;
    FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imei_create);

        etImeiCreateName=findViewById(R.id.etImeiCreateName);
        etImeiCreateno1=findViewById(R.id.etImeiCreateno1);
        etImeiCreateno2=findViewById(R.id.etImeiCreateno2);
        btnimeicreateAdd=findViewById(R.id.btnimeicreateAdd);
        btnimeiCreateback=findViewById(R.id.btnimeiCreateback);

        String gacName=etImeiCreateName.getText().toString();
        String gacNo1=etImeiCreateno1.getText().toString();
        String gacNo2=etImeiCreateno2.getText().toString();
        btnimeiCreateback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImeiCreateActivity.this,ImeiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnimeicreateAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateImei()) {
                    adddetails();
                }
            }
        });

    }

    private void adddetails() {
        String gacName=etImeiCreateName.getText().toString();
        String gacNo1=etImeiCreateno1.getText().toString();
        String gacNo2=etImeiCreateno2.getText().toString();


        HashMap<String,Object> map=new HashMap<>();
        map.put("PHONE NAME",gacName);
        map.put("IMEI NO1",gacNo1);
        map.put("IMEI NO2",gacNo2);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User").child(firebaseAuth.getUid()).child("IMEIDetails").child(gacNo1).updateChildren(map);
        Toast.makeText(ImeiCreateActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(ImeiCreateActivity.this,ImeiActivity.class);
        startActivity(intent);
        finish();

    }

    private boolean validateImei(){
        String s1=etImeiCreateName.getText().toString();
        String s2=etImeiCreateno1.getText().toString();
        String s3=etImeiCreateno2.getText().toString();

        if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty()){
            Toast.makeText(ImeiCreateActivity.this, "field can't be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }

    }
}