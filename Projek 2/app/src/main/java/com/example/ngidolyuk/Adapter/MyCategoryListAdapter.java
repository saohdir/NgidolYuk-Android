package com.example.ngidolyuk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ngidolyuk.Callback.IRecycleClickListener;
import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.EventBus.categoryItemClick;
import com.example.ngidolyuk.Model.CategoryListModel;
import com.example.ngidolyuk.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyCategoryListAdapter extends RecyclerView.Adapter<MyCategoryListAdapter.MyViewHolder> {
    private Context context;
    private List<CategoryListModel> categoryListModelList;

    public MyCategoryListAdapter(Context context, List<CategoryListModel> categoryListModelList) {
        this.context = context;
        this.categoryListModelList = categoryListModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_kategori,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(categoryListModelList.get(position).getImage()).into(holder.img_category_image);
        holder.txt_category_name.setText(new StringBuilder("").append(categoryListModelList.get(position).getName()));

        //event
        holder.setListener((view, pos) -> {
            Common.selectedCategory = categoryListModelList.get(pos);
            EventBus.getDefault().postSticky(new categoryItemClick(true, categoryListModelList.get(pos)));
        });
    }

    @Override
    public int getItemCount() {
        return categoryListModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Unbinder unbinder;
        @BindView(R.id.txt_category_name)
        TextView txt_category_name;
        @BindView(R.id.img_category_image)
        ImageView img_category_image;
        @BindView(R.id.img_fav)
        ImageView img_fav;
        @BindView(R.id.img_quick_cart)
        ImageView img_quick_cart;

        IRecycleClickListener listener;

        public void setListener(IRecycleClickListener listener) {
            this.listener = listener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClickListener(view, getAdapterPosition());
        }
    }
}
