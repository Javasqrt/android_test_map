package com.test.android.myapplication.ui.wallet;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.test.android.myapplication.adapter.RecyclerViewAdapter;

public class NewDealFactory extends ViewModelProvider.AndroidViewModelFactory {
    Application application;
    RecyclerViewAdapter recyclerViewAdapter;


    public NewDealFactory(Application application, RecyclerViewAdapter recyclerViewAdapter ){
        super(application);
        this.application = application;
        this.recyclerViewAdapter = recyclerViewAdapter;



    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return ((T) new WalletViewModel(application, recyclerViewAdapter));
    }


}
