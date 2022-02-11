package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fac.Model.Vong;

import java.util.ArrayList;
import java.util.List;

public class ChoiNgayActivity extends AppCompatActivity {

    ImageButton btn_vong1,btn_vong2,btn_vong3,btn_vong4,btn_vong5;
    TextView txt_vong1,txt_vong2,txt_vong3,txt_vong4,txt_vong5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_ngay);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        AnhXa();
        Event();
        Btn_setEnabled();
        checkvong();
    }

    private void Btn_setEnabled() {
        btn_vong1.setEnabled(false);
        btn_vong2.setEnabled(false);
        btn_vong3.setEnabled(false);
        btn_vong4.setEnabled(false);
        btn_vong5.setEnabled(false);
    }

    private void Event() {
        btn_vong1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(ChoiNgayActivity.this, TracnghiemActivity.class));
        }
         });
        btn_vong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoiNgayActivity.this, TracnghiemActivity.class));
            }
        });
        btn_vong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoiNgayActivity.this, TracnghiemActivity.class));
            }
        });
        btn_vong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoiNgayActivity.this, TracnghiemActivity.class));
            }
        });
        btn_vong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoiNgayActivity.this, TracnghiemActivity.class));
            }
        });

    }

    private void checkvong() {
        List<Vong> a = new ArrayList();
        Cursor cursor = MainActivity.database.Getdata("SELECT VONG,SOSAO FROM VONGCHINH WHERE IDTK = " + MainActivity.taiKhoan.getMATK());
        while (cursor.moveToNext()){
            a.add(new Vong(
                    Float.valueOf(cursor.getString(0)),
                    cursor.getInt(1)
            ));

        }
        //---------------------------
        try {
            checksaovong1(a.get(0).getSOSAO());
            txt_vong1.setText("1");
        }catch (Exception e){
            btn_vong1.setImageResource(R.drawable.phihanhgia_choingay);
            btn_vong1.setEnabled(true);
            return;
        }
        //---------------------------
        try {
            checksaovong2(a.get(1).getSOSAO());
            txt_vong2.setText("2");
        }catch (Exception e){
            btn_vong2.setImageResource(R.drawable.phihanhgia_choingay);
            btn_vong2.setEnabled(true);
            return;
        }
        //---------------------------
        try {
            checksaovong3(a.get(2).getSOSAO());
            txt_vong3.setText("3");
        }catch (Exception e){
            btn_vong3.setImageResource(R.drawable.phihanhgia_choingay);
            btn_vong3.setEnabled(true);
            return;
        };
        //---------------------------
        try {
            checksaovong4(a.get(3).getSOSAO());
            txt_vong4.setText("4");
        }catch (Exception e){
            btn_vong4.setImageResource(R.drawable.phihanhgia_choingay);
            btn_vong4.setEnabled(true);
            return;
        };
        //---------------------------
        try {
            checksaovong5(a.get(4).getSOSAO());
            txt_vong5.setText("5");
        }catch (Exception e){
            btn_vong5.setImageResource(R.drawable.phihanhgia_choingay);
            btn_vong5.setEnabled(true);
            return;
        };



    }

    private void checksaovong2(int sosao) {
        if(sosao == 0){
            btn_vong2.setImageResource(R.drawable.khongsao);
        }else if(sosao == 1){
            btn_vong2.setImageResource(R.drawable.motsao);
        }else if(sosao == 2){
            btn_vong2.setImageResource(R.drawable.haisao);
        }else{
            btn_vong2.setImageResource(R.drawable.basao);
        }
    }
    private void checksaovong3(int sosao) {
        if(sosao == 0){
            btn_vong3.setImageResource(R.drawable.khongsao);
        }else if(sosao == 1){
            btn_vong3.setImageResource(R.drawable.motsao);
        }else if(sosao == 2){
            btn_vong3.setImageResource(R.drawable.haisao);
        }else{
            btn_vong3.setImageResource(R.drawable.basao);
        }
    }
    private void checksaovong4(int sosao) {
        if(sosao == 0){
            btn_vong4.setImageResource(R.drawable.khongsao);
        }else if(sosao == 1){
            btn_vong4.setImageResource(R.drawable.motsao);
        }else if(sosao == 2){
            btn_vong4.setImageResource(R.drawable.haisao);
        }else{
            btn_vong4.setImageResource(R.drawable.basao);
        }
    }
    private void checksaovong5(int sosao) {
        if(sosao == 0){
            btn_vong5.setImageResource(R.drawable.khongsao);
        }else if(sosao == 1){
            btn_vong5.setImageResource(R.drawable.motsao);
        }else if(sosao == 2){
            btn_vong5.setImageResource(R.drawable.haisao);
        }else{
            btn_vong5.setImageResource(R.drawable.basao);
        }
    }
    private void checksaovong1(int sosao) {
        if(sosao == 0){
            btn_vong1.setImageResource(R.drawable.khongsao);
        }else if(sosao == 1){
            btn_vong1.setImageResource(R.drawable.motsao);
        }else if(sosao == 2){
            btn_vong1.setImageResource(R.drawable.haisao);
        }else{
            btn_vong1.setImageResource(R.drawable.basao);
        }
    }


    private void AnhXa() {
        txt_vong5 = findViewById(R.id.txt_vong5);
        txt_vong4 = findViewById(R.id.txt_vong4);
        txt_vong3 = findViewById(R.id.txt_vong3);
        txt_vong2 = findViewById(R.id.txt_vong2);
        txt_vong1 = findViewById(R.id.txt_vong1);
        btn_vong5 = findViewById(R.id.btn_vong5);
        btn_vong1 = findViewById(R.id.btn_vong1);
        btn_vong2 = findViewById(R.id.btn_vong2);
        btn_vong3 = findViewById(R.id.btn_vong3);
        btn_vong4 = findViewById(R.id.btn_vong4);
    }
}