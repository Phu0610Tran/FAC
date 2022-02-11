package com.example.fac.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.example.fac.Model.TaiKhoan;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Truy vấn không trả kết quả: INSERT, CREATE, UPDATE, DELETE, ...
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    // Truy vấn có trả kết quả: SELECT
    public Cursor Getdata(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    public long ThemTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_TENTAIKHOAN, taiKhoan.getTENTK());
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_MATKHAU, taiKhoan.getMATKHAU());
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_SDT, taiKhoan.getSDT());
//        contentValues.put(CreateDatabase.tbl_TAIKHOAN_EMAIL, taiKhoan.getEMAIL());
//        contentValues.put(CreateDatabase.tbl_TAIKHOAN_NGAYSINH, taiKhoan.getNGAYSINH());
        contentValues.put(CreateDatabase.tbl_TAIKHOAN_LOAITK,1);
        long kiemtra = database.insert(CreateDatabase.tbl_TAIKHOAN, null, contentValues);
        return kiemtra;
    }
    public TaiKhoan KiemTraDangNhap(String tendangnhap, String matkhau){
        String truyvan = "SELECT * FROM " + CreateDatabase.tbl_TAIKHOAN + " WHERE " + CreateDatabase.tbl_TAIKHOAN_TENTAIKHOAN + " = '" + tendangnhap
                + "' AND " + CreateDatabase.tbl_TAIKHOAN_MATKHAU + " = '" + matkhau + "'";

        Cursor cursor = Getdata(truyvan);
        while(cursor.moveToNext()){
            return new TaiKhoan(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getString(7),
                    cursor.getBlob(8)

            );
        }
        return null;
//        if (cursor.getCount() != 0){
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
