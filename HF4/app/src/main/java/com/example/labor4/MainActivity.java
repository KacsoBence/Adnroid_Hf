package com.example.labor4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView list = findViewById(R.id.customListView);
        CustomListAdapter adapter = new CustomListAdapter(this, titleArray, infoArray, imageArray, buyPriceArray, sellPriceArray);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView buyPrice = view.findViewById(R.id.buyPrice);
                TextView sellPrice = view.findViewById(R.id.sellPrice);

                buyPrice.setText(buyPriceArray[i] + " RON");
                sellPrice.setText(sellPriceArray[i] + " RON");
                buyPrice.setVisibility(View.VISIBLE);
                sellPrice.setVisibility(View.VISIBLE);
            }
        });

    }

}