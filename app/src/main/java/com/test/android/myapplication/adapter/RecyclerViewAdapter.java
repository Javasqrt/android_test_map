package com.test.android.myapplication.adapter;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.android.myapplication.R;
import com.test.android.myapplication.database.DBHelper;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> implements AdapterView.OnItemClickListener {
    private  ArrayList<TableRowView> arrayList;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;
    int color;
    public RecyclerViewAdapter( ArrayList<TableRowView> arrayList){
        this.arrayList = arrayList;


    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        dbHelper = new DBHelper(parent.getContext());
        int list_item_new_deal = R.layout.list_item_fragment_new_deal;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(list_item_new_deal,parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        TableRowView tableRowView = arrayList.get(position);
        holder.name_deal.setText(tableRowView.getNameDeal());
        holder.sum_transaction.setText(tableRowView.getSum_transaction());
        holder.sum_transaction.setTextColor(tableRowView.getColor());
        holder.text_time.setText(tableRowView.getTime());

    }

    public void deleteElements(int position){
        // TODO: delete arraylist element from position and from database
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        deleteElements(position);
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        deleteElements(position);
                    }
                }
            });



        }



    }
}
