package com.sh321han.mommyshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.sh321han.mommyshare.Chatting.ChattingActivity;
import com.sh321han.mommyshare.data.MainProduct;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imageView;
    Spinner categorySpinner, priceSpinner, distSpinner;
    ArrayAdapter<String> cAdapter, pAdapter, dAdapter;
    RecyclerView listView;
    MainProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, WriteActivity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        imageView = (ImageView) headerView.findViewById(R.id.profile_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(i);
            }
        });

        categorySpinner = (Spinner) findViewById(R.id.spinner_category);
        priceSpinner = (Spinner) findViewById(R.id.spinner_price);
        distSpinner = (Spinner) findViewById(R.id.spinner_dist);
        cAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        cAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(cAdapter);
        pAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        pAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priceSpinner.setAdapter(pAdapter);
        dAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        dAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distSpinner.setAdapter(dAdapter);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        priceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        distSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        categoryData();
        priceData();
        distData();


        listView = (RecyclerView) findViewById(R.id.rv_list);
        mAdapter = new MainProductAdapter();
        listView.setAdapter(mAdapter);

        listView.setLayoutManager(new GridLayoutManager(this, 2));

        mAdapter.setOnItemClickListener(new MainProductViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MainProduct product) {
                Intent intent = new Intent(MainActivity.this, OtherProductDetailActivity.class);

                startActivity(intent);
            }
        });
        setData();

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void categoryData() {
        String[] items = getResources().getStringArray(R.array.category_item);
        for (String s : items) {
            cAdapter.add(s);
        }
    }

    private void priceData() {
        String[] items = getResources().getStringArray(R.array.price_item);
        for (String s : items) {
            pAdapter.add(s);
        }
    }

    private void distData() {
        String[] items = getResources().getStringArray(R.array.dist_item);
        for (String s : items) {
            dAdapter.add(s);
        }
    }

    private void setData() {
        for (int i = 0; i < 10; i++) {
            MainProduct p = new MainProduct();
            p.setName("Name " + i);
            p.setPrice(i);
            p.setDeposit(i);
            p.setMinPeriod(i);
            p.setMaxPeriod(i);
            mAdapter.add(p);
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_product_list) {
            Intent i = new Intent(MainActivity.this, MyProductListActivity.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.nav_my_wish_list) {
            Intent i = new Intent(MainActivity.this, MyWishListActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_chatting) {
            Intent i = new Intent(MainActivity.this, ChattingActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_to_manager) {

        } else if (id == R.id.nav_setting) {
            Intent i = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
