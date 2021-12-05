package com.test.android.myapplication;

import android.content.res.ColorStateList;

public class TableRowView {
    String name_deal, sum_transaction, time;
    int color;

    public TableRowView(String name_deal, int color, String sum_transaction, String time){
        this.name_deal = name_deal;
        this.color = color;
        this.sum_transaction = sum_transaction;
        this.time = time;

    }

    public int getColor() {
        return color;
    }


    public String getNameDeal() {
        return name_deal;
    }

    public String getSum_transaction() {
        return sum_transaction;
    }



    public String getTime() {
        return time;
    }




}
