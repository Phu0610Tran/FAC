package com.example.fac.TROLYTAICHINH;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fac.R;

public class LapKeHoach_Activity extends AppCompatActivity {
    Button xacnhan_lapkehoach;
    EditText edt_sotien,edt_thoigian;
    TextView haituan,motthang,haithang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_ke_hoach);
        AnhXa();
        Events();
    }

    private void Events() {
        xacnhan_lapkehoach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(LapKeHoach_Activity.this, ChotKeHoach_Activity.class));
                showDialog();
            }
        });
        haituan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_thoigian.setText("2 tuần");
            }
        });
        haithang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_thoigian.setText("2 tháng");
            }
        });
        motthang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_thoigian.setText("1 tháng");
            }
        });

    }

    private void AnhXa() {
        edt_sotien = findViewById(R.id.edt_sotien);
        edt_thoigian = findViewById(R.id.edt_thoigian);
        xacnhan_lapkehoach = findViewById(R.id.xacnhan_lapkehoach);
        haituan = findViewById(R.id.haituan);
        motthang = findViewById(R.id.motthang);
        haithang = findViewById(R.id.haithang);
    }
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_chotkehoach,null);
        final EditText edt_dialog_ten = view.findViewById(R.id.edt_dialog_ten);
        final Button xacnhan_dialog = view.findViewById(R.id.xacnhan_dialog);
        builder.setView(view);
        xacnhan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_dialog_ten.setText("hay quá");
            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}