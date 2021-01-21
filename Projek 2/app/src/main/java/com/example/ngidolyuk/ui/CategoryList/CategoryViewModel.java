package com.example.ngidolyuk.ui.CategoryList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.CategoryListModel;
import com.example.ngidolyuk.Model.CategoryModel;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<List<CategoryListModel>> mutableLiveDataCategoryList;

    public CategoryViewModel() {

    }

    public MutableLiveData<List<CategoryListModel>> getMutableLiveDataCategoryList() {
        if(mutableLiveDataCategoryList == null)
            mutableLiveDataCategoryList = new MutableLiveData<>();
        mutableLiveDataCategoryList.setValue(Common.categorySelected.getFoods());

        return mutableLiveDataCategoryList;
    }
}