package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordResetActivity extends AppCompatActivity {
    private EditText Email;
    private Button Back,ResetPassword;
    private FirebaseAuth firebaseAuth;
    private String User_Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        Email=findViewById(R.id.etResetEmail);
        ResetPassword=findViewById(R.id.btnResetPassword);
        Back=findViewById(R.id.btnPasswordResetBack);
        firebaseAuth=FirebaseAuth.getInstance();

        ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_Email=Email.getText().toString().trim();
                if(!User_Email.isEmpty()) {
                    firebaseAuth.sendPasswordResetEmail(User_Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(PasswordResetActivity.this, "PasswordReset Mail was Sended", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(PasswordResetActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(PasswordResetActivity.this, "Enter Valid Id or Server Busy! ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(PasswordResetActivity.this, "Enter Email Id !", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PasswordResetActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private Boolean Validate() {
        if(User_Email.isEmpty()){
            User_Email=Email.getText().toString().trim();
            Toast.makeText(PasswordResetActivity.this,"Required to Fill all the Above!!!",Toast.LENGTH_SHORT).show();
            return  false;
        }
        else{
            return  true;
        }
    }
}