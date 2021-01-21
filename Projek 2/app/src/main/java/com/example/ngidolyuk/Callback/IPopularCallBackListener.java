package com.example.ngidolyuk.Callback;

import com.example.ngidolyuk.Model.PopularCategoryModel;

import java.util.List;

public interface IPopularCallBackListener {
    void onPopularLoadSucces(List<PopularCategoryModel> popularCategoryModels);
    void onPopularLoadFailed (String message);

}
