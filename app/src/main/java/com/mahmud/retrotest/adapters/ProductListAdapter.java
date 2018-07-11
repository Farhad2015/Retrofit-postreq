package com.mahmud.retrotest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mahmud.retrotest.R;
import com.mahmud.retrotest.data.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHoler> {

    private List<Product> pList;
    private Context context;

    public ProductListAdapter(List<Product> pList, Context context) {
        this.pList = pList;
        this.context = context;
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {

        private ImageView imageViewProductImage;
        private TextView textViewProductTitle, textViewImageURL, textViewWebURL;

        public MyViewHoler(View itemView) {
            super(itemView);
            imageViewProductImage = (ImageView) itemView.findViewById(R.id.img_rowProductList);
            textViewProductTitle = (TextView) itemView.findViewById(R.id.txt_rowProductList_Title);
            textViewImageURL = (TextView) itemView.findViewById(R.id.txt_rowProductList_ImageURL);
            textViewWebURL = (TextView) itemView.findViewById(R.id.txt_rowProductList_URL);
        }
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_productlist, parent, false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, final int position) {
        Product productList = pList.get(position);
        Picasso.with(context).load(productList.getImage()).placeholder(R.drawable.ic_insert_photo_cyan_500_48dp).fit()
                .error(R.drawable.ic_insert_photo_cyan_500_48dp).into(holder.imageViewProductImage);
        holder.textViewProductTitle.setText("Title: "+productList.getTitle());
        holder.textViewImageURL.setText("Image URL: "+productList.getImage());
        holder.textViewWebURL.setText("Web URL: "+productList.getUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }
}
