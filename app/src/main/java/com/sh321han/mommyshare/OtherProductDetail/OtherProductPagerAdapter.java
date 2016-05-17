package com.sh321han.mommyshare.OtherProductDetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sh321han.mommyshare.R;

/**
 * Created by Tacademy on 2016-05-16.
 */
public class OtherProductPagerAdapter extends PagerAdapter{

    LayoutInflater inflater;
    Context mContext;
    public static final int VIEW_COUNT = 5;

    public OtherProductPagerAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        TextView v = new TextView(mContext);
//        v.setText("position " + position);
//        container.addView(v);
//        return v;
        View view = null;
        view = inflater.inflate(R.layout.view_other_product_page,null);
        ImageView img = (ImageView)view.findViewById(R.id.pager_childview);
        img.setImageResource(R.drawable.ic_menu_camera+position);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return VIEW_COUNT;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
