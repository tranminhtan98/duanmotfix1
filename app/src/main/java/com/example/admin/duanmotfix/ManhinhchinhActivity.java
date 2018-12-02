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
                "Vans Classics Authentic Blue",
                "Đặc điểm của những đôi giày Vans Authentic nổi bật từ chính những gì cơ bản và tối giản nhất của một đôi giày thể thao",
                38,
                1300000,
                "" + R.drawable.anh1);
        giaydao.insertGIAY(giay);

        Giay giay1 = new Giay(
                "giay1",
                "VANS OLD SKOOL CLASSIC BLACK/WHITE ",
                "Là một trong những phiên bản đầu tiên và cổ điển nhất của VANS trong bộ sưu tập VANS OLD SKOOL ra đời năm 1977. Tới nay đôi giày chỉ với phối màu đen trắng này vẫn nằm trong top \"Best Seller\" của VANS trên toàn thế giới, với kiểu dáng cổ điển cùng \"sọc Jazz\" huyền thoại hợp thời trang khiến đôi VANS này thật sự trở thành mẫu giày classic bất bại, là fan hâm mộ của VANS nói chung và những skaters nói riêng đều nên có một đôi trong tủ giày.",
                40,
                1699000,
                "" + R.drawable.anh2);
        giaydao.insertGIAY(giay1);

        Giay giay2 = new Giay(
                "giay2",
                "VANS OLD SKOOL CLASSIC Green",
                "Thiết kế của giày Vans Old Skool sở hữu vẻ ngoài đặc trưng từ đường sóng trắng chạy dọc hai bên thân giày trên nền vải da lộn bền bỉ, phần cổ giày đệm mút vải êm ái, tối ưu hóa mọi chuyển động",
                43,
                1299000,
                "" + R.drawable.anh3);
        giaydao.insertGIAY(giay2);


        Giay giay3 = new Giay(
                "giay3",
                "Vans Classics Authentic Pink",
                "Giầy VANS gắn liền với phong cách đầy bụi bặm và năng động của giới trẻ – hiện Vans đang xuất hiện ở mọi nơi. Sản phẩm đã trở nên rất đỗi quen thuộc và gắn liền với đời sống của đại bộ phận giới trẻ đam mê thể thao.",
                36,
                1299000,
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
