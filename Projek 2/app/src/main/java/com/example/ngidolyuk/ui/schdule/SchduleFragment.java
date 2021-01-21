package com.example.ngidolyuk.ui.schdule;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ngidolyuk.Adapter.MySchduleAdapter;
import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dmax.dialog.SpotsDialog;

public class SchduleFragment extends Fragment {

    private SchduleViewModel schduleViewModel;

    Unbinder unbinder;
    @BindView(R.id.recycler_schdule)
    RecyclerView recycler_schdule;
    AlertDialog dialog;
    LayoutAnimationController layoutAnimationController;
    MySchduleAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        schduleViewModel =
                ViewModelProviders.of(this).get(SchduleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_schdule, container, false);

        unbinder = ButterKnife.bind(this,root);
        initViews();

        schduleViewModel.getMessageError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(),""+s,Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        schduleViewModel.getSchduleListMutable().observe(this,schduleModelList -> {
            dialog.dismiss();
            adapter = new MySchduleAdapter(getContext(),schduleModelList);
            recycler_schdule.setAdapter(adapter);
            recycler_schdule.setLayoutAnimation(layoutAnimationController);
        });
        return root;
    }

    private void initViews() {
        dialog = new SpotsDialog.Builder().setContext(getContext()).setCancelable(false).build();
        dialog.show();
        recycler_schdule.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_item_from_left);
    }
}