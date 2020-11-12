package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WelcomeAnimation extends AppCompatActivity {

    private Animation topAnimation,bottonAnimation;
    private TextView welcome,tittle,subtittle,d,dName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_animation);

        welcome=findViewById(R.id.tv1);
        tittle=findViewById(R.id.tv2);
        subtittle=findViewById(R.id.tv3);
        d=findViewById(R.id.tv4);
        dName=findViewById(R.id.tv5);

        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottonAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        welcome.setAnimation(topAnimation);
        tittle.setAnimation(topAnimation);
        subtittle.setAnimation(bottonAnimation);
        d.setAnimation(bottonAnimation);
        dName.setAnimation(bottonAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeAnimation.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);



    }
}