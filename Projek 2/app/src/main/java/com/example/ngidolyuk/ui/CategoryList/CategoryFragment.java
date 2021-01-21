package com.example.ngidolyuk.ui.CategoryList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ngidolyuk.Adapter.MyCategoryListAdapter;
import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.CategoryListModel;
import com.example.ngidolyuk.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CategoryFragment extends Fragment {

    private CategoryViewModel sendViewModel;

    Unbinder unbinder;
    @BindView(R.id.recycler_category_list)
    RecyclerView recycler_category_list;

    LayoutAnimationController layoutAnimationController;
    MyCategoryListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(CategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        unbinder = ButterKnife.bind(this,root);
        initViews();
        sendViewModel.getMutableLiveDataCategoryList().observe(this, new Observer<List<CategoryListModel>>() {
            @Override
            public void onChanged(List<CategoryListModel> categoryListModels) {
                adapter = new MyCategoryListAdapter(getContext(), categoryListModels);
                recycler_category_list.setAdapter(adapter);
                recycler_category_list.setLayoutAnimation(layoutAnimationController);
            }
        });
        return root;
    }

    private void initViews() {

        ((AppCompatActivity)getActivity())
                .getSupportActionBar()
                .setTitle(Common.categorySelected.getName());

        recycler_category_list.setHasFixedSize(true);
        recycler_category_list.setLayoutManager(new LinearLayoutManager(getContext()));

        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_item_from_left);
    }
}