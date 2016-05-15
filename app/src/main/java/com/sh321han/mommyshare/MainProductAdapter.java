package com.sh321han.mommyshare;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh321han.mommyshare.data.MainProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-15.
 */
public class MainProductAdapter extends RecyclerView.Adapter<MainProductViewHolder> {
    List<MainProduct> items = new ArrayList<>();

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void add(MainProduct product) {
        items.add(product);
        notifyDataSetChanged();
    }

    public void addAll(List<MainProduct> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    MainProductViewHolder.OnItemClickListener mListener;
    public void setOnItemClickListener(MainProductViewHolder.OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public MainProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_main_product, null);
        return new MainProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainProductViewHolder holder, int position) {
        holder.setProduct(items.get(position));
        holder.setOnItemClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
