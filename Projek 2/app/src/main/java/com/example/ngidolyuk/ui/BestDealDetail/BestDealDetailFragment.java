package com.example.ngidolyuk.ui.categorydetail;

import android.media.Rating;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.andremion.counterfab.CounterFab;
import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.CategoryListModel;
import com.example.ngidolyuk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BestDealDetailFragment extends Fragment {

    private CategoryDetailViewModel slideshowViewModel;
    private Unbinder unbinder;

    @BindView(R.id.img_best_deals)
    ImageView img_best_deals;
    @BindView(R.id.bestdeal_name)
    TextView bestdeal_name;
    @BindView(R.id.bestdeal_description)
    TextView bestdeal_description;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) { slideshowViewModel =
            ViewModelProviders.of(this).get(CategoryDetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bestdeal_detail, container, false);
        unbinder = ButterKnife.bind(this, root);
        slideshowViewModel.getMutableLiveDataDetail().observe(this, bestdealListModel -> {
                    displayInfo(bestdealListModel);
                }
        );
        return root;
    }

    private void displayInfo(CategoryListModel categoryListModel) {
        Glide.with(getContext()).load(categoryListModel.getImage()).into(img_best_deals);
        bestdeal_name.setText(new StringBuilder(categoryListModel.getName()));
        bestdeal_description.setText(new StringBuilder(categoryListModel.getDescription()));

        ((AppCompatActivity)getActivity())
                .getSupportActionBar()
                .setTitle(Common.bestdealSelected.getName());

    }
}