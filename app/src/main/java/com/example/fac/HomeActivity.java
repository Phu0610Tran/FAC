package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fac.SOTIETKIEM.SoTietKiem;
import com.example.fac.TROLYTAICHINH.TroLyTaiChinhActivity;
import com.example.fac.VUICUNGTAICHINH.VuiCungTaiChinhActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    Button vctc,tltc,sotietkiem;
    CircleImageView img_tk_home;
    TextView tentk_home,dangxuat_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AnhXa();
        Events();
        Getdata();

    }

    private void Getdata() {
        tentk_home.setText(MainActivity.taiKhoan.getTENTK());
        if (MainActivity.taiKhoan.getHINHANH()!=null){
            byte[] hinhAnh = MainActivity.taiKhoan.getHINHANH();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0, hinhAnh.length);
            img_tk_home.setImageBitmap(bitmap);
        }else {
            img_tk_home.setImageResource(R.drawable.user);
        }
    }

    private void Events() {
        vctc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, VuiCungTaiChinhActivity.class));
            }
        });
        dangxuat_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });
        tltc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TroLyTaiChinhActivity.class));
            }
        });
        sotietkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SoTietKiem.class));

            }
        });
    }

    private void AnhXa() {
        sotietkiem = findViewById(R.id.sotietkiem);
        tltc = findViewById(R.id.tltc);
        dangxuat_home = findViewById(R.id.dangxuat_home);
        vctc = findViewById(R.id.vctc);
        tentk_home = findViewById(R.id.tentk_home);
        img_tk_home = findViewById(R.id.img_tk_home);
    }
}