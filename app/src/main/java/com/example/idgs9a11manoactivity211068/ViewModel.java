package com.example.idgs9a11manoactivity211068;

import androidx.lifecycle.MutableLiveData;
import java.util.Random;

public class ViewModel extends androidx.lifecycle.ViewModel {

    public MutableLiveData<Integer> counter;
    public MutableLiveData<Integer> imageResource;

    private final int[] images = {
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };
    private final Random random = new Random();

    public ViewModel() {
        counter = new MutableLiveData<>();
        counter.setValue(0);

        imageResource = new MutableLiveData<>();
        imageResource.setValue(images[random.nextInt(images.length)]);
    }

    public MutableLiveData<Integer> getCounter() {
        return counter;
    }

    public void setCounter(int value) {
        this.counter.setValue(value);
    }

    public MutableLiveData<Integer> getImageResource() {
        return imageResource;
    }

    public void changeImage() {
        int randomIndex = random.nextInt(images.length);
        imageResource.setValue(images[randomIndex]);
    }
}
