package com.example.admin.duanmotfix.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.admin.duanmotfix.R;
import com.example.admin.duanmotfix.dao.CartDAO;
import com.example.admin.duanmotfix.dao.GIAYDAO;
import com.example.admin.duanmotfix.database.DatabaseHelper;
import com.example.admin.duanmotfix.model.Cart;
import com.example.admin.duanmotfix.model.Giay;

import java.util.ArrayList;


public class GIAYAdapter extends RecyclerView.Adapter<GIAYAdapter.GiayViewHolder> {
    private Context mCtx;
    private ArrayList<Giay> pcs;
    private GIAYDAO pcdao;

    public GIAYAdapter(Context mCtx, ArrayList<Giay> pcs, GIAYDAO pcdao) {
        this.mCtx = mCtx;
        this.pcs = pcs;
        this.pcdao = pcdao;
    }

    @NonNull
    @Override
    public GiayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.giay_cardview, null);
        return new GiayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiayViewHolder holder, final int position) {
        final Giay product = pcs.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(mCtx);
                dialog.setTitle(pcs.get(position).getTitle());
                dialog.setContentView(R.layout.activity_thongtinhang);
                TextView textView1,textView2,textView3,textView4;
                ImageView imageView;
                Button button;
                textView1 = dialog.findViewById(R.id.titleclick);
                textView2 = dialog.findViewById(R.id.size);
                textView3 = dialog.findViewById(R.id.hangclick);
                textView4 = dialog.findViewById(R.id.textdes);
                imageView = dialog.findViewById(R.id.imglogoclick);
                button = dialog.findViewById(R.id.btnthem);
                textView1.setText(product.getTitle());
                textView2.setText(product.getRating()+"");
                textView3.setText(product.getPrice()+"");
                textView4.setText(product.getShortdesc());
                imageView.setImageResource(Integer.parseInt(""+product.getImage()));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseHelper databaseHelper = new DatabaseHelper(mCtx);
                        CartDAO cartDAO = new CartDAO(databaseHelper);
                        Cart cart = new Cart(pcs.get(position).getId()+Math.random(),pcs.get(position).getTitle(),pcs.get(position).getShortdesc(),pcs.get(position).getRating(),pcs.get(position).getPrice(),1);
                        cartDAO.insertCart(cart);
                    }
                });
                dialog.show();
            }
        });
        holder.textViewTitle.setText(product.getTitle());
        holder.imglogo.setImageResource(Integer.parseInt(product.getImage()));
//        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
//        holder.imageView.setImageResource(product.setImage(R.drawable.logo););
//        holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(mCtx);
                CartDAO cartDAO = new CartDAO(databaseHelper);

                Cart cart = new Cart(pcs.get(position).getId()+Math.random(),pcs.get(position).getTitle(),pcs.get(position).getShortdesc(),pcs.get(position).getRating(),pcs.get(position).getPrice(),1);
                cartDAO.insertCart(cart);
            }
        });







    }

    @Override
    public int getItemCount() {
        return pcs.size();
    }

    class GiayViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imglogo;
        Button addCart;

        public GiayViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imglogo = itemView.findViewById(R.id.imgtextsp);
            addCart = itemView.findViewById(R.id.btnAddCart);
        }
    }


}
