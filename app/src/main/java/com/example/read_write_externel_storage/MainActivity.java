package com.example.read_write_externel_storage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.read_write_externel_storage.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

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
            try {
                File dir =getExternalFilesDir(null);
                File file=new File(dir,"myfile.txt");
                FileInputStream fin=new FileInputStream(file);
                BufferedReader br=new BufferedReader(new InputStreamReader(fin));
                StringBuilder  sb=new StringBuilder();
                String Line;
                while((Line=br.readLine())!=null){
                    sb.append(Line).append("\n");
                }
                binding.etText.setText(sb.toString());
                br.close();
                fin.close();
                Snackbar.make(binding.btnReadData,"Message Read Successfuly",Snackbar.LENGTH_SHORT).show();
            }
            catch (Exception e){

            }
        });
        binding.btnWriteData.setOnClickListener(v->{
            try {
                String msg=binding.etText.getText().toString().trim();
                if(msg.isEmpty()){
                    binding.etText.setError("Message is Empty");
                    binding.etText.requestFocus();
                }
                else{
                    File directory=getExternalFilesDir(null);
                    File file=new File(directory,"myfile.txt");
                    FileOutputStream fout=new FileOutputStream(file);
                    fout.write(msg.getBytes());
                    fout.close();
                    Snackbar.make(binding.btnReadData,"Message Write Successfuly",Snackbar.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                Snackbar.make(binding.btnReadData,"Error:"+e,Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}