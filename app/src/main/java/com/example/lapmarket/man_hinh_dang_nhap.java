package com.example.lapmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lapmarket.dao.AccountDAO;

import org.w3c.dom.Text;

public class man_hinh_dang_nhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_nhap);


        TextView txt_signup  =findViewById(R.id.txt_signup);
        EditText edt_user = findViewById(R.id.edt_username);
        EditText edt_pass = findViewById(R.id.edt_password);
        Button btn_Login = findViewById(R.id.btn_login);

        AccountDAO accountDAO = new AccountDAO(this);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_user.getText().toString();
                String pass = edt_pass.getText().toString();

                if (accountDAO.checkdn(user, pass)){
                    SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("taikhoan", user);
                    editor.commit();

                    startActivity(new Intent(man_hinh_dang_nhap.this, MainActivity.class));

                }else {
                    Toast.makeText(man_hinh_dang_nhap.this, "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
                }

            }
        });


        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(man_hinh_dang_nhap.this, man_hinh_dang_ki.class));
            }
        });

    }
}