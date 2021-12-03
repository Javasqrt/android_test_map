package com.test.android.myapplication.ui.wallet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {


    private MutableLiveData<String> string;
    public WalletViewModel() {
        string = new MutableLiveData<>();

        string.setValue("asjdkf");
    }

    public LiveData<String> getText() {
        return string;
    }
}