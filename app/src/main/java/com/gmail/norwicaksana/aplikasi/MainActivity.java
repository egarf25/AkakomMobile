package com.gmail.norwicaksana.aplikasi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import java.util.HashMap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SliderLayout sliderLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> JudulBeranda;
    private ArrayList<Integer> GambarBeranda;
    //Daftar Judul
    private String[] Judul = {"Pendaftaran PMB TA 2018/2019", "Upacara dalam rangka memperingati Hari Kesetiakawanan Nasional", "Kunjungan Industri SMK Budi Utomo Jombang",
                              "Selamat kepada tim Rackspira", "Launching Aplikasi Buku Digital", "Pameran produk sains dan teknologi pancasila"};
    //Daftar Gambar
    private int[] Gambar = {R.drawable.beranda1, R.drawable.beranda2, R.drawable.beranda3,
                            R.drawable.beranda4, R.drawable.beranda5, R.drawable.beranda6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
                sliderLayout = (SliderLayout) findViewById(R.id.slider);

        JudulBeranda = new ArrayList<>();
        GambarBeranda = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RecyclerViewAdapter(JudulBeranda, GambarBeranda);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Load image dari URL

        // Load Image Dari res/drawable
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Pendaftaran PMB TA 2018/2019",R.drawable.beranda1);
        file_maps.put("Upacara dalam rangka memperingati Hari Kesetiakawanan Nasional",R.drawable.beranda2);
        file_maps.put("Kunjungan Industri SMK Budi Utomo Jombang",R.drawable.beranda3);
        file_maps.put("Selamat kepada tim Rackspira", R.drawable.beranda4);
        file_maps.put("Launching Aplikasi Buku Digital", R.drawable.beranda5);
        file_maps.put("Pameran produk sains dan teknologi pancasila", R.drawable.beranda6);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
    }

    //Mengambil data dari Varibale Gambar dan Judul, lalu memasangnya pada list yang terhubung dengan Class Adapter
    private void DaftarItem(){
        for (int w=0; w<Judul.length; w++){
            GambarBeranda.add(Gambar[w]);
            JudulBeranda.add(Judul[w]);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_feedback) {
            Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_jurusan) {
            Intent intent = new Intent(MainActivity.this, JurusanActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(MainActivity.this, DetProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_instagram) {
            Intent intent = new Intent();
            intent.setAction(intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            //intent.addCategory(Intent.CATEGORY_APP_BROWSER);
            intent.setData(Uri.parse("https://www.instagram.com/stmikakakom/"));
            startActivity(intent);

        } else if (id == R.id.nav_facebook) {
            Intent intent = new Intent();
            intent.setAction(intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            //intent.addCategory(Intent.CATEGORY_APP_BROWSER);
            intent.setData(Uri.parse("https://www.facebook.com/akakomyogya/"));
            startActivity(intent);

        } else if (id == R.id.nav_twitter) {
            Intent intent = new Intent();
            intent.setAction(intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            //intent.addCategory(Intent.CATEGORY_APP_BROWSER);
            intent.setData(Uri.parse("https://twitter.com/TheRealAKAKOM"));
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
