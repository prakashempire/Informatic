package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private EditText Name, Email, MobileNo, Password;
    private Button Register, Back;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String User_Name, User_Email, User_Mobilenumber, User_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth=FirebaseAuth.getInstance();
        //FindfViewById();
        Name = findViewById(R.id.etUserName);
        Email = findViewById(R.id.etUserEmail);
        MobileNo = findViewById(R.id.etUserMobileNumb);
        Password = findViewById(R.id.etUserPassword);
        Register = findViewById(R.id.btnUserRegister);
        Back = findViewById(R.id.tvUserAlreadyRegister);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validate()){
                    User_Name=Name.getText().toString().trim();
                    User_Email=Email.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(User_Email,User_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                UploadDetails();
                                Toast.makeText(RegistrationActivity.this,"Registration Successfull!",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegistrationActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                            else{
                                Toast.makeText(RegistrationActivity.this,"Server Busy Try Again Later!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public Boolean Validate() {

        Name = findViewById(R.id.etUserName);
        Email = findViewById(R.id.etUserEmail);
        MobileNo = findViewById(R.id.etUserMobileNumb);
        Password = findViewById(R.id.etUserPassword);


        User_Name =Name.getText().toString().trim();
        User_Email =Email.getText().toString().trim();
        User_Mobilenumber =MobileNo.getText().toString().trim();
        User_Password =Password.getText().toString().trim();

        if(User_Name.isEmpty() || User_Email.isEmpty() || User_Mobilenumber.isEmpty() || User_Password.isEmpty()){
            Toast.makeText(RegistrationActivity.this,"Required to Fill all the Above!!!",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private void FindfViewById() {
        Name = findViewById(R.id.etUserName);
        Email = findViewById(R.id.etUserEmail);
        MobileNo = findViewById(R.id.etUserMobileNumb);
        Password = findViewById(R.id.etUserPassword);
        Register = findViewById(R.id.btnUserRegister);
        Back = findViewById(R.id.tvUserAlreadyRegister);
    }
    private void UploadDetails(){

        Name=findViewById(R.id.etUserName);
        Email=findViewById(R.id.etUserEmail);
        MobileNo=findViewById(R.id.etUserMobileNumb);
        Password=findViewById(R.id.etUserPassword);
        Register=findViewById(R.id.btnUserRegister);
        Back=findViewById(R.id.tvUserAlreadyRegister);


        User_Name=Name.getText().toString().trim();
        User_Email=Email.getText().toString().trim();
        User_Mobilenumber=MobileNo.getText().toString().trim();
        User_Password=Password.getText().toString().trim();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("User");

        Users user=new Users(User_Name,User_Email,User_Mobilenumber,User_Password);
        databaseReference.child(firebaseAuth.getUid()).child(firebaseAuth.getUid()).setValue(user);
    }
}