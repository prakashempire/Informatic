package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class googleActivity extends AppCompatActivity {

    LinearLayout btnGoogleShow,btnGoogleCreate;
    Button btnGoogleback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        btnGoogleShow=findViewById(R.id.btnGoogleShow);
        btnGoogleCreate=findViewById(R.id.btnGoogleCreate);
        btnGoogleback=findViewById(R.id.btnGoogleback);


        btnGoogleCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(googleActivity.this,GoogleCreateActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnGoogleShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(googleActivity.this,GoogleShowActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnGoogleback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(googleActivity.this,ListViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}