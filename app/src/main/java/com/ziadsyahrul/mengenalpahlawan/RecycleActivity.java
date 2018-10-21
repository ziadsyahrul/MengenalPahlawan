package com.ziadsyahrul.mengenalpahlawan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    //TODO 1 mengenerate butterknife untuk recycleview
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    //TODO 2 membuat variable array untuk menampung data nama,detail dan gambar dari String Array pada
    String[] namaPahlawan;
    String[] detailPahlawan;
    int[] gambarPahlawan;

    com.ziadsyahrul.mengenalpahlawan.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        //TODO 3 Mengisi variable array dari folder -> Strings,drawable
        namaPahlawan = getResources().getStringArray(R.array.pahlawan_name);
        detailPahlawan = getResources().getStringArray(R.array.detail_pahlawan);
        gambarPahlawan = new int[]{R.drawable.ahmad_yani, R.drawable.letnan_jenderal_suprapto, R.drawable.letnan_jenderal_haryono, R.drawable.letjend_s_parman, R.drawable.mayor_jenderal_pandjaitan, R.drawable.mayor_jenderal_sutoyo_suswomiharjo, R.drawable.kapten_pierre_tendean, R.drawable.karel_satsuit_tubun, R.drawable.katamso_darmokusumo,R.drawable.kolonel_sugiono};

        //TODO 4 Membuat object adpater dan mengirim data nama,detail dan gambar ke adapter
        adapter = new com.ziadsyahrul.mengenalpahlawan.Adapter(RecycleActivity.this, gambarPahlawan, namaPahlawan, detailPahlawan);
        //TODO 5 Mensetting recyclerview dan mengeset recycleview dengan adapter
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter((RecyclerView.Adapter) adapter);

    }
}