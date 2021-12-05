package com.test.android.myapplication.ui.wallet;

import android.app.Application;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.test.android.myapplication.R;
import com.test.android.myapplication.RecyclerViewAdapter;
import com.test.android.myapplication.TableRowView;
import com.test.android.myapplication.database.DBHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class WalletViewModel extends AndroidViewModel {
    static int num = 1;
    DBHelper dbHelper;
    Intent intent;
    TableRowView tableRowView;
    RecyclerViewAdapter recyclerViewAdapter = null;
    ArrayList<TableRowView> arrayList;
    private MutableLiveData<RecyclerViewAdapter> getRecyclerViewAdapter;
    public WalletViewModel(Application application, RecyclerViewAdapter recyclerViewAdapter) {
        super(application);
        getRecyclerViewAdapter = new MutableLiveData<>();
        this.recyclerViewAdapter = recyclerViewAdapter;
        dbHelper = new DBHelper(getApplication());
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(DBHelper.DATABASE_TABLE,null,null,null,null,null,null);
        arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){

            int spinnerIndex = cursor.getColumnIndex(DBHelper.DEAL_SPINNER);
            int dealIndex = cursor.getColumnIndex(DBHelper.NAME_DEAL);
            int valueIndex = cursor.getColumnIndex(DBHelper.DEAL_VALUE);
            Log.i("qwer", cursor.getString(dealIndex));
            Log.i("qwer",cursor.getString(valueIndex));
            do {
                switch (cursor.getString(spinnerIndex)){
                    case "0":
                        tableRowView =  new TableRowView(cursor.getString(dealIndex), Color.rgb(0,225,0),"+" + cursor.getString(valueIndex) + getApplication().getResources().getString(R.string.currency),Calendar.getInstance().getTime().toString());
                        arrayList.add(tableRowView);
                        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
                        getRecyclerViewAdapter.setValue(recyclerViewAdapter);
                        break;
                    case "1":
                         tableRowView = new TableRowView(cursor.getString(dealIndex), Color.rgb(255,0,0),"-" + cursor.getString(valueIndex) + getApplication().getResources().getString(R.string.currency),Calendar.getInstance().getTime().toString());
                        arrayList.add(tableRowView);
                        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
                        getRecyclerViewAdapter.setValue(recyclerViewAdapter);
                        break;

                }
            } while (cursor.moveToNext());
            cursor.close();
            dbHelper.close();

        } else {
            Log.i("qwer","null");
        }

    }

    public LiveData<RecyclerViewAdapter> getRecyclerView() {
        return getRecyclerViewAdapter;
    }
}