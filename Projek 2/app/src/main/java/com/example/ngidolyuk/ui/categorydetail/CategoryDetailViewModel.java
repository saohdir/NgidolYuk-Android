package com.example.ngidolyuk.ui.categorydetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.CategoryListModel;

public class CategoryDetailViewModel extends ViewModel {

    private MutableLiveData<CategoryListModel> mutableLiveDataDetail;

    public CategoryDetailViewModel() {

    }

    public MutableLiveData<CategoryListModel> getMutableLiveDataDetail() {
        if(mutableLiveDataDetail == null)
            mutableLiveDataDetail = new MutableLiveData<>();
        mutableLiveDataDetail.setValue(Common.selectedCategory);
        return mutableLiveDataDetail;
    }
}