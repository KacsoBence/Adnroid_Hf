package com.example.labor6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] nameArray;
    private final String[] infoArray;
    private final Integer[] imageArray;

    public CustomListAdapter(@NonNull Activity context, String[] nameArray, String[] infoArray, Integer[] imageArray) {
        super(context, R.layout.listview_row, nameArray);
        this.context = context;
        this.nameArray = nameArray;
        this.infoArray = infoArray;
        this.imageArray = imageArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView title = rowView.findViewById(R.id.title);
        TextView info = rowView.findViewById(R.id.info);
        ImageView image = rowView.findViewById(R.id.image);

        title.setText(nameArray[position]);
        info.setText(infoArray[position]);
        image.setImageResource(imageArray[position]);

        return rowView;
    }

}