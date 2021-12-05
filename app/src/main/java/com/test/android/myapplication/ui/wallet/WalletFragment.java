package com.test.android.myapplication.ui.wallet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.android.myapplication.R;
import com.test.android.myapplication.RecyclerViewAdapter;
import com.test.android.myapplication.WalletNewDeal;
import com.test.android.myapplication.database.DBHelper;
import com.test.android.myapplication.databinding.FragmentWalletBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class WalletFragment extends Fragment{

    private WalletViewModel walletViewModel;
    private FragmentWalletBinding binding;
    private ImageButton new_deal_btn;
    private ArrayList<String> arrayList;
    private RecyclerView recyclerView;
    private WalletNewDeal walletNewDeal;
    RecyclerViewAdapter recyclerViewAdapter = null;
    private static int recyclerViewCount;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentWalletBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        walletViewModel =
                new ViewModelProvider(this,new NewDealFactory(requireActivity().getApplication(), recyclerViewAdapter)).get(WalletViewModel.class);

        new_deal_btn = view.findViewById(R.id.new_deal);
        recyclerView = view.findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


       /* if(requireActivity().getIntent().getStringExtra("text_new_deal_string") != null &&
        requireActivity().getIntent().getStringExtra("text_sum_transaction_string") != null){
            recyclerViewCount++;
            recyclerViewAdapter = new RecyclerViewAdapter(recyclerViewCount,requireActivity().getIntent().getStringExtra("text_new_deal_string"), requireActivity().getIntent().getStringExtra("text_sum_transaction_string"), Calendar.getInstance().getTime().toString(),R.color.red);


        }
        recyclerView.setAdapter(recyclerViewAdapter);*/
        new_deal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().startActivity(new Intent(getActivity(), WalletNewDeal.class));
                requireActivity().overridePendingTransition(0,0);
            }
        });

            walletViewModel.getRecyclerView().observe(getViewLifecycleOwner(), new Observer<RecyclerViewAdapter>() {
                @Override
                public void onChanged(@Nullable RecyclerViewAdapter sRecyclerViewAdapter) {

                    recyclerView.setAdapter(sRecyclerViewAdapter);
                }
            });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}