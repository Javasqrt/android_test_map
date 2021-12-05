package com.test.android.myapplication.ui.wallet;

import android.app.Application;
import android.content.Intent;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.test.android.myapplication.R;
import com.test.android.myapplication.RecyclerViewAdapter;

import java.util.Calendar;

public class WalletViewModel extends AndroidViewModel {

    Intent intent;
    RecyclerViewAdapter recyclerViewAdapter = null;
    private MutableLiveData<RecyclerViewAdapter> getRecyclerViewAdapter;
    public WalletViewModel(Application application) {
        super(application);
        getRecyclerViewAdapter = new MutableLiveData<>();
        //this.recyclerViewAdapter = recyclerViewAdapter;
        //recyclerViewAdapter = new RecyclerViewAdapter(1,"new Deal", "1000", Calendar.getInstance().getTime().toString(), R.color.red);
        getRecyclerViewAdapter.setValue(recyclerViewAdapter);
    }

    public LiveData<RecyclerViewAdapter> getRecyclerViewAdapter() {
        return getRecyclerViewAdapter;
    }
}