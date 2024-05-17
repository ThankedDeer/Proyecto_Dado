package com.example.idgs9a11manoactivity211068;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    public MutableLiveData<Integer> counter;

    public ViewModel() {
        counter = new MutableLiveData<>();
        counter.setValue(0);
    }

    public MutableLiveData<Integer> getCounter() {
        return counter;
    }

    public void setCounter(int value) {
        this.counter.setValue(value);
    }
}
