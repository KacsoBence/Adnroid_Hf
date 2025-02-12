package com.example.labor7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Animal animal = animals.get(position);
        holder.image.setImageResource(animal.getmThumbnailDrawable());
        holder.name.setText(animal.getmName());
        holder.info.setText(animal.getmInfo());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    private Activity context;
    private List<Animal> animals;

    public AnimalsAdapter(Activity context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView info;

        public VH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            info = itemView.findViewById(R.id.info);
        }
    }

}