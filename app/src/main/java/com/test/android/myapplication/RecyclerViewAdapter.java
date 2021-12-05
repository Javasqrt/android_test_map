package com.test.android.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private ArrayList<Integer> integerArrayList = new ArrayList<>();
    private String new_deal;
    private String sum_transaction;
    private String text_time;
    int color;
    public RecyclerViewAdapter(int numItems, String new_deal, String sum_transaction, String text_time,int color){

        integerArrayList.add(numItems);
        this.new_deal = new_deal;
        this.sum_transaction = sum_transaction;
        this.text_time = text_time;
        this.color = color;

    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int list_item_new_deal = R.layout.list_item_fragment_new_deal;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(list_item_new_deal,parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        viewHolder.name_deal.setText(new_deal);
        viewHolder.sum_transaction.setText(sum_transaction);
        viewHolder.sum_transaction.setTextColor(color);
        viewHolder.text_time.setText(text_time);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
            TextView name_deal;
            TextView sum_transaction;
            TextView text_time;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            name_deal = itemView.findViewById(R.id.name_deal);
            sum_transaction = itemView.findViewById(R.id.sum_transaction);
            text_time = itemView.findViewById(R.id.text_time);

        }

    }
}
