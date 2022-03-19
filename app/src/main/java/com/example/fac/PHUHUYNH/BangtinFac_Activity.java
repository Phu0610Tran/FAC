package com.example.fac.PHUHUYNH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.fac.Adapter.BanTinAdapter;
import com.example.fac.MainActivity;
import com.example.fac.Model.BaiViet;
import com.example.fac.R;

import java.util.ArrayList;

public class BangtinFac_Activity extends AppCompatActivity {
    GridView gridview_bangtin;
    ArrayList<BaiViet> baiVietArrayList;
    BanTinAdapter adapter;
    ImageView quaylaibantin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangtin_fac);
        AnhXa();
        baiVietArrayList = new ArrayList<>();
        adapter = new BanTinAdapter(BangtinFac_Activity.this,R.layout.bangtin_layout,baiVietArrayList);
        gridview_bangtin.setAdapter(adapter);
        GetData();
    }

    private void GetData() {
        Cursor cursor = MainActivity.database.Getdata("SELECT IDBV,IDTK,TENTAIKHOAN,TIEUDE,NOIDUNG,DATE,A.HINHANH,B.HINHANH,THICH,KHONGTHICH " +
                "FROM BAIVIET A,TAIKHOAN B " +
                "WHERE A.IDTK = B.IDTAIKHOAN AND A.IDTK = 9");
        baiVietArrayList.clear();
        while (cursor.moveToNext())
        {
            baiVietArrayList.add(new BaiViet(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getBlob(6),
                    cursor.getBlob(7),
                    cursor.getInt(8),
                    cursor.getInt(9)
            ));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        GetData();
        super.onStart();
    }

    private void AnhXa() {
        quaylaibantin = findViewById(R.id.quaylaibantin);
        quaylaibantin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BangtinFac_Activity.this,Home_PhuHuynh.class));
            }
        });
        gridview_bangtin = findViewById(R.id.gridview_bangtin);

    }
}