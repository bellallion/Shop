package com.example.contextintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contextintent.databinding.ShopBinding;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ShopBinding binding = ShopBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //находим интент по которому можно позвонить
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + binding.phone.getText().toString()));
                startActivity(intent);
            }
        });
        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "";

                if(binding.chb1.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + ", " + binding.chb1.getText().toString();
                    }else{
                        res = binding.chb1.getText().toString();
                    }
                }
                if(binding.chb2.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + ", " + binding.chb2.getText().toString();
                    }else{
                        res = binding.chb2.getText().toString();
                    }
                }
                if(binding.chb3.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + ", " + binding.chb3.getText().toString();
                    }else{
                        res = binding.chb3.getText().toString();
                    }
                }
                if(binding.chb4.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + ", " + binding.chb4.getText().toString();
                    }else{
                        res = binding.chb4.getText().toString();
                    }
                }
                if(binding.chb5.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + ", " + binding.chb5.getText().toString();
                    }else{
                        res = binding.chb5.getText().toString();
                    }
                }
                if(binding.chb6.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + ", " + binding.chb6.getText().toString();
                    }else{
                        res = binding.chb6.getText().toString();
                    }
                }
                if(binding.rb1.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + "\n" + binding.rb1.getText().toString();
                    }else{
                        res = binding.rb1.getText().toString();
                    }
                }
                if(binding.rb2.isChecked()){
                    if(!res.isEmpty()) {
                        res = res + "\n" + binding.rb2.getText().toString();
                    }else{
                        res = binding.rb2.getText().toString();
                    }
                }
                if(res.isEmpty()){
                    res = "нет товаров";
                }
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"my@gmai.ru"});
                intent.putExtra(Intent.EXTRA_TEXT, "Моя доставка:\n" + res);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Напоминание о доставке");
                startActivity(intent);





            }
        });

    }
}
