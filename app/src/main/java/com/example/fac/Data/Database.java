package com.example.fac.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.example.fac.Model.BinhLuan;
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

    public boolean VONGTONTAI(int IDTK,float VONG){
        Cursor tro = Getdata("SELECT * FROM VONGCHINH WHERE IDTK = " + IDTK + " AND VONG = " + VONG );
        while (tro.moveToNext()) {
            return false;
        }
        return true;
    }

    public void VONGGAME(int IDTK,float VONG, int SOSAO){
        if(VONGTONTAI(IDTK, VONG)){
            QueryData("INSERT INTO VONGCHINH ( IDTK, VONG, SOSAO ) VALUES ( " + IDTK + " , " + VONG + " , "
                    + SOSAO + ")");
        }
        else {
            QueryData("UPDATE VONGCHINH SET SOSAO = " + SOSAO + "   WHERE IDTK = " + IDTK + " AND VONG = " + VONG);
        }
    }

    public void Tangdiem(int IDTK, int diem){
        QueryData("UPDATE TAIKHOAN SET DIEM = " + diem + "   WHERE IDTAIKHOAN = " + IDTK);

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
                    cursor.getBlob(8),
                    cursor.getInt(9)

            );
        }
        return null;
//        if (cursor.getCount() != 0){
//            return true;
//        } else {
//            return false;
//        }
    }
    public int isDaLike(int IDBV, int IDTK){
        Cursor cursor = Getdata("SELECT TRANGTHAI FROM LUOTDANHGIA WHERE IDBV = " + IDBV + " AND IDTK = " + IDTK );
        while (cursor.moveToNext()){
            return cursor.getInt(0);
        }
        return -1;
    }
    public void Dangbai(int IDTK, String NOIDUNG, String THOIGIAN, byte[] HinhAnh){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put("IDTK",    IDTK);
        cv.put("NOIDUNG",   NOIDUNG);
        cv.put("DATE",   THOIGIAN);
        cv.put("HINHANH",   HinhAnh);
        cv.put("THICH",   0);
        cv.put("KHONGTHICH",   0);
        database.insert( "BAIVIET", null, cv );
    }
    public void ThemBL(int IDTK, int IDBV, String NOIDUNG, String THOIGIAN){
        QueryData("INSERT INTO BINHLUAN (IDBV,IDTK,NOIDUNG,THOIGIAN) VALUES (" +IDBV + ",'" +
                IDTK + "','" + NOIDUNG+"','" + THOIGIAN + "')");
    }
    public ArrayList<BinhLuan> LayBinhLuan(int IDBV){
        ArrayList<BinhLuan> list = new ArrayList<>();
        Cursor tro = Getdata("SELECT A.IDTK,B.HINHANH,A.NOIDUNG,A.THOIGIAN FROM BINHLUAN A,TAIKHOAN B WHERE A.IDTK = B.IDTAIKHOAN AND A.IDBV =" + IDBV +"");
        while (tro.moveToNext()){
            list.add(new BinhLuan(
                    tro.getInt(0),
                    tro.getBlob(1),
                    tro.getString(2),
                    tro.getString(3)
            ));
        }

        return list;
    }
    public int demsoBL(int IDBV ){
        Cursor cursor = Getdata("SELECT count(IDBV) FROM BINHLUAN WHERE IDBV =" + IDBV +" GROUP by IDBV");
        while (cursor.moveToNext()){
            return cursor.getInt(0);
        }
        return 0;
    }
    public String Layten(int IDTK){
        Cursor cursor = Getdata("SELECT TENTAIKHOAN FROM TAIKHOAN WHERE IDTAIKHOAN = "+ IDTK);
        cursor.moveToNext();
        return cursor.getString(0);
    }
    public void them(int IDBV, int IDTK, int THICH){
        if(THICH == 1){
            QueryData("UPDATE BAIVIET SET THICH = THICH + " + 1 + " WHERE IDBV = " + IDBV);
        }
        else if(THICH == 2 )
        {
            QueryData("UPDATE BAIVIET SET KHONGTHICH = KHONGTHICH + " + 1 + " WHERE IDBV = " + IDBV);
        }

        QueryData("INSERT INTO LUOTDANHGIA( IDTK, IDBV, TRANGTHAI) VALUES (" +
                IDTK + "," + IDBV + " , " + THICH + ")");
    }

    public void xoathem(int IDBV, int IDTK, int THICH){
        if(THICH == 1){
            QueryData("UPDATE BAIVIET SET THICH = THICH - " + 1 + " WHERE IDBV = " + IDBV + "");
        }
        else if(THICH == 2 )
        {
            QueryData("UPDATE BAIVIET SET KHONGTHICH = KHONGTHICH - " + 1 + " WHERE IDBV = " + IDBV + "");
        }

        QueryData("DELETE FROM LUOTDANHGIA WHERE IDBV = " + IDBV + " AND IDTK = " + IDTK);
    }
    public boolean TonTaiBanBe(int IDTK,int IDBAN)
    {
        Cursor tro = Getdata("SELECT * FROM BANBE WHERE IDTK_CHINH = " + IDTK + " AND IDTK_BAN = " + IDBAN );
        while (tro.moveToNext()) {
            return false;
        }
        return true;
    }
    public int Solike(String IDBV, int THICH){
        if(THICH == 1)
        {
            Cursor cursor = Getdata("SELECT THICH FROM LUOTDANHGIA WHERE IDBV = '" + IDBV + "'");
            cursor.moveToNext();
            return cursor.getInt(0);

        }else if(THICH == 2)
        {
            Cursor cursor = Getdata("SELECT KHONGTHICH FROM LUOTDANHGIA WHERE IDBV = '" + IDBV + "'");
            cursor.moveToNext();
            return cursor.getInt(0);
        }
        return -1;
    }

    public void ThemBan(int IDTK,int IDBAN){
        QueryData("INSERT INTO BANBE ( IDTK_CHINH, IDTK_BAN) VALUES ( " + IDTK + " , " + IDBAN + ")");
    }
    public void XoaBan(int IDTK,int IDBAN){
        QueryData(" DELETE FROM BANBE WHERE IDTK_CHINH = " + IDTK + " AND IDTK_BAN = " + IDBAN);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
