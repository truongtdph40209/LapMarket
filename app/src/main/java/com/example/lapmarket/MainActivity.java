package com.example.lapmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.lapmarket.frg.frg_cskh;
import com.example.lapmarket.frg.frg_gaming_doHoa;
import com.example.lapmarket.frg.frg_giohang;
import com.example.lapmarket.frg.frg_phuKien;
import com.example.lapmarket.frg.frg_trangchu;
import com.example.lapmarket.frg.frg_vanPhong_macbook;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView nav;
    Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

//                else if (item.getItemId()==R.id.doimk) {
//                    showDoiMK();
//                    Toast.makeText(MainActivity.this, "Đổi mật khẩu", Toast.LENGTH_SHORT).show();
//                }

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


                getSupportActionBar().setTitle(item.getTitle());
                return true;
            }
        });

    }
    public void replaceFragment(Fragment frg){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frmNav,frg).commit();
    }


}