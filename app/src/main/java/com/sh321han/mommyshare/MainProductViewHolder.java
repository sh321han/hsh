package com.sh321han.mommyshare;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh321han.mommyshare.data.MainProduct;

/**
 * Created by Administrator on 2016-05-15.
 */
public class MainProductViewHolder extends RecyclerView.ViewHolder {

    ImageView thumbView;
    TextView nameView, priceView, depositView,periodView;
    MainProduct product;

    public interface OnItemClickListener {
        public void onItemClick(View view, MainProduct mainproduct);
    }

    OnItemClickListener mListener;

    public  void setOnItemClickListener(OnItemClickListener listener) { mListener = listener; }

    public MainProductViewHolder(View itemView) {
        super(itemView);
        thumbView = (ImageView)itemView.findViewById(R.id.image_thumb);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        priceView = (TextView)itemView.findViewById(R.id.text_price);
        depositView = (TextView)itemView.findViewById(R.id.text_deposit);
        periodView = (TextView)itemView.findViewById(R.id.text_period);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) {
                    mListener.onItemClick(v, product);
                }
            }
        });
    }

    public void setProduct(MainProduct product) {
        this.product = product;

        nameView.setText(product.getName());
        priceView.setText("대여료 " + product.getPrice());
        depositView.setText("보증금 " + product.getDeposit());
        periodView.setText("대여기간 "+product.getMinPeriod()+" 일 ~ " + product.getMaxPeriod()+" 일");

    }
}
