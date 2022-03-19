package com.example.fac.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fac.MainActivity;
import com.example.fac.Model.BinhLuan;
import com.example.fac.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BinhLuanAdapter extends RecyclerView.Adapter<BinhLuanAdapter.viewholder> {

    public static ArrayList<BinhLuan> listBL;

    public BinhLuanAdapter() {

    }
    public BinhLuanAdapter(ArrayList<BinhLuan> listBL) {
        this.listBL = listBL;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.binhluan,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        BinhLuan binhLuan = listBL.get(holder.getAdapterPosition());

        Bitmap bitmap = BitmapFactory.decodeByteArray(binhLuan.getHinhBL(),0,binhLuan.getHinhBL().length);
        holder.img_Hinh_binhluan.setImageBitmap(bitmap);
        holder.txt_NoiDung_binhluan.setText(binhLuan.getNoidungBL());
        holder.txtV_ThoiGian_binhluan.setText(String.valueOf(binhLuan.getThoiGianBL()));
        holder.txtV_Ten_chatbox.setText(MainActivity.database.Layten( binhLuan.getTaiKhoanBL()));
    }

    @Override
    public int getItemCount() {
        if (listBL!=null){
            return listBL.size();
        }
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        CircleImageView img_Hinh_binhluan;
        TextView txt_NoiDung_binhluan,txtV_ThoiGian_binhluan,txtV_Ten_chatbox;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtV_Ten_chatbox = itemView.findViewById(R.id.txtV_Ten_chatbox);
            img_Hinh_binhluan = itemView.findViewById(R.id.img_Hinh_chatbox);
            txt_NoiDung_binhluan = itemView.findViewById(R.id.txt_NoiDung_chatbox);
            txtV_ThoiGian_binhluan = itemView.findViewById(R.id.txtV_ThoiGian_chatbox);
        }
    }
}
