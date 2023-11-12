package com.example.lapmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.lapmarket.dao.AccountDAO;
import com.example.lapmarket.frg.frg_cskh;
import com.example.lapmarket.frg.frg_gaming_doHoa;
import com.example.lapmarket.frg.frg_giohang;
import com.example.lapmarket.frg.frg_lichsu;
import com.example.lapmarket.frg.frg_phuKien;
import com.example.lapmarket.frg.frg_trangchu;
import com.example.lapmarket.frg.frg_vanPhong_macbook;
import com.example.lapmarket.model.account;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AccountDAO accountDAO;
    private ArrayList<account> list;

    DrawerLayout drawerLayout;
    NavigationView nav;
    Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        accountDAO = new AccountDAO(this);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.nav);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trang Chủ");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.frmNav, new frg_trangchu()).commit();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.thoat){
                    Toast.makeText(MainActivity.this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                    finish();
                }

                else if (item.getItemId()==R.id.trangchu) {
                    frg_trangchu frgTrangchu = new frg_trangchu();
                    replaceFragment(frgTrangchu);
                    Toast.makeText(MainActivity.this, "Trang Chủ", Toast.LENGTH_SHORT).show();
                }

                else if (item.getItemId()==R.id.lapGaming_doHoa) {
                    frg_gaming_doHoa frgGamingDoHoa = new frg_gaming_doHoa();
                    replaceFragment(frgGamingDoHoa);
                    Toast.makeText(MainActivity.this, "Laptop Gaming, Đồ Họa", Toast.LENGTH_SHORT).show();
                }

                else if (item.getItemId()==R.id.lapVanPhong_macbook) {
                    frg_vanPhong_macbook frgVanPhongMacbook = new frg_vanPhong_macbook();
                    replaceFragment(frgVanPhongMacbook);
                    Toast.makeText(MainActivity.this, "Laptop Văn Phòng, Macbook", Toast.LENGTH_SHORT).show();
                }

                else if (item.getItemId()==R.id.phuKien) {
                    frg_phuKien frgPhuKien = new frg_phuKien();
                    replaceFragment(frgPhuKien);
                    Toast.makeText(MainActivity.this, "Phụ Kiện Laptop", Toast.LENGTH_SHORT).show();
                }

                else if (item.getItemId()==R.id.doimk) {
                    showDoiMK();
                    Toast.makeText(MainActivity.this, "Đổi mật khẩu", Toast.LENGTH_SHORT).show();
                }

                else if (item.getItemId()==R.id.cskh) {
                    frg_cskh frgCskh  = new frg_cskh();
                    replaceFragment(frgCskh);
                    Toast.makeText(MainActivity.this, "Chăm Sóc Khách Hàng", Toast.LENGTH_SHORT).show();
                }

                else if (item.getItemId()==R.id.giohang) {
                    frg_giohang giohang = new frg_giohang();
                    replaceFragment(giohang);
                    Toast.makeText(MainActivity.this, "Giỏ Hàng Của Tôi", Toast.LENGTH_SHORT).show();
                }

                else if (item.getItemId()==R.id.lichsu) {
                    frg_lichsu frgLichsu = new frg_lichsu();
                    replaceFragment(frgLichsu);
                    Toast.makeText(MainActivity.this, "Lịch Sử Mua Hàng", Toast.LENGTH_SHORT).show();
                }

//                else if (item.getItemId()==R.id.xoatk) {
//                     accountDAO.delete(list.);
//
//
//                    Toast.makeText(MainActivity.this, "Đã xóa tài khoản", Toast.LENGTH_SHORT).show();
//
//
//
//                }


                getSupportActionBar().setTitle(item.getTitle());
                return true;
            }
        });

    }
    public void replaceFragment(Fragment frg){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frmNav,frg).commit();
    }

    private void showDoiMK(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.item_doimatkhau,null);


        EditText edt_mkCu = view.findViewById(R.id.edt_mkCu);
        EditText edt_mkMoi = view.findViewById(R.id.edt_mkMoi);
        EditText edt_nhapLai_mkMoi = view.findViewById(R.id.edt_NhapLai_mkMoi);

        builder.setView(view);



        builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        builder.setNegativeButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String mkCu = edt_mkCu.getText().toString();
                String mkMoi = edt_mkMoi.getText().toString();
                String nhaplai_mkMoi = edt_nhapLai_mkMoi.getText().toString();

                if (mkCu.isEmpty() || mkMoi.isEmpty() || nhaplai_mkMoi.isEmpty()){
                    Toast.makeText(MainActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }

                if (mkMoi.equals(nhaplai_mkMoi)){
                    SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);

                    String matt = sharedPreferences.getString("taikhoan", "");
                    accountDAO  = new AccountDAO(MainActivity.this);
                    boolean check = accountDAO.capNhatMatKhau(matt, mkCu, mkMoi);
                    if (check){
                        Toast.makeText(MainActivity.this, "Đổi mk thành công", Toast.LENGTH_SHORT).show();
                        finish();

                    }else {
                        Toast.makeText(MainActivity.this, "Đổi mk thất bại", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Nhập mk không trùng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();




    }


}