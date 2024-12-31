package com.example.read_write_externel_storage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.read_write_externel_storage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initlization();
    }
    void initlization(){
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        buttons();
    }
    void buttons(){
        binding.btnClear.setOnClickListener(v->{
            binding.etText.setText("");
        });
        binding.btnReadData.setOnClickListener(v->{

        });
        binding.btnWriteData.setOnClickListener(v->{

        });
    }
}