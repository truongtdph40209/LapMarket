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
import com.example.lapmarket.dao.HoaDonDAO;
import com.example.lapmarket.model.hoadon;

import com.example.lapmarket.util.Amount;

import java.util.ArrayList;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.ViewHolder> {
    private Context context;
    private ArrayList<hoadon> list;

    private HoaDonDAO hoaDonDAO;

    public HoaDonAdapter(Context context, ArrayList<hoadon> list, HoaDonDAO hoaDonDAO) {
        this.context = context;
        this.list = list;
        this.hoaDonDAO = hoaDonDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_thongtin_hoadon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_mahd_hd.setText("Mã hóa đơn: " + list.get(position).getMahd());
        holder.txt_hoten_hd.setText("Họ tên: " + list.get(position).getHoten());
        holder.txt_tensp_hd.setText("Tên sản phẩm: " + list.get(position).getTensp());
        holder.txt_soluong_hd.setText("Số lượng: " + list.get(position).getSOLUONG());
        holder.txt_gia_hd.setText("Giá: " + Amount.moneyFormat( list.get(position).getGia() * list.get(position).getSOLUONG()));
        holder.txt_ngaymua_hd.setText("Ngày mua: " + list.get(position).getNgaymua());


        holder.txt_trangthai_hd.setText("Trang Thái: " + list.get(position).getTrangthai());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_mahd_hd,txt_hoten_hd,txt_tensp_hd,txt_soluong_hd,txt_gia_hd,txt_ngaymua_hd,txt_trangthai_hd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_mahd_hd = itemView.findViewById(R.id.txt_mahd_hd);
            txt_hoten_hd = itemView.findViewById(R.id.txt_hoten_hd);
            txt_tensp_hd = itemView.findViewById(R.id.txt_tensp_hd);
            txt_soluong_hd = itemView.findViewById(R.id.txt_soluong_hd);
            txt_gia_hd = itemView.findViewById(R.id.txt_gia_hd);
            txt_ngaymua_hd = itemView.findViewById(R.id.txt_ngaymua_hd);
            txt_trangthai_hd = itemView.findViewById(R.id.txt_trangthai_hd);
        }
    }
}

