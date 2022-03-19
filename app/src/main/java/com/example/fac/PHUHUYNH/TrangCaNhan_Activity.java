package com.example.fac.PHUHUYNH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fac.Adapter.BanTinAdapter;
import com.example.fac.MainActivity;
import com.example.fac.Model.BaiViet;
import com.example.fac.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrangCaNhan_Activity extends AppCompatActivity {
    EditText edt_noidungbv;
    LinearLayout lnDangbai;
    CircleImageView img_avata_tcn;
    GridView gridview_tcn;
    TextView ten_avata_tcn;
    ImageView quaylai_tcn;
    ArrayList<BaiViet> baiVietArrayList;
    BanTinAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);
        AnhXa();
        baiVietArrayList = new ArrayList<>();
        adapter = new BanTinAdapter(TrangCaNhan_Activity.this,R.layout.bangtin_layout,baiVietArrayList);
        gridview_tcn.setAdapter(adapter);
        GetData();
    }

    private void GetData() {
        Cursor cursor = MainActivity.database.Getdata("SELECT IDBV,IDTK,TENTAIKHOAN,TIEUDE,NOIDUNG,DATE,A.HINHANH,B.HINHANH,THICH,KHONGTHICH " +
                "FROM BAIVIET A,TAIKHOAN B " +
                "WHERE A.IDTK = B.IDTAIKHOAN AND A.IDTK =  " + MainActivity.taiKhoan.getMATK());
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
        quaylai_tcn =findViewById(R.id.quaylai_tcn);
        ten_avata_tcn =findViewById(R.id.ten_avata_tcn);
        img_avata_tcn = findViewById(R.id.img_avata_tcn);
        Bitmap bitmap = BitmapFactory.decodeByteArray(MainActivity.taiKhoan.getHINHANH(),0, MainActivity.taiKhoan.getHINHANH().length);
        img_avata_tcn.setImageBitmap(bitmap);
        ten_avata_tcn.setText("Phụ huynh-" + MainActivity.taiKhoan.getTENTK());
        gridview_tcn = findViewById(R.id.gridview_tcn);
        lnDangbai = findViewById(R.id.lnDangbai);

        edt_noidungbv = findViewById(R.id.edt_noidungbv);
        edt_noidungbv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                startActivity(new Intent(TrangCaNhan_Activity.this,DangBaiActivity.class));

            }
        });
        lnDangbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrangCaNhan_Activity.this,DangBaiActivity.class));

            }
        });
        quaylai_tcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrangCaNhan_Activity.this,Home_PhuHuynh.class));
            }
        });
    }
}