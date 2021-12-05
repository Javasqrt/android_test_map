package com.test.android.myapplication;


import androidx.fragment.app.FragmentActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.internal.ResourceUtils;
import com.test.android.myapplication.database.DBHelper;
import com.test.android.myapplication.ui.wallet.WalletFragment;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class WalletNewDeal extends FragmentActivity {

    public RecyclerViewAdapter recyclerViewAdapter = null;
    EditText text_new_deal;
    EditText text_sum_transaction;
    Spinner spinner;
    String[] dealChoose;
   // EditText text_date;
    private static int num;
    String text_new_deal_string, text_sum_transaction_string;
    Button add;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_new_deal);
        text_new_deal = findViewById(R.id.text_new_deal);
        text_sum_transaction = findViewById(R.id.text_sum_transaction);
        //text_date = findViewById(R.id.text_date);
        add = findViewById(R.id.add);
        spinner = findViewById(R.id.spinner);
        dealChoose = new String[]{getResources().getString(R.string.income),getResources().getString(R.string.consumption)};
        dbHelper = new DBHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(WalletNewDeal.this, android.R.layout.simple_spinner_item,dealChoose);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("qwer",String.valueOf(id));
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WalletNewDeal.this, MainActivity.class);
                        if(checkEditText(text_new_deal)){
                            //intent.putExtra("text_new_deal_string",text_new_deal.getText().toString());
                            text_new_deal_string = text_new_deal.getText().toString();
                            contentValues.put(DBHelper.NAME_DEAL, text_new_deal_string);
                        }else {
                            text_new_deal.setError("Field is empty!");
                            return;

                        }
                        if(checkEditText(text_sum_transaction)){
                            // intent.putExtra("text_sum_transaction_string",text_sum_transaction.getText().toString());
                            text_sum_transaction_string = text_sum_transaction.getText().toString();
                            contentValues.put(DBHelper.DEAL_VALUE, text_sum_transaction_string);
                        }else {
                            text_sum_transaction.setError("Field is empty!");
                            return;

                        }
                        num ++;
                        contentValues.put(DBHelper.DEAL_SPINNER, String.valueOf(id));
                        sqLiteDatabase.insert(DBHelper.DATABASE_TABLE,null,contentValues);
                        dbHelper.close();
                        overridePendingTransition(0,0);
                        finish();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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