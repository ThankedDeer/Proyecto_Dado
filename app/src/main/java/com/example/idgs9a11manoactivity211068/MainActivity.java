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



        // Observa los cambios en la imagen y actualiza el ImageView
        viewModel.getImageResource().observe(this, resId -> {
            assert binding.imageView != null;
            binding.imageView.setImageResource(resId);
        });


        assert binding.btnChangeImage != null;
        binding.btnChangeImage.setOnClickListener(view -> viewModel.changeImage());
    }



    private void reset() {
        viewModel.setCounter(0);
    }
}
