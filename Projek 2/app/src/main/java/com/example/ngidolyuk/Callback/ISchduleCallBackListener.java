package com.example.ngidolyuk.Callback;

import com.example.ngidolyuk.Model.BestDealModel;
import com.example.ngidolyuk.Model.SchduleModel;

import java.util.List;

public interface ISchduleCallBackListener {
    void onSchduleLoadSucces(List<SchduleModel> SchduleModels);
    void onSchduleLoadFailed (String message);
}
