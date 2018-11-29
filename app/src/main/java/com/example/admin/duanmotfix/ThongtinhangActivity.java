package com.example.admin.duanmotfix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThongtinhangActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinhang);

    }

    public void them(View view) {
        Intent intent=new Intent(ThongtinhangActivity.this, CartActivity.class);
        startActivity(intent);
    }
}
