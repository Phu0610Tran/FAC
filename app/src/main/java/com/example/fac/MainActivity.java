package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fac.Data.Database;
import com.example.fac.Model.TaiKhoan;

public class MainActivity extends AppCompatActivity {
    public static TaiKhoan taiKhoan = new TaiKhoan();
    Button btn_dangnhap,btn_dangky;
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(this,"FAC",null,2);
        database.QueryData("CREATE TABLE IF NOT EXISTS DoAn(Id INTEGER PRIMARY KEY AUTOINCREMENT" +
        ", Ten VARCHAR(150), MoTa VARCHAR(250), HinhAnh BLOB)");
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        Anhxa();
        Events();
        finish();
    }

    private void Events() {
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//        btn_dangky.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
//            }
//        });
    }

    private void Anhxa() {
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
//        btn_dangky = findViewById(R.id.btn_dangky);
    }
}