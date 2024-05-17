package com.example.idgs9a11manoactivity211068;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idgs9a11manoactivity211068.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMainBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());
        binding.tvText.setText(String.valueOf(count));
        binding.btnRst.setOnClickListener(view -> {
            reset();
        });
        binding.btnInc.setOnClickListener(view ->{
            incrementar();
        });
        binding.btnDesc.setOnClickListener(view ->{
            decrementar();
        });

    }

    private void decrementar() {
        if (count == 0){
            Toast.makeText(this, "no puedes decrementar el 0", Toast.LENGTH_SHORT).show();
            return;
        }
        count--;
        binding.tvText.setText(String.valueOf(count));
    }

    private void incrementar() {

        count++;
        binding.tvText.setText(String.valueOf(count));
    }

    private void reset() {

        count = 0;
        binding.tvText.setText(String.valueOf(count));
    }
}