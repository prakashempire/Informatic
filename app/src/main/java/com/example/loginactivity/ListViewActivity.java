package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ListViewActivity extends AppCompatActivity {
    private RelativeLayout Adhar,google,Imei;
    private Button btnlogoutmain,btncovid19trackerlistView;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        firebaseAuth=FirebaseAuth.getInstance();

        Adhar=findViewById(R.id.Adhar_Click);
        google=findViewById(R.id.GmailAcount_Click);
        Imei=findViewById(R.id.Imei_Click);
        btnlogoutmain=findViewById(R.id.btnlogoutmain);
        btncovid19trackerlistView=findViewById(R.id.btncovid19trackerlistView);


        Adhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListViewActivity.this,AdharActivity.class);
                startActivity(intent);
                finish();
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListViewActivity.this,googleActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Imei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListViewActivity.this,ImeiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnlogoutmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListViewActivity.this,"Signout Successfull",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ListViewActivity.this,MainActivity.class);
                startActivity(intent);
                firebaseAuth.signOut();
                finish();
            }
        });
        btncovid19trackerlistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListViewActivity.this,Covid19Tracker.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuLogout:{
                Toast.makeText(ListViewActivity.this,"Signout Successfull",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ListViewActivity.this,MainActivity.class);
                startActivity(intent);
                firebaseAuth.signOut();
                finish();
                break;
            }

           case R.id.menuDeveloperInfo:{
                Intent intent=new Intent(ListViewActivity.this,DeveloperInfo.class);
                startActivity(intent);
                finish();
                break;
            }

            case R.id.menuProfile:{
                Toast.makeText(ListViewActivity.this,"Our team currently Working you will get the update soon",Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}