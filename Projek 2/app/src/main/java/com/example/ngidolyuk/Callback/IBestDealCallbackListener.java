package com.example.ngidolyuk.Callback;

import com.example.ngidolyuk.Model.BestDealModel;

import java.util.List;

public interface IBestDealCallbackListener {
    void onBestDealLoadSucces(List<BestDealModel> bestDealModels);
    void onBestDealLoadFailed (String message);
}
