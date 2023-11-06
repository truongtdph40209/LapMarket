package com.example.lapmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lapmarket.dao.AccountDAO;

public class man_hinh_dang_ki extends AppCompatActivity {
    private AccountDAO accountDAO;
    public static final String EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ki);

        accountDAO = new AccountDAO(this);
        TextView txt_back = findViewById(R.id.txt_back);


        EditText edt_user = findViewById(R.id.edt_username_dk);
        EditText edt_hoten = findViewById(R.id.edt_hoten_dk);
        EditText edt_pass = findViewById(R.id.edt_password_dk);
        EditText edt_repass = findViewById(R.id.edt_repassword_dk);
        EditText edt_email = findViewById(R.id.edt_email_dk);
        Button btn_signup = findViewById(R.id.btn_signup_dk);



        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user =  edt_user.getText().toString();
                String hoten =  edt_hoten.getText().toString();
                String pass =  edt_pass.getText().toString();
                String repass =  edt_repass.getText().toString();
                String email =  edt_email.getText().toString();

                if (user.isEmpty() || hoten.isEmpty() || pass.isEmpty() || repass.isEmpty() || email.isEmpty()){
                    Toast.makeText(man_hinh_dang_ki.this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                
                }else {

                    if (!pass.equals(repass)){
                        Toast.makeText(man_hinh_dang_ki.this, "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                    }else {
                        boolean check = accountDAO.signup(user, hoten, pass, email);
                        if (check){
                            Toast.makeText(man_hinh_dang_ki.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(man_hinh_dang_ki.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }





            }
        });
    }
}