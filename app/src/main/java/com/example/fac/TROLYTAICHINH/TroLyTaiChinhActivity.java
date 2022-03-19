package com.example.fac.TROLYTAICHINH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fac.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class TroLyTaiChinhActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_lapkehoach,btn_thanhtich,btn_tiendo,btn_lichsu;
    CircleImageView img_tk_tltc;
    ImageView quaylai_tltc;
    TextView tentk_tltc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trolytaichinh);
        AnhXa();
        Events();
    }

    private void Events() {
        btn_lapkehoach.setOnClickListener(this);
        btn_lichsu.setOnClickListener(this);
        btn_thanhtich.setOnClickListener(this);
        btn_tiendo.setOnClickListener(this);
    }

    private void AnhXa() {
        btn_lapkehoach= findViewById(R.id.btn_lapkehoach);
        btn_thanhtich = findViewById(R.id.btn_thanhtich);
        btn_tiendo = findViewById(R.id.btn_tiendo);
        btn_lichsu = findViewById(R.id.btn_lichsu);
        img_tk_tltc = findViewById(R.id.img_tk_tltc);
        quaylai_tltc = findViewById(R.id.quaylai_tltc);
        tentk_tltc = findViewById(R.id.tentk_tltc);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_lapkehoach:
                startActivity(new Intent(TroLyTaiChinhActivity.this, LapKeHoach_Activity.class));
                break;
            case R.id.btn_lichsu:
                startActivity(new Intent(TroLyTaiChinhActivity.this, LichSu_Activity.class));
                break;
            case R.id.btn_thanhtich:
                startActivity(new Intent(TroLyTaiChinhActivity.this, ThanhTich_Activity.class));
                break;
            case R.id.btn_tiendo:
                startActivity(new Intent(TroLyTaiChinhActivity.this, TienDo_Activity.class));
                break;

        }
    }
}