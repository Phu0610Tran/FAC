package com.example.fac.TROLYTAICHINH;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.fac.R;

public class TienDo_Activity extends AppCompatActivity {
    LinearLayout test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tien_do);
        test = findViewById(R.id.test);
    }
}