package com.example.ngidolyuk.ui.schdule;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ngidolyuk.Callback.ISchduleCallBackListener;
import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.SchduleModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SchduleViewModel extends ViewModel implements ISchduleCallBackListener {

   private MutableLiveData<List<SchduleModel>> schduleListMutable;
   private MutableLiveData<String> messageError = new MutableLiveData<>();
   private ISchduleCallBackListener schduleCallBackListener;


    public SchduleViewModel() {
        schduleCallBackListener = this;
    }

    public MutableLiveData<List<SchduleModel>> getSchduleListMutable() {
        if (schduleListMutable == null)
        {
            schduleListMutable = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadSchdule();
        }
        return schduleListMutable;
    }

    private void loadSchdule() {
        List<SchduleModel> tempList = new ArrayList<>();
        DatabaseReference schduleRef = FirebaseDatabase.getInstance().getReference(Common.SCHDULE_REF);
        schduleRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapShot:dataSnapshot.getChildren())
                {
                   SchduleModel schduleModel = itemSnapShot.getValue(SchduleModel.class);
                   schduleModel.setId(itemSnapShot.getKey());
                   tempList.add(schduleModel);
                }
                schduleCallBackListener.onSchduleLoadSucces(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                schduleCallBackListener.onSchduleLoadFailed(databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onSchduleLoadSucces(List<SchduleModel> schduleModelList) {
        schduleListMutable.setValue(schduleModelList);
    }

    @Override
    public void onSchduleLoadFailed(String message) {
        messageError.setValue(message);
    }
}