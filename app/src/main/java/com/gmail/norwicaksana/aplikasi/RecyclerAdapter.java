package com.gmail.norwicaksana.aplikasi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    //deklarasi variable context

    private final Context context;

    String [] name={"Cuk Subiyantoro., S.Kom.,M.Kom","Ir. Sudarmanto , M.T. ","Heru Agus Triyanto, S.E.,M.M.",
            "Sri Redjeki , S.Si.,M.Kom. ", "FX.Henry Nugroho, S.T. ","L.N. Harnaningrum, S.Si., M.T. ","Dara Kusumawati, S.E., M.M. ","\n" +
            "Deborah Kurniawati, S.Kom., M.Cs."};
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.list_item, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();
            Toast.makeText(context, "Berada di posisi " + position, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public int getItemCount() {

        return name.length;
    }
}