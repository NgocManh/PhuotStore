package com.example.phonglinh.phuot;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.Retrofit.APIUtils;
import com.Retrofit.DataClient;
import com.adapter.LoaiSanPhamAdapter;
import com.model.LoaiSanPham;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    RecyclerView recyclerView;
    ListView lvNavi;
    DrawerLayout drawerLayout;
    LoaiSanPhamAdapter adapter;
    ArrayList<LoaiSanPham> arrLoaiSanPham = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        actionBar();

        actionViewFlipper();

        actionMenu();






    }



     void actionMenu() {

         DataClient dataClient = APIUtils.getData();

         Call<List<LoaiSanPham>> call = dataClient.getList();



        call.enqueue(new Callback<List<LoaiSanPham>>() {

            @Override
            public void onResponse(Call<List<LoaiSanPham>> call, Response<List<LoaiSanPham>> response) {
                arrLoaiSanPham.add(new LoaiSanPham(0,"Trang chủ", "https://sv1.uphinhnhanh.com/images/2018/05/10/trang-chu-la-gi.jpg"));
                arrLoaiSanPham.addAll((ArrayList<LoaiSanPham>) response.body());
                arrLoaiSanPham.add(new LoaiSanPham(0,"Liên hệ", "https://sv1.uphinhnhanh.com/images/2018/05/10/lien-he-1.jpg"));
                adapter = new LoaiSanPhamAdapter(arrLoaiSanPham);
                lvNavi.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LoaiSanPham>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "tach cmnr", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void actionBar() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void actionViewFlipper() {

        ArrayList<String> arr = new ArrayList<>();

        arr.add("https://sv1.uphinhnhanh.com/images/2018/05/09/6867699-paint.jpg");
        arr.add("https://sv1.uphinhnhanh.com/images/2018/05/10/4478945-paint-wallpapers.jpg");

        for(int i = 0; i < arr.size(); i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(arr.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }

        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation slide_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
        Animation slide_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        viewFlipper.setInAnimation(slide_left);
        viewFlipper.setOutAnimation(slide_right);
    }

    private void init() {

        toolbar = findViewById(R.id.toolBar);
        viewFlipper = findViewById(R.id.viewFlipper);
        navigationView = findViewById(R.id.naviView);
        recyclerView = findViewById(R.id.recyclerView);
        lvNavi = findViewById(R.id.lvNavi);
        drawerLayout = findViewById(R.id.drawerLayout);

    }


}
