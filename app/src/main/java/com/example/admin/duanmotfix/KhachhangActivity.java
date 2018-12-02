package com.example.admin.duanmotfix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KhachhangActivity extends AppCompatActivity {
    private EditText ed1,ed2,ed3;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khachhang);
        ed1 = findViewById(R.id.tennguoidung);
        ed2 = findViewById(R.id.sodienthoainguoidung);
        ed3 = findViewById(R.id.diachi);
        btn = findViewById(R.id.gui);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO = {"anhtan98tan@gmail.com"};
                String[] CC = {"xamlexam113@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                String edt1 = ed1.getText().toString().trim();
                String edt2 = ed2.getText().toString().trim();
                String edt3 = ed3.getText().toString().trim();
                String send = "";
                send = "Tên: "+ edt1 + " \n Số điện thoại:"+ edt2+ "\n Địa chỉ:" + edt3 ;
                emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
                emailIntent.putExtra(Intent.EXTRA_CC,CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Thông tin khách hàng");
                emailIntent.putExtra(Intent.EXTRA_TEXT,send);
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();

            }
        });
    }
}
