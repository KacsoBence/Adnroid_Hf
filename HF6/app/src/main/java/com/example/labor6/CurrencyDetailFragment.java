package com.example.labor6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CurrencyDetailFragment extends Fragment {

    private static final String ARG_BUY_PRICE = "buyPrice";
    private static final String ARG_SELL_PRICE = "sellPrice";

    public static CurrencyDetailFragment newInstance(float buyPrice, float sellPrice) {
        CurrencyDetailFragment fragment = new CurrencyDetailFragment();
        Bundle args = new Bundle();
        args.putFloat(ARG_BUY_PRICE, buyPrice);
        args.putFloat(ARG_SELL_PRICE, sellPrice);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_detail, container, false);

        TextView buyPriceText = view.findViewById(R.id.buyPrice);
        TextView sellPriceText = view.findViewById(R.id.sellPrice);

        if (getArguments() != null) {
            float buyPrice = getArguments().getFloat(ARG_BUY_PRICE);
            float sellPrice = getArguments().getFloat(ARG_SELL_PRICE);

            buyPriceText.setText("Buy Price: " + buyPrice + " RON");
            sellPriceText.setText("Sell Price: " + sellPrice + " RON");
        }

        return view;
    }

}