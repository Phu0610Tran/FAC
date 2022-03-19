package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoTuoi_Activity extends AppCompatActivity {
    Button test_dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_tuoi);
        test_dt = findViewById(R.id.test_dt);
        test_dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoTuoi_Activity.this,HomeActivity.class));
            }
        });
    }
}