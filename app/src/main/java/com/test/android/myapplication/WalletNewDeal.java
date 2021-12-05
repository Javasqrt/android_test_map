package com.test.android.myapplication;


import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.android.myapplication.ui.wallet.WalletFragment;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class WalletNewDeal extends FragmentActivity {

    public RecyclerViewAdapter recyclerViewAdapter = null;
    EditText text_new_deal;
    EditText text_sum_transaction;
   // EditText text_date;
    private static int num;
    String text_new_deal_string, text_sum_transaction_string;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_new_deal);
        text_new_deal = findViewById(R.id.text_new_deal);
        text_sum_transaction = findViewById(R.id.text_sum_transaction);
        //text_date = findViewById(R.id.text_date);
        add = findViewById(R.id.add);
    }

    @Override
    protected void onStart() {
        super.onStart();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalletNewDeal.this, MainActivity.class);
                if(checkEditText(text_new_deal)){
                   //intent.putExtra("text_new_deal_string",text_new_deal.getText().toString());
                    text_new_deal_string = text_new_deal.getText().toString();
                }else {
                    text_new_deal.setError("Field is empty!");
                    return;

                }
                if(checkEditText(text_sum_transaction)){
                   // intent.putExtra("text_sum_transaction_string",text_sum_transaction.getText().toString());
                    text_sum_transaction_string = text_sum_transaction.getText().toString();
                }else {
                    text_sum_transaction.setError("Field is empty!");
                    return;

                }
                num ++;
                recyclerViewAdapter = new RecyclerViewAdapter(num,text_new_deal_string,text_sum_transaction_string,Calendar.getInstance().getTime().toString(),R.color.green);
                overridePendingTransition(0,0);
                finish();
            }
        });

    }

    private boolean checkEditText(EditText editText) {
        return !editText.getText().toString().matches("");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}