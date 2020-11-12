package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DeveloperInfo extends AppCompatActivity {

    ImageView call,insta;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_info);

        call=findViewById(R.id.developerinfoCall);
        insta=findViewById(R.id.developerinfoInsta);
        home=findViewById(R.id.developerinfoHome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeveloperInfo.this,ListViewActivity.class));
                finish();
            }
        });
    }
}