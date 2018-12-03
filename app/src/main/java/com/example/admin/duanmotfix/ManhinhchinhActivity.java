package com.example.admin.duanmotfix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;



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
    private ListView lv;
    private SearchView searchView;


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

        Giay giay4 = new Giay(
                "giay4",
                "VANS OLD SKOOL CLASSIC Red",
                "Giầy VANS gắn liền với phong cách đầy bụi bặm và năng động của giới trẻ – hiện Vans đang xuất hiện ở mọi nơi. Sản phẩm đã trở nên rất đỗi quen thuộc và gắn liền với đời sống của đại bộ phận giới trẻ đam mê thể thao.",
                39,
                1599000,
                "" + R.drawable.anh5);
        giaydao.insertGIAY(giay4);

        Giay giay5 = new Giay(
                "giay5",
                "Vans Checkerboard\n Red",
                "Giầy VANS gắn liền với phong cách đầy bụi bặm và năng động của giới trẻ – hiện Vans đang xuất hiện ở mọi nơi. Sản phẩm đã trở nên rất đỗi quen thuộc và gắn liền với đời sống của đại bộ phận giới trẻ đam mê thể thao.",
                41,
                1799000,
                "" + R.drawable.anh6);
        giaydao.insertGIAY(giay5);

        Giay giay6 = new Giay(
                "giay6",
                "vans old skool checkerboard",
                "Giầy VANS gắn liền với phong cách đầy bụi bặm và năng động của giới trẻ – hiện Vans đang xuất hiện ở mọi nơi. Sản phẩm đã trở nên rất đỗi quen thuộc và gắn liền với đời sống của đại bộ phận giới trẻ đam mê thể thao.",
                41,
                1799000,
                "" + R.drawable.anh7);
        giaydao.insertGIAY(giay6);

        Giay giay7 = new Giay(
                "giay7",
                "Giày Vans Old Skool\n Fire",
                "Giầy VANS gắn liền với phong cách đầy bụi bặm và năng động của giới trẻ – hiện Vans đang xuất hiện ở mọi nơi. Sản phẩm đã trở nên rất đỗi quen thuộc và gắn liền với đời sống của đại bộ phận giới trẻ đam mê thể thao.",
                41,
                1799000,
                "" + R.drawable.anh8);
        giaydao.insertGIAY(giay7);




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
        final MenuItem myActionMenuItem= menu.findItem(R.id.timkiem);
        searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    giayAdapter.filter("");
                }
                else{
                    giayAdapter.filter(s);
                }
                return true;
            }
        });
        return true;
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
