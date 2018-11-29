package com.example.admin.duanmotfix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import com.example.admin.duanmotfix.adapter.GIAYAdapter;
import com.example.admin.duanmotfix.dao.GIAYDAO;
import com.example.admin.duanmotfix.database.DatabaseHelper;
import com.example.admin.duanmotfix.model.Giay;

import java.util.ArrayList;


public class ManhinhchinhActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GIAYDAO giaydao;
    private ArrayList<Giay> giayList;
    private DatabaseHelper databaseHelper;
    private GIAYAdapter giayAdapter;
    private GridLayoutManager gridLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);

        AnhXa();

        Giay giay = new Giay(
                "giay",
                "Giay dep 1",
                "",
                16,
                30,
                "" + R.drawable.anh1);
        giaydao.insertGIAY(giay);

        Giay giay1 = new Giay(
                "giay1",
                "Giay dep 2",
                "Vans là một thương hiệu chuyên sản xuất\n" +
                        "các sản phẩm về thể loại các con phố phố\n" +
                        "có đậm tính thể thao giả mạo hiểm và\n" +
                        "được phần đông quý khách hàng ưa\n" +
                        "chuộng trong phổ biến năm qua. nhãn\n" +
                        "hàng này được ra đời vào năm 1966 do\n" +
                        "ông Paul Van Doren và Gordon C.Lee,\n" +
                        "Serge d’Elia cùng Jame Van Doren đồng\n" +
                        "sáng lậpVans là một thương hiệu chuyên\n" +
                        "sản xuất các sản phẩm về thể loại các con\n" +
                        "phố phố, có đậm tính thể thao.",
                16,
                40,
                "" + R.drawable.anh2);
        giaydao.insertGIAY(giay1);

        Giay giay2 = new Giay(
                "giay2",
                "Giay dep 3",
                "",
                16,
                50,
                "" + R.drawable.anh3);
        giaydao.insertGIAY(giay2);


        Giay giay3 = new Giay(
                "giay3",
                "Giay dep 4",
                "",
                16,
                50,
                "" + R.drawable.anh4);
        giaydao.insertGIAY(giay3);




        AddRecyclerview();


    }
    void AnhXa() {

        recyclerView = findViewById(R.id.manhinhchinh);
        gridLayoutManager = new GridLayoutManager(this,2);
        giayList = new ArrayList<>();
        giayList.clear();
        databaseHelper = new DatabaseHelper(this);
        giaydao = new GIAYDAO(databaseHelper);

    }

    private void AddRecyclerview() {
        giayList = giaydao.getAllGiay();
        giayAdapter = new GIAYAdapter(this, giayList, giaydao);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(giayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemthongtin:
                Intent intent=new Intent(ManhinhchinhActivity.this,ThongtinbanquyenActivity.class);
                startActivity(intent);
                break;
            case R.id.itemgiohang:
                Intent intent1=new Intent(ManhinhchinhActivity.this,CartActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
