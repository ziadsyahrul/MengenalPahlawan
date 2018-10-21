package com.ziadsyahrul.mengenalpahlawan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //TODO 1 Membuat variable
    Context context;
    int[] gambarPahlawan;
    String[] namaPahlawan,detailPahlawan;

    public Adapter(Context context, int[] gambarPahlawan, String[] namaPahlawan, String[] detailPahlawan) {
        this.context = context;
        this.gambarPahlawan = gambarPahlawan;
        this.namaPahlawan = namaPahlawan;
        this.detailPahlawan = detailPahlawan;

    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pahlawan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaPahlawan[i]);
        Glide.with(context).load(gambarPahlawan[i]).into(viewHolder.imgLogo);

        //TODO Membuat onClickListener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailActivity.class);
                pindah.putExtra("np", namaPahlawan[i]);
                pindah.putExtra("dp", detailPahlawan[i]);
                pindah.putExtra("gp", gambarPahlawan[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarPahlawan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);
        }
    }
}
