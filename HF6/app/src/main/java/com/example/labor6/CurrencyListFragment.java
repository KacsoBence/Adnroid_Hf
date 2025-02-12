package com.example.labor6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CurrencyListFragment extends Fragment {

    String[] titleArray = {"EUR","USD","GBP","AUD",
            "CAD","CHF","DKK","HUFF","PLN", "JPY", "SEK"};

    String[] infoArray = {"EURO",
            "AMERICAN DOLLAR",
            "BRITISH POUND",
            "AUSTRALIAN DOLLAR",
            "CANADIAN DOLLAR",
            "SWISS FRANC",
            "DANISH KRONE",
            "HUNGARIAN FORINT",
            "POLISH ZLOTY",
            "JAPAN JEN",
            "SWEDISH KRONA"
    };

    Integer[] imageArray = {R.drawable.eu,
            R.drawable.us,
            R.drawable.uk,
            R.drawable.aud,
            R.drawable.cad,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.huf,
            R.drawable.pln,
            R.drawable.jpy,
            R.drawable.sek
    };

    float[] buyPriceArray = {4.782f,
            4.321f,
            5.843f,
            3.061f,
            3.260f,
            5.282f,
            0.671f,
            0.012f,
            1.142f,
            0.022f,
            0.421f};

    float[] sellPriceArray = {4.791f,
            4.543f,
            5.946f,
            3.074f,
            3.302f,
            5.301f,
            0.679f,
            0.023f,
            1.163f,
            0.036f,
            0.443f};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_list, container, false);

        ListView list = view.findViewById(R.id.customListView);
        CustomListAdapter adapter = new CustomListAdapter(getActivity(), titleArray, infoArray, imageArray);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CurrencyDetailFragment detailFragment = CurrencyDetailFragment.newInstance(buyPriceArray[i], sellPriceArray[i]);

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_right, detailFragment)
                            .commit();
                    requireActivity().findViewById(R.id.fragment_container_right).setVisibility(View.VISIBLE);
                } else {
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, detailFragment)
                            .addToBackStack(null)
                            .commit();
                    requireActivity().findViewById(R.id.fragment_container_right).setVisibility(View.GONE);
                }
            }
        });

        return view;
    }

}