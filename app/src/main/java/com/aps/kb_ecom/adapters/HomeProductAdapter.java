package com.aps.kb_ecom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aps.kb_ecom.R;

public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.Holder> {
    Context context ;

    public HomeProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.home_product_adapter_item , parent , false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        ProductAdapter adapter = new ProductAdapter() ;
        holder.rv_products.setAdapter(adapter) ;

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class Holder extends RecyclerView.ViewHolder {
        RecyclerView rv_products ;
        public Holder(@NonNull View itemView) {
            super(itemView);
            rv_products = itemView.findViewById(R.id.rv_products) ;
            rv_products.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false));
        }
    }
}
