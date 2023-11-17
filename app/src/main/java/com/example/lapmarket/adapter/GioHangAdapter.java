package com.example.lapmarket.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lapmarket.R;
import com.example.lapmarket.dao.GioHangDAO;
import com.example.lapmarket.model.giohang;
import com.example.lapmarket.util.Amount;

import java.util.ArrayList;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {

    private Context context;
    private ViewHolder holder;
    private ArrayList<giohang> list;
    private GioHangDAO gioHangDAO;

    public GioHangAdapter(Context context, ArrayList<giohang> list, GioHangDAO gioHangDAO) {
        this.context = context;
        this.list = list;
        this.gioHangDAO = gioHangDAO;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_giohang, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_tenGioHang.setText(list.get(position).getTensp());
//        Log.e("aaa" , "aac");
        holder.txt_soLuong.setText("Số lượng: " + list.get(position).getSOLUONG());

        holder.txt_giaTiengh.setText(Amount.moneyFormat(list.get(position).getGia() * list.get(position).getSOLUONG()));

        holder.iv_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viTriXoa = holder.getAdapterPosition();
                xoaSanPham(viTriXoa);
                Toast.makeText(context, "Đã xóa sản phẩm này", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btn_Slc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viTri = holder.getAdapterPosition();
                tangSoLuong(holder, viTri);
            }
        });

        holder.btn_Slt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int viTri = holder.getAdapterPosition();
                giamSoLuong(holder, viTri);
            }
        });
    }

    private void tangSoLuong(ViewHolder holder, int viTri) {
        int magh = list.get(viTri).getID();
        int soLuongHienTai = list.get(viTri).getSOLUONG();
        int soLuongMoiC = soLuongHienTai + 1;
        int giaGoc = list.get(viTri).getGia();

        if (soLuongMoiC >= 0) {
            gioHangDAO.updateQuantity(magh, soLuongMoiC);

            list.get(viTri).setSOLUONG(soLuongMoiC);

            int giaMoiC = soLuongMoiC * giaGoc;
            gioHangDAO.updateQuantity(list.get(viTri).getID(), soLuongMoiC);

            holder.txt_giaTiengh.setText(Amount.moneyFormat(giaMoiC));
            holder.txt_soLuong.setText("Số lượng: " + soLuongMoiC);
        }
    }

    private void giamSoLuong(ViewHolder holder, int viTri) {
        int magh = list.get(viTri).getID();
        int soLuongHienTai = list.get(viTri).getSOLUONG();
        int soLuongMoiT = soLuongHienTai - 1;

        if (soLuongMoiT >= 0) {
            gioHangDAO.updateQuantity(magh, soLuongMoiT);

            list.get(viTri).setSOLUONG(soLuongMoiT);

            if (soLuongMoiT > 0) {
                int giaMoiT = soLuongMoiT * list.get(viTri).getGia();
                gioHangDAO.updateQuantity(list.get(viTri).getID(), soLuongMoiT);
                holder.txt_giaTiengh.setText(Amount.moneyFormat(giaMoiT));
                holder.txt_soLuong.setText("Số lượng: " + soLuongMoiT);
            }


        }
    }


    private void xoaSanPham(int viTri) {
        if (gioHangDAO != null) {
            int magh = list.get(viTri).getID();
            gioHangDAO.deleteFromCart(magh);
        }
        list.remove(viTri);


        notifyItemRemoved(viTri);
        notifyItemRangeChanged(viTri, getItemCount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_tenGioHang, txt_giaTiengh, txt_soLuong;
        ImageButton iv_Del;
        Button btn_Slt, btn_Slc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_tenGioHang = itemView.findViewById(R.id.txt_tenGioHang);
            txt_giaTiengh = itemView.findViewById(R.id.txt_giaTiengh);
            iv_Del = itemView.findViewById(R.id.iv_Del);
            btn_Slc = itemView.findViewById(R.id.btn_slC);
            btn_Slt = itemView.findViewById(R.id.btn_slT);
            txt_soLuong = itemView.findViewById(R.id.txt_soLuong);

        }
    }
}
