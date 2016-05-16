package com.sh321han.mommyshare.MyProductList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.sh321han.mommyshare.MyProductDetail.MyProductDetailActivity;
import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.MyProduct;

public class MyProductListActivity extends AppCompatActivity {

    RecyclerView listView;
    MyProductListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_product_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (RecyclerView) findViewById(R.id.my_rv_list);
        mAdapter = new MyProductListAdapter();
        listView.setAdapter(mAdapter);

        listView.setLayoutManager(new GridLayoutManager(this, 2));

        mAdapter.setOnItemClickListener(new MyProductListViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MyProduct myproduct) {
                Intent intent = new Intent(MyProductListActivity.this, MyProductDetailActivity.class);

                startActivity(intent);
            }
        });
        setData();
    }

    private void setData() {
        for (int i = 0; i < 10; i++) {
            MyProduct p = new MyProduct();
            p.setMy_name("Name " + i);
            p.setMy_price(i);
            p.setMy_deposit(i);
            p.setMy_minPeriod(i);
            p.setMy_minPeriod(i);
            mAdapter.add(p);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
