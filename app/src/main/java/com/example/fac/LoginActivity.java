package com.example.fac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fac.Model.TaiKhoan;
import com.example.fac.PHUHUYNH.Home_PhuHuynh;

public class LoginActivity extends AppCompatActivity {

    Button btnDangnhap_login;
    EditText edtTaikhoan,edtMatkhau;
    CheckBox cbLuumk;
    TextView txtQuenmk;

    String mUsername = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        AnhXa();
        Events();
    }

    private void Events() {
        btnDangnhap_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtn_Login();
            }
        });
    }
    private void setBtn_Login(){
        String sTentaikhoan = edtTaikhoan.getText().toString();
        String sMatkhau = edtMatkhau.getText().toString();
        TaiKhoan kiemtra = MainActivity.database.KiemTraDangNhap(sTentaikhoan, sMatkhau);

        mUsername = sTentaikhoan;

        if (kiemtra != null){
            MainActivity.taiKhoan = kiemtra;
//            Toast.makeText(getActivity(), "Đăng nhập thành công ! " +LoginActivity.taiKhoan.getMAQUYEN() , Toast.LENGTH_LONG).show();
            if(MainActivity.taiKhoan.getMAQUYEN()==1)

            {
                Intent iTrangchu = new Intent(LoginActivity.this, DoTuoi_Activity.class);

                startActivity(iTrangchu);
            }
            else
            {
                startActivity(new Intent(LoginActivity.this, Home_PhuHuynh.class));
            }

        } else {
            Toast.makeText(this, "Đăng nhập thất bại !", Toast.LENGTH_LONG).show();
        }
    }

    private void AnhXa() {
        txtQuenmk = findViewById(R.id.txtQuenmk);
        cbLuumk = findViewById(R.id.cbLuumk);
        edtMatkhau = findViewById(R.id.edtMatkhau);
        edtTaikhoan = findViewById(R.id.edtTaikhoan);

        btnDangnhap_login = findViewById(R.id.btnDangnhap_login);

    }
}