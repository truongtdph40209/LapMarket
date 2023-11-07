package com.example.lapmarket.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lapmarket.R;
import com.example.lapmarket.dao.SanPhamDAO;
import com.example.lapmarket.model.sanpham;

import java.util.ArrayList;


public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ViewHolder> {

    private Context context;
    private ArrayList<sanpham> list;

    private SanPhamDAO sanPhamDAO;

    public SanphamAdapter(Context context, ArrayList<sanpham> list, SanPhamDAO sanPhamDAO) {
        this.context = context;
        this.list = list;
        this.sanPhamDAO = sanPhamDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_tensp.setText("Laptop: " + list.get(position).getTensp());
        holder.txt_gia.setText("Giá: " + list.get(position).getGia() + "VND");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_tensp, txt_gia, txt_xemthem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_tensp = itemView.findViewById(R.id.txt_tensp_home);
            txt_gia = itemView.findViewById(R.id.txt_giasp_home);
            txt_xemthem = itemView.findViewById(R.id.txt_xemthem_home);

        }
    }
}
