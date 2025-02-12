package com.example.labor7;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private String mName;
    private int mThumbnailDrawable;
    private String mInfo;

    public Animal(String mName, int mThumbnailDrawable, String mInfo) {
        this.mName = mName;
        this.mInfo = mInfo;
        this.mThumbnailDrawable = mThumbnailDrawable;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmThumbnailDrawable() {
        return mThumbnailDrawable;
    }

    public void setmThumbnailDrawable(int mThumbnailDrawable) {
        this.mThumbnailDrawable = mThumbnailDrawable;
    }

    public String getmInfo() {
        return mInfo;
    }

    public void setmInfo(String mInfo) {
        this.mInfo = mInfo;
    }

    public static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Octopus", R.drawable.octopus, "8 tentacled monster"));
        animals.add(new Animal("Pig", R.drawable.pig, "Delicious in rolls"));
        animals.add(new Animal("Sheep", R.drawable.sheep, "Great for jumpers"));
        animals.add(new Animal("Cat", R.drawable.cat, "Expert at napping and catching mice"));
        animals.add(new Animal("Giraffe", R.drawable.giraffe, "Tall and graceful with an excellent view"));
        animals.add(new Animal("Horse", R.drawable.horse, "Fast and majestic, perfect for riding"));
        animals.add(new Animal("Dog", R.drawable.dog, "Loyal companion and expert at fetching"));
        animals.add(new Animal("Lion", R.drawable.lion, "King of the jungle with a mighty roar"));
        animals.add(new Animal("Rabbit", R.drawable.rabbit, "Quick and fluffy"));
        return animals;
    }

}