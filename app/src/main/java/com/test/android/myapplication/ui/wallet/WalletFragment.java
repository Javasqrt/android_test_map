package com.test.android.myapplication.ui.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.test.android.myapplication.R;
import com.test.android.myapplication.WalletNewDeal;
import com.test.android.myapplication.databinding.FragmentWalletBinding;

import java.util.ArrayList;
import java.util.Objects;

public class WalletFragment extends Fragment {

    private WalletViewModel walletViewModel;
    private FragmentWalletBinding binding;
    private ImageButton new_deal_btn;
    private ArrayList<String> arrayList;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        walletViewModel =
                new ViewModelProvider(this).get(WalletViewModel.class);

        binding = FragmentWalletBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        new_deal_btn = view.findViewById(R.id.new_deal);
        listView = view.findViewById(R.id.list);
        new_deal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().startActivity(new Intent(getActivity(), WalletNewDeal.class));
                requireActivity().overridePendingTransition(0,0);
            }
        });
        walletViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}