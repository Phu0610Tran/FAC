package com.example.fac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fac.PHUHUYNH.BinhLuanActivity;
import com.example.fac.MainActivity;
import com.example.fac.Model.BaiViet;
import com.example.fac.R;

import java.util.List;

public class BanTinAdapter extends BaseAdapter {

    private int layout;
    private Context context;
    public static List<BaiViet> baiVietList;
    int id;

    public BanTinAdapter(Context context, int layout, List<BaiViet> baiVietList) {
        this.context = context;
        this.layout = layout;
        this.baiVietList = baiVietList;
    }

    @Override
    public int getCount() {
        return baiVietList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    static class ViewHolder{
        boolean isdisLike, isLike;
        ImageView avata_img,img_bangtin,img_like_bantin,img_dislike_bantin;
        LinearLayout layout1,layout2;
        TextView tentk_bantin,gio_bantin,noidung_bantin,txt_luotlike_bantin,txt_luotdislike_bantin;
        LinearLayout binhluan;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tentk_bantin = (TextView) view.findViewById(R.id.tentk_bantin);
            holder.gio_bantin = (TextView) view.findViewById(R.id.gio_bantin);
            holder.noidung_bantin = (TextView) view.findViewById(R.id.noidung_bantin);
            holder.txt_luotlike_bantin = (TextView) view.findViewById(R.id.txt_luotlike_bantin);
            holder.txt_luotdislike_bantin = (TextView) view.findViewById(R.id.txt_luotdislike_bantin);
            holder.avata_img = (ImageView) view.findViewById(R.id.avata_img);
            holder.img_bangtin = (ImageView) view.findViewById(R.id.img_bangtin);
            holder.img_like_bantin = (ImageView) view.findViewById(R.id.img_like_bantin);
            holder.layout1 = (LinearLayout) view.findViewById(R.id.layout1);
            holder.layout2 = (LinearLayout) view.findViewById(R.id.layout2);
            holder.img_dislike_bantin = (ImageView) view.findViewById(R.id.img_dislike_bantin);
            holder.binhluan = (LinearLayout)view.findViewById(R.id.binhluan);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        BaiViet baiViet = baiVietList.get(i);
        // load like
        holder.img_like_bantin.setImageResource(R.drawable.ic_thumb_up_black_48dp);
        holder.img_dislike_bantin.setImageResource(R.drawable.ic_thumb_down_off_alt_black_48dp);

        if (MainActivity.database.isDaLike(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK()) == 1){
            holder.isLike = true;
            holder.isdisLike = false;
            holder.img_like_bantin.setImageResource(R.drawable.like);
        } else if(MainActivity.database.isDaLike(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK()) == 2){
            holder.isdisLike = true;
            holder.isLike = false;
            holder.img_dislike_bantin.setImageResource(R.drawable.dislike);
        }
        // sự kiện like và không like

        holder.layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isLike == true){
                    holder.img_like_bantin.setImageResource(R.drawable.ic_thumb_up_black_48dp);
                    MainActivity.database.xoathem(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK(), 1);
                    holder.txt_luotlike_bantin.setText(String.valueOf(Integer.valueOf(holder.txt_luotlike_bantin.getText().toString())-1));
                }else {
                    if(holder.isdisLike == true){
                        holder.img_dislike_bantin.setImageResource(R.drawable.ic_thumb_down_off_alt_black_48dp);
                        MainActivity.database.xoathem(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK(), 2);
                        holder.txt_luotdislike_bantin.setText(String.valueOf(Integer.valueOf(holder.txt_luotdislike_bantin.getText().toString())-1));
                        holder.isdisLike = !holder.isdisLike;
                    }
                    holder.img_like_bantin.setImageResource(R.drawable.like);
                    MainActivity.database.them(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK(), 1);
                    holder.txt_luotlike_bantin.setText(String.valueOf(Integer.valueOf(holder.txt_luotlike_bantin.getText().toString())+1));
                }
                holder.isLike = !holder.isLike;
            }
        });
        holder.layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isdisLike == true){

                    holder.img_dislike_bantin.setImageResource(R.drawable.ic_thumb_down_off_alt_black_48dp);
                    MainActivity.database.xoathem(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK(), 2);
                    holder.txt_luotdislike_bantin.setText(String.valueOf(Integer.valueOf(holder.txt_luotdislike_bantin.getText().toString())-1));
                }else {
                    if(holder.isLike == true){
                        holder.img_like_bantin.setImageResource(R.drawable.ic_thumb_up_black_48dp);
                        MainActivity.database.xoathem(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK(), 1);
                        holder.txt_luotlike_bantin.setText(String.valueOf(Integer.valueOf(holder.txt_luotlike_bantin.getText().toString())-1));
                        holder.isLike = !holder.isLike;
                    }
                    holder.img_dislike_bantin.setImageResource(R.drawable.dislike);
                    MainActivity.database.them(baiViet.getIDBV(),MainActivity.taiKhoan.getMATK(), 2);
                    holder.txt_luotdislike_bantin.setText(String.valueOf(Integer.valueOf(holder.txt_luotdislike_bantin.getText().toString())+1));
                }
                holder.isdisLike = !holder.isdisLike;
            }
        });


        String ten ;
        holder.txt_luotlike_bantin.setText(String.valueOf(baiViet.getTHICH()));
        holder.txt_luotdislike_bantin.setText(String.valueOf(baiViet.getKHONGTHICH()));
        if(baiViet.getTENTAIKHOAN() == null )
        {
            ten = "Financial assistant for children";
            holder.avata_img.setImageResource(R.drawable.logo);
        }else
        {
            ten = baiViet.getTENTAIKHOAN().toString();
            byte[] hinhAnh = baiViet.getAVATAR();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0, hinhAnh.length);
            holder.avata_img.setImageBitmap(bitmap);
        }
        holder.gio_bantin.setText(baiViet.getDATE());
        holder.tentk_bantin.setText(ten);
        holder.noidung_bantin.setText(baiViet.getNOIDUNG());
        // chuyen byte[] -> ve bitmap
        if (baiViet.getHINHANHBAIVIET()!= null){
            byte[] hinhAnh1 = baiViet.getHINHANHBAIVIET();
            Bitmap bitmap1 = BitmapFactory.decodeByteArray(hinhAnh1,0, hinhAnh1.length);
            holder.img_bangtin.setImageBitmap(bitmap1);
        }


        holder.binhluan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BinhLuanActivity.class);
                intent.putExtra("position",i);
                context.startActivity(intent);
            }
        });
        return view;
    }

}
