package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fac.Model.TaiKhoan;

public class RegistrationActivity extends AppCompatActivity {
    EditText edtTaikhoan,edtMatkhau_dk,edtnlMatkhau,edtsdt;
    Button btnDangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        AnhXa();
        Event();
    }

    private void Event() {
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sTaiKhoan = edtTaikhoan.getText().toString();
                String sMatKhau = edtMatkhau_dk.getText().toString();
                String sNLMatKhau = edtnlMatkhau.getText().toString();
                int sSDT = Integer.parseInt(edtsdt.getText().toString());

                if (sTaiKhoan == null || sTaiKhoan.equals("")){
                    Toast.makeText(RegistrationActivity.this, "Vui lòng nhập tài khoản !", Toast.LENGTH_LONG).show();
                } else if (sMatKhau == null || sMatKhau.equals("")) {
                    Toast.makeText(RegistrationActivity.this, "Vui lòng nhập mật khẩu !", Toast.LENGTH_SHORT).show();
                } else if (sMatKhau != sNLMatKhau) {
                    Toast.makeText(RegistrationActivity.this, "Mật khẩu không khớp ! " + sNLMatKhau + " bang " + sMatKhau , Toast.LENGTH_SHORT).show();
                }else if (String.valueOf(sSDT).length() != 10) {
                    Toast.makeText(RegistrationActivity.this, "Số điện thoại không hợp lệ !", Toast.LENGTH_SHORT).show();
                }else {
                    TaiKhoan taiKhoan = new TaiKhoan();
                    taiKhoan.setTENTK(sTaiKhoan);
                    taiKhoan.setMATKHAU(sMatKhau);
                    taiKhoan.setSDT(sSDT);

                    long kiemtra = MainActivity.database.ThemTaiKhoan(taiKhoan);
                    if (kiemtra != 0){
                        Toast.makeText(RegistrationActivity.this, "Thêm thành công !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Thêm thất bại !", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void AnhXa() {
        edtTaikhoan = findViewById(R.id.edtTaikhoan);
        edtMatkhau_dk = findViewById(R.id.edtMatkhau_dk);
        edtnlMatkhau = findViewById(R.id.edtnlMatkhau);
        edtsdt = findViewById(R.id.edtsdt);
        btnDangnhap = findViewById(R.id.btnDangnhap);
    }
}