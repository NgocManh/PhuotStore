package com.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phonglinh.phuot.R;
import com.model.SanPham;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder>{

    ArrayList<SanPham> arr;

    public SanPhamAdapter(ArrayList<SanPham> arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanpham, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        SanPham item = arr.get(i);

        holder.
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View itemView) {
            super(itemView);
            ImageView img = itemView.findViewById(R.id.imgloaisp);
            TextView tvTensp = itemView.findViewById(R.id.tvtensp);
            TextView tvGiasp = itemView.findViewById(R.id.tvgiasp);

        }
    }


}
