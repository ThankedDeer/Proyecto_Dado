package com.example.idgs9a11manoactivity211068;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.idgs9a11manoactivity211068.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        setContentView(binding.getRoot());

        // Observa los cambios en el contador y actualiza la UI
        viewModel.getCounter().observe(this, count -> {
            binding.tvText.setText(String.valueOf(count));
        });

        binding.btnRst.setOnClickListener(view -> reset());
        binding.btnInc.setOnClickListener(view -> incrementar());
        binding.btnDesc.setOnClickListener(view -> decrementar());
    }

    private void decrementar() {
        if (viewModel.getCounter().getValue() == 0) {
            Toast.makeText(this, "No puedes decrementar el 0", Toast.LENGTH_SHORT).show();
            return;
        }
        int count = viewModel.getCounter().getValue();
        count--;
        viewModel.setCounter(count);
    }

    private void incrementar() {
        int count = viewModel.getCounter().getValue();
        count++;
        viewModel.setCounter(count);
    }

    private void reset() {
        viewModel.setCounter(0);
    }
}
