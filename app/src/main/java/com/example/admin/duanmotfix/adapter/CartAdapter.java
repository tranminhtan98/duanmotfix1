package com.example.admin.duanmotfix.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.admin.duanmotfix.R;
import com.example.admin.duanmotfix.dao.CartDAO;
import com.example.admin.duanmotfix.model.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.giayViewHolder> {
    private Context mCtx;
    private List<Cart> carts;
    private CartDAO cartdao;



    public CartAdapter(Context mCtx, List<Cart> carts, CartDAO cartdao) {
        this.mCtx = mCtx;
        this.carts = carts;
        this.cartdao = cartdao;
    }


    @NonNull
    @Override
    public giayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview_cart, null);
        return new giayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull giayViewHolder holder, final int i) {
        Cart product = carts.get(i);


        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.tvSoLuong.setText("1");
        holder.btnDeleteCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartdao.deleteCart(carts.get(i).getId());
                carts.remove(i);
                notifyDataSetChanged();
            }
        });



    }

    @Override
    public int getItemCount() {
        return carts.size();
    }

    class giayViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice,tvSoLuong;
        ImageView btnDeleteCart;

        public giayViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            btnDeleteCart = itemView.findViewById(R.id.btnDeleteCart);
            tvSoLuong = itemView.findViewById(R.id.tvSoLuong);
        }
    }
}
