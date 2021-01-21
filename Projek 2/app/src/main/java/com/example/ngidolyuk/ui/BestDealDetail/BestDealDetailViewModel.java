package com.example.ngidolyuk.ui.BestDealDetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.BestDealListModel;

public class BestDealDetailViewModel extends ViewModel {

    private MutableLiveData<BestDealListModel> mutableLiveDataDetail;

    public BestDealDetailViewModel() {

    }

    public MutableLiveData<BestDealListModel> getMutableLiveDataDetail() {
        if(mutableLiveDataDetail == null)
            mutableLiveDataDetail = new MutableLiveData<>();
        mutableLiveDataDetail.setValue(Common.selectedBestdeal);
        return mutableLiveDataDetail;
    }
}