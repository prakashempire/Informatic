package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ImeiActivity extends AppCompatActivity {
    LinearLayout ImeiShowbtn,ImeiCreatebtn;
    Button btnCraeteback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imei);

        ImeiShowbtn=findViewById(R.id.ImeiShowbtn);
        ImeiCreatebtn=findViewById(R.id.ImeiCreatebtn);
        btnCraeteback=findViewById(R.id.btnCraeteback);

        ImeiShowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImeiActivity.this,ImeiShowActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ImeiCreatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImeiActivity.this,ImeiCreateActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btnCraeteback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImeiActivity.this,ListViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}