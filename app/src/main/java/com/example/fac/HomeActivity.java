package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button vctc;
    ImageView img_tk_home;
    TextView tentk_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AnhXa();
        Events();
        Getdata();
        if (MainActivity.taiKhoan.getHINHANH()!=null){
            byte[] hinhAnh = MainActivity.taiKhoan.getHINHANH();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0, hinhAnh.length);
            img_tk_home.setImageBitmap(bitmap);
        }else {
            img_tk_home.setImageResource(R.drawable.user);
        }
    }

    private void Getdata() {
        tentk_home.setText(MainActivity.taiKhoan.getTENTK());
    }

    private void Events() {
        vctc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,VuiCungTaiChinhActivity.class));
            }
        });
    }

    private void AnhXa() {
        vctc = findViewById(R.id.vctc);
        tentk_home = findViewById(R.id.tentk_home);
        img_tk_home = findViewById(R.id.img_tk_home);
    }
}