package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class VuiCungTaiChinhActivity extends AppCompatActivity {
    ImageButton btn_choingay;
    Button btn_huongdan,btnbanbe,btn_bangxephang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vui_cung_tai_chinh);
        AnhXa();
        Events();
    }

    private void Events() {
        btn_choingay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VuiCungTaiChinhActivity.this,ChoiNgayActivity.class));
            }
        });
        btn_bangxephang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VuiCungTaiChinhActivity.this,BangXepHangActivity.class));
            }
        });
        btnbanbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VuiCungTaiChinhActivity.this,BanBeActivity.class));
            }
        });
    }




    private void AnhXa() {
        btn_choingay = findViewById(R.id.btn_choingay);
        btn_huongdan = findViewById(R.id.btn_huongdan);
        btnbanbe = findViewById(R.id.btnbanbe);
        btn_bangxephang = findViewById(R.id.btn_bangxephang);
    }
}