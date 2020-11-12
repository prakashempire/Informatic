package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AdharActivity extends AppCompatActivity {
    LinearLayout ShowAdharId,CreateAdharId;
    Button btnAdhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhar);

        ShowAdharId=findViewById(R.id.showAdharId);
        CreateAdharId=findViewById(R.id.CreateAdharId);
        btnAdhar=findViewById(R.id.btnAdhar);

        ShowAdharId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdharActivity.this,AdharShowActivity.class);
                startActivity(intent);
                finish();
            }
        });

        CreateAdharId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdharActivity.this,AdharCreateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAdhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdharActivity.this,ListViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}