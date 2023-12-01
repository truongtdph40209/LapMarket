package com.example.lapmarket.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lapmarket.R;
import com.example.lapmarket.dao.HoaDonDAO;
import com.example.lapmarket.dao.ThongTinDatHangDAO;
import com.example.lapmarket.model.dathang;
import com.example.lapmarket.model.hoadon;
import com.example.lapmarket.util.Amount;

import java.util.ArrayList;

public class ChiTietAdapter extends RecyclerView.Adapter<ChiTietAdapter.ViewHolder>{

    private Context context;
    private ArrayList<dathang> list;

    private ThongTinDatHangDAO thongTinDatHangDAO;

    public ChiTietAdapter(Context context, ArrayList<dathang> list, ThongTinDatHangDAO thongTinDatHangDAO) {
        this.context = context;
        this.list = list;
        this.thongTinDatHangDAO = thongTinDatHangDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_thongtin_dathang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_sdt_tt.setText("Số dt: " + list.get(position).getSdt());
        holder.txt_namsinh_tt.setText("Năm sinh: " + list.get(position).getNamsinh());
        holder.txt_diachi_tt.setText("địa chỉ: " + list.get(position).getDiachi());
        holder.txt_tensp_tt.setText("tên sp: " + list.get(position).getTensp());
        holder.txt_soluong_tt.setText("số lượng: " + list.get(position).getSoluong());
        holder.txt_gia_tt.setText( "Giá: "+ Amount.moneyFormat(list.get(position).getGia() * list.get(position).getSoluong()));

        holder.txt_xacnhan_tt.setText("xác nhận: " + list.get(position).getXacnhan());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_mahd_tt, txt_hoten_tt, txt_sdt_tt, txt_namsinh_tt, txt_diachi_tt, txt_tensp_tt, txt_soluong_tt, txt_gia_tt, txt_trangthai_tt, txt_xacnhan_tt;
        Button btn_xacnhan_tt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_mahd_tt = itemView.findViewById(R.id.txt_mahd_tt);
            txt_hoten_tt = itemView.findViewById(R.id.txt_hoten_tt);
            txt_sdt_tt = itemView.findViewById(R.id.txt_sdt_tt);
            txt_namsinh_tt = itemView.findViewById(R.id.txt_namsinh_tt);
            txt_diachi_tt = itemView.findViewById(R.id.txt_diachi_tt);
            txt_tensp_tt = itemView.findViewById(R.id.txt_tensp_tt);
            txt_soluong_tt = itemView.findViewById(R.id.txt_soluong_tt);
            txt_gia_tt = itemView.findViewById(R.id.txt_gia_tt);
            txt_trangthai_tt = itemView.findViewById(R.id.txt_trangthai_tt);
            txt_xacnhan_tt = itemView.findViewById(R.id.txt_xacnhan_tt);

            btn_xacnhan_tt = itemView.findViewById(R.id.btn_xacnhan_tt);


        }
    }
}
