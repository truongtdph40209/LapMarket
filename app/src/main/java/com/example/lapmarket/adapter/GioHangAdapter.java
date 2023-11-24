package com.example.lapmarket.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lapmarket.R;
import com.example.lapmarket.dao.AccountDAO;
import com.example.lapmarket.dao.GioHangDAO;
import com.example.lapmarket.designPantter.AccountSingle;
import com.example.lapmarket.frg.frg_giohang;
import com.example.lapmarket.inteface.TotalUpdateListener;
import com.example.lapmarket.model.account;
import com.example.lapmarket.model.giohang;
import com.example.lapmarket.model.hoadon;
import com.example.lapmarket.util.Amount;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {

    private Context context;
    private ViewHolder holder;
    private ArrayList<giohang> list;
    private ArrayList<account> accountArrayList;

    private GioHangDAO gioHangDAO;
    private AccountDAO accountDAO;
    private TotalUpdateListener totalUpdateListener;
    private frg_giohang fragment;
    private int viTriXoa;


    public double calculateTotal() {
        double total = 0;
        for (giohang item : list) {
            double gia = item.getGia();
            int soLuong = item.getSOLUONG();
            total += gia * soLuong;
        }
        return total;

    }

    public GioHangAdapter(Context context, ArrayList<giohang> list, GioHangDAO gioHangDAO, frg_giohang fragment) {
        this.context = context;
        this.list = list;
        this.gioHangDAO = gioHangDAO;
        this.fragment = fragment;

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

        giohang giohang = list.get(position);
        holder.txt_tenGioHang.setText(giohang.getTensp());

        holder.txt_soLuong.setText(String.valueOf(giohang.getSOLUONG()));

        holder.txt_giaTiengh.setText(Amount.moneyFormat(giohang.getGia() * giohang.getSOLUONG()));

        viTriXoa = holder.getAdapterPosition();


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context); //tạo dối tượng
                builder.setIcon(R.drawable.canhbao); //set icon
                builder.setMessage("Bạn chắc chắn muốn xóa");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int viTriXoa = holder.getAdapterPosition();
                        xoaSanPham(viTriXoa);
                        Toast.makeText(context, "Đã xóa sản phẩm này", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog = builder.create(); //tạo hộp thoại
                dialog.show();


                return false;


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


        holder.btn_muahang_gh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogThongTin(list.get(position));


            }
        });


    }

    private void tangSoLuong(ViewHolder holder, int viTri) {


        int magh = list.get(viTri).getID();

        int soLuongHienTai = list.get(viTri).getSOLUONG() ;
        int soLuongMoiC = soLuongHienTai + 1;
        int giaGoc = list.get(viTri).getGia();


        if (soLuongMoiC <=20){
            if (soLuongMoiC >= 0) {

                gioHangDAO.updateQuantity(magh, soLuongMoiC);
                list.get(viTri).setSOLUONG(soLuongMoiC);
                int giaMoiC = soLuongMoiC * giaGoc;
                gioHangDAO.updateQuantity(list.get(viTri).getID(), soLuongMoiC);
                holder.txt_giaTiengh.setText(Amount.moneyFormat(giaMoiC));
                holder.txt_soLuong.setText(String.valueOf(soLuongMoiC));

                list.get(viTri).setSOLUONG(soLuongMoiC);
                updateTotal();

            }
        }else {
            Toast.makeText(context, "Số lượng đã đạt tới tối đa", Toast.LENGTH_SHORT).show();
        }

    }



    private void giamSoLuong(ViewHolder holder, int viTri) {
        int magh = list.get(viTri).getID();
        int soLuongHienTai = list.get(viTri).getSOLUONG();
        int soLuongMoiT = soLuongHienTai - 1;



        if (soLuongMoiT >= 0) {
            gioHangDAO.updateQuantity(magh, soLuongMoiT);

            list.get(viTri).setSOLUONG(soLuongMoiT);

            if (soLuongMoiT >= 0) {

                if (soLuongMoiT == 0){
                    //
                    AlertDialog.Builder builder = new AlertDialog.Builder(context); //tạo dối tượng
                    builder.setMessage("Bạn chắc chắn muốn xóa");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            int viTriXoa = holder.getAdapterPosition();
                            xoaSanPham(viTriXoa);
                            Toast.makeText(context, "Đã xóa sản phẩm này", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create(); //tạo hộp thoại
                    dialog.show();

                }

                int giaMoiT = soLuongMoiT * list.get(viTri).getGia();
                gioHangDAO.updateQuantity(list.get(viTri).getID(), soLuongMoiT);
                holder.txt_giaTiengh.setText(Amount.moneyFormat(giaMoiT));
                holder.txt_soLuong.setText(String.valueOf(soLuongMoiT));
                list.get(viTri).setSOLUONG(soLuongMoiT);
                updateTotal();
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

        updateTotal();

    }


    private void updateTotal() {
        // Lấy tham chiếu đến fragment hiện tại
        double tongTien = calculateTotal();
        if (totalUpdateListener != null) {
            totalUpdateListener.onTotalUpdated(tongTien);
        }
        fragment.setSumPrice(tongTien);

    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_tenGioHang, txt_giaTiengh, txt_soLuong;

        Button btn_Slt, btn_Slc, btn_muahang_gh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_tenGioHang = itemView.findViewById(R.id.txt_tenGioHang);
            txt_giaTiengh = itemView.findViewById(R.id.txt_giaTiengh);
            btn_Slc = itemView.findViewById(R.id.btn_slC);
            btn_Slt = itemView.findViewById(R.id.btn_slT);
            txt_soLuong = itemView.findViewById(R.id.txt_soLuong);
            btn_muahang_gh = itemView.findViewById(R.id.btn_muahang_gh);


        }
    }

    public void  dialogThongTin(giohang giohang){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_thongtin_muahang, null);
        builder.setView(view);

        EditText edt_sdt = view.findViewById(R.id.edt_sdt);
        EditText edt_namsinh = view.findViewById(R.id.edt_namsinh);
        EditText edt_diachi = view.findViewById(R.id.edt_diachi);

        builder.setNegativeButton("Mua Ngay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String sdt = edt_sdt.getText().toString();
                String namsinh = edt_namsinh.getText().toString();
                String diachi = edt_diachi.getText().toString();

                if (sdt.isEmpty() || namsinh.isEmpty() || diachi.isEmpty()){
                    Toast.makeText(context, "Không được để trống dữ liệu", Toast.LENGTH_SHORT).show();
                }else {

                    account ac = AccountSingle.getInstance().getAccount();

                    gioHangDAO.addHoaDon(giohang, ac.getHoten(), ngayHienTai() );
                    Toast.makeText(context, "Đã mua hàng thành công", Toast.LENGTH_SHORT).show();
                    xoaSanPham(viTriXoa);


                }
            }
        });





        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static String ngayHienTai(){
        // Sử dụng Calendar
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
}
