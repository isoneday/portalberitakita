package com.workshop.aplikasiportalberita.portalberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.workshop.aplikasiportalberita.R;
import com.workshop.aplikasiportalberita.portalberita.DetailActivity;
import com.workshop.aplikasiportalberita.portalberita.Model.DataBerita;

import java.util.List;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyViewHolder>  {
    // Buat Global variable untuk manampung context
    Context context;
    List<DataBerita> berita;
    public AdapterBerita(Context context, List<DataBerita> data_berita) {
        // Inisialisasi
        this.context = context;
        this.berita = data_berita;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.berita_data, parent, false);

        // Hubungkan dengan MyViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Set widget
        holder.tvJudul.setText(berita.get(position).getTitle());
        holder.tvTglTerbit.setText(berita.get(position).getPublishedAt());
        if (berita.get(position).getAuthor()!=null){
            holder.tvPenulis.setText(String.valueOf(berita.get(position).getAuthor()));
        }else{
            holder.tvPenulis.setText("berita kita");
        }

        // Dapatkan url gambar
        final String urlGambarBerita =  berita.get(position).getUrlToImage();
        // Set image ke widget dengna menggunakan Library Piccasso
        // krena imagenya dari internet
        Picasso.with(context).load(berita.get(position).getUrlToImage()).error(R.drawable.beritakit).placeholder(R.drawable.beritakit).into(holder.ivGambarBerita);

        // Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mulai activity Detail
                Intent varIntent = new Intent(context, DetailActivity.class);
                // sisipkan data ke intent
                varIntent.putExtra("JDL_BERITA", berita.get(position).getTitle());
                varIntent.putExtra("TGL_BERITA", berita.get(position).getPublishedAt());
                varIntent.putExtra("PNS_BERITA", String.valueOf(berita.get(position).getAuthor()));
                varIntent.putExtra("FTO_BERITA", urlGambarBerita);
                varIntent.putExtra("ISI_BERITA", berita.get(position).getDescription());
                varIntent.putExtra("URL_BERITA", berita.get(position).getUrl());

                // method startActivity cma bisa di pake di activity/fragment
                // jadi harus masuk ke context dulu
                context.startActivity(varIntent);
            }
        });
    }
    // Menentukan Jumlah item yang tampil
    @Override
    public int getItemCount() {
        return berita.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi widget
        ImageView ivGambarBerita;
        TextView tvJudul, tvTglTerbit, tvPenulis;
        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
            ivGambarBerita = (ImageView) itemView.findViewById(R.id.ivPosterBerita);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudulBerita);
            tvTglTerbit = (TextView) itemView.findViewById(R.id.tvTglTerbit);
            tvPenulis = (TextView) itemView.findViewById(R.id.tvPenulis);
        }
    }
}
