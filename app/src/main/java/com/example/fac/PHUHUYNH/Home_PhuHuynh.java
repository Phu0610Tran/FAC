package com.example.fac.PHUHUYNH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fac.CongDongPhuHuynh_Activity;
import com.example.fac.LoginActivity;
import com.example.fac.MainActivity;
import com.example.fac.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home_PhuHuynh extends AppCompatActivity {

    Button bangtinfac,trangcanhan,hoatdongcuacon,congdongfac;
    CircleImageView img_tk_home_phuhuynh;
    TextView tentk_home_phuhuynh,dangxuat_home_phuhuynh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_phu_huynh);
        AnhXa();
        Events();
    }

    private void Events() {
        congdongfac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_PhuHuynh.this, CongDongPhuHuynh_Activity.class));
            }
        });
        bangtinfac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_PhuHuynh.this, BangtinFac_Activity.class));
            }
        });
        trangcanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_PhuHuynh.this, TrangCaNhan_Activity.class));
            }
        });
        hoatdongcuacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_PhuHuynh.this, HoatDongCuaCon.class));
            }
        });
        Bitmap bitmap = BitmapFactory.decodeByteArray(MainActivity.taiKhoan.getHINHANH(),0,MainActivity.taiKhoan.getHINHANH().length);
        img_tk_home_phuhuynh.setImageBitmap(bitmap);
        tentk_home_phuhuynh.setText(MainActivity.taiKhoan.getTENTK());
        dangxuat_home_phuhuynh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_PhuHuynh.this, LoginActivity.class));
            }
        });
    }

    private void AnhXa() {
        congdongfac = findViewById(R.id.congdongfac);
        dangxuat_home_phuhuynh = findViewById(R.id.dangxuat_home_phuhuynh);
        tentk_home_phuhuynh = findViewById(R.id.tentk_home_phuhuynh);
        img_tk_home_phuhuynh = findViewById(R.id.img_tk_home_phuhuynh);
        bangtinfac = findViewById(R.id.bangtinfac);
        trangcanhan = findViewById(R.id.trangcanhan);
        hoatdongcuacon = findViewById(R.id.hoatdongcuacon);
    }
}