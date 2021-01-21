package com.example.ngidolyuk.Callback;

import com.example.ngidolyuk.Model.BestDealModel;
import com.example.ngidolyuk.Model.CategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {
    void onCategoryLoadSucces(List<CategoryModel> categoryModels);
    void onCategoryLoadFailed (String message);
}
