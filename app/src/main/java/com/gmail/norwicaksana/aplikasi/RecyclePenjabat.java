package com.gmail.norwicaksana.aplikasi;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

@SuppressLint("Registered")
public class RecyclePenjabat extends AppCompatActivity {

    //deklarasi variabel reyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pejabat);

        recyclerView= findViewById(R.id.recycler_view);
        //menampilkan reyclerview yang ada pada file layout dengan id reycler view

        RecyclerAdapter adapter=new RecyclerAdapter(this);
        //membuat adapter baru untuk reyclerview
        recyclerView.setAdapter(adapter);
        //menset nilai dari adapter
        recyclerView.setHasFixedSize(true);
        //menset setukuran
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //menset layoutmanager dan menampilkan daftar/list
        //dalam bentuk linearlayoutmanager pada class saat ini


    }
}
