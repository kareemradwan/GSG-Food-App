package com.kareemradwan.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kareemradwan.foodapp.R;
import com.kareemradwan.foodapp.model.Product;
import com.kareemradwan.foodapp.ui.eat.EatDeatilsActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> products;
    private Context context;
    private boolean isGrid = false;
    private boolean isEat = false;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        if (isGrid) {
            return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product_grid, null, false));

        } else {
            return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product_horizantal, null, false));

        }
    }

    public void setIsGrid(boolean isGrid) {
        this.isGrid = isGrid;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.imgProduct.setBackgroundResource(products.get(position).getImage());
        holder.tvTitle.setText(products.get(position).getName());
        holder.tvPrice.setText(products.get(position).getPrice() + " شيكل");

        if (!isGrid) {
            holder.tvCategory.setText(products.get(position).getCategory());
        }

        if(isEat)
        {
            holder.imgProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //
                    context.startActivity(new Intent(context , EatDeatilsActivity.class) );
                }
            });
            holder.tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //
                    context.startActivity(new Intent(context , EatDeatilsActivity.class) );
                }
            });
            holder.tvPrice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //
                    context.startActivity(new Intent(context , EatDeatilsActivity.class) );
                }
            });
        }
    }

    public void isEat(boolean isEat) {
        this.isEat = isEat;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvCategory, tvPrice;
        ImageView imgProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_product_title);
            tvCategory = itemView.findViewById(R.id.tv_product_category);
            tvPrice = itemView.findViewById(R.id.tv_product_price);
            imgProduct = itemView.findViewById(R.id.img_product);
        }
    }
}
