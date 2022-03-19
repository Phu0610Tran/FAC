package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    TextView slogan,tendetai_animation;
    ImageView img_animation;
    Animation topanimation,bottomanimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animation);
        AnhXa();
        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        img_animation.setAnimation(topanimation);
        tendetai_animation.setAnimation(bottomanimation);
        slogan.setAnimation(bottomanimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(AnimationActivity.this,MainActivity.class));
                finish();
            }
        },5000);
    }

    private void AnhXa() {
        slogan = findViewById(R.id.slogan);
        tendetai_animation = findViewById(R.id.tendetai_animation);
        img_animation = findViewById(R.id.img_animation);
    }
}