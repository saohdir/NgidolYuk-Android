package com.example.ngidolyuk.EventBus;

import com.example.ngidolyuk.Model.CategoryListModel;

public class categoryItemClick {
    private boolean success;
    private CategoryListModel categoryListModel;

    public categoryItemClick(boolean success, CategoryListModel categoryListModel) {
        this.success = success;
        this.categoryListModel = categoryListModel;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CategoryListModel getCategoryListModel() {
        return categoryListModel;
    }

    public void setCategoryListModel(CategoryListModel categoryListModel) {
        this.categoryListModel = categoryListModel;
    }
}
