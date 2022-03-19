package com.example.fac.PHUHUYNH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fac.R;
import com.example.fac.TROLYTAICHINH.ThanhTich_Activity;
import com.example.fac.VUICUNGTAICHINH.XepHang_Activity;

public class HoatDongCuaCon extends AppCompatActivity {
    ImageView thoigianonline_tdc,kehoachtietkiem,kehoachdautu,thanhtich_theodoicon,bangxephang_tdc,lichhoc,quaylai_tdc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoat_dong_cua_con);
        AnhXa();
        Events();
    }

    private void Events() {
        bangxephang_tdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HoatDongCuaCon.this, XepHang_Activity.class));
            }
        });
        thanhtich_theodoicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HoatDongCuaCon.this, ThanhTich_Activity.class));
            }
        });
        quaylai_tdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HoatDongCuaCon.this,Home_PhuHuynh.class));
            }
        });
    }

    private void AnhXa() {
        quaylai_tdc = findViewById(R.id.quaylai_tdc);
        thoigianonline_tdc = findViewById(R.id.thoigianonline_tdc);
        kehoachtietkiem = findViewById(R.id.kehoachtietkiem);
        kehoachdautu = findViewById(R.id.kehoachdautu);
        thanhtich_theodoicon = findViewById(R.id.thanhtich_theodoicon);
        bangxephang_tdc = findViewById(R.id.bangxephang_tdc);
        lichhoc = findViewById(R.id.lichhoc);
    }
}