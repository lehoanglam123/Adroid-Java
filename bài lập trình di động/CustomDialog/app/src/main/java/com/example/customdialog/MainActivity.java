package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  TextView txtLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = (TextView) findViewById(R.id.textviewLogin);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogLogin();
            }
        });
    }
    private void DialogLogin(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCanceledOnTouchOutside(false);

        // ánh xạ
        EditText edtUsername = (EditText) dialog.findViewById(R.id.editTextUSernme);
        EditText edtPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
        Button btnDangNhap = (Button) dialog.findViewById(R.id.buttonDangNhap);
        Button btnHuy = (Button) dialog.findViewById(R.id.buttonHuy);

        btnDangNhap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if(username.equals("tien") && password.equals("123")){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Lỗi Đăng Nhập", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}