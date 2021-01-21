package com.example.ngidolyuk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ngidolyuk.Model.SchduleModel;
import com.example.ngidolyuk.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MySchduleAdapter extends RecyclerView.Adapter<MySchduleAdapter.MyViewHolder> {


    Context context;
    List<SchduleModel> schduleModelList;

    public MySchduleAdapter(Context context, List<SchduleModel> schduleModelList) {
        this.context = context;
        this.schduleModelList = schduleModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
        .inflate(R.layout.layout_schdule_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama_show.setText(new StringBuilder(schduleModelList.get(position).getNama_show()));
        holder.nama_team.setText(new StringBuilder(schduleModelList.get(position).getNama_team()));
        holder.tanggal_show.setText(new StringBuilder(schduleModelList.get(position).getTanggal_show()));
        holder.schdule_name.setText(new StringBuilder(schduleModelList.get(position).getWaktu_show()));
    }




    @Override
    public int getItemCount() {
        return schduleModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Unbinder unbinder;


        @BindView(R.id.txt_setlist)
        TextView nama_show;

        @BindView(R.id.txt_team)
        TextView nama_team;

        @BindView(R.id.txt_show)
        TextView tanggal_show;

        @BindView(R.id.txt_pertunjukan)
        TextView schdule_name;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this,itemView);
        }
    }


}
