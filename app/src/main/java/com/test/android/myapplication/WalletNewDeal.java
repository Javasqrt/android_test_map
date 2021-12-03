package com.test.android.myapplication;


import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class WalletNewDeal extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_new_deal);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}