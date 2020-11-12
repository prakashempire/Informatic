package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private EditText Email,Password;
    private TextView ForgotPassword,Register,temporaryEmailandpassword;
    private Button Login,btnCovid19trackerLonin;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private String User_Email,User_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViewById();
        progressDialog=new ProgressDialog(this);

        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();

        if(user!=null){
            finish();
            startActivity(new Intent(MainActivity.this,ListViewActivity.class));

        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validate()){
                    progressDialog.setMessage("Check The Internet is Properly Connected !!!");
                    progressDialog.show();
                    firebaseAuth.signInWithEmailAndPassword(User_Email,User_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this,"Login Successfull!!!",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(MainActivity.this,ListViewActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this,"Email or Password is Wrong! or Our Server is Busy! ",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PasswordResetActivity.class);
                startActivity(intent);
                finish();
            }
        });
        temporaryEmailandpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TemprorymailandPassword.class);
                startActivity(intent);
                finish();
            }
        });

        btnCovid19trackerLonin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Covid19Tracker.class);
                startActivity(intent);
            }
        });

    }

    public Boolean Validate() {
        User_Email= Email.getText().toString().trim();
        User_Password=Password.getText().toString().trim();
        if(User_Email.isEmpty() || User_Password.isEmpty()){
            Toast.makeText(MainActivity.this,"Require to Fill Email And Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private void FindViewById() {
        Email=findViewById(R.id.etEmailorName);

        Password=findViewById(R.id.etPassword);
        Login=findViewById(R.id.btnLogin);
        ForgotPassword=findViewById(R.id.tvForgotPassword);
        Register=findViewById(R.id.tvRegister);
        firebaseAuth=FirebaseAuth.getInstance();
        temporaryEmailandpassword=findViewById(R.id.temporaryEmailandpassword);
        btnCovid19trackerLonin=findViewById(R.id.btnCovid19trackerLonin);
    }
    private boolean validateUserEmail(){
        String val=Email.getText().toString().trim();
        if(val.isEmpty()){
            Email.setEnabled(true);
            Email.setError("Field can't be Empty!");
            return false;
        }
        else{
            Email.setError(null);
            Email.setEnabled(false);
            return true;
        }
    }

}