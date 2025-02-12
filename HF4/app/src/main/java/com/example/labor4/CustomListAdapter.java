package com.example.labor4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListAdapter extends ArrayAdapter {
    private Activity context;
    private String[] nameArray;
    private String[] infoArray;
    private Integer[] imageArray;
    private float[] buyPriceArray;
    private float[] sellPriceArray;

    public CustomListAdapter(@NonNull Activity context, String[] nameArray, String[] infoArray, Integer[] imageArray, float[] buyPriceArray, float[] sellPriceArray) {
        super(context, R.layout.listview_row, nameArray);
        this.context = context;
        this.nameArray = nameArray;
        this.infoArray = infoArray;
        this.imageArray = imageArray;
        this.buyPriceArray = buyPriceArray;
        this.sellPriceArray = sellPriceArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView title = rowView.findViewById(R.id.title);
        TextView info = rowView.findViewById(R.id.info);
        ImageView image = rowView.findViewById(R.id.image);
        TextView buyPrice = rowView.findViewById(R.id.buyPrice);
        TextView sellPrice= rowView.findViewById(R.id.sellPrice);

        title.setText(nameArray[position]);
        info.setText(infoArray[position]);
        image.setImageResource(imageArray[position]);
        buyPrice.setVisibility(View.GONE);
        sellPrice.setVisibility(View.GONE);

        return rowView;
    }

}
