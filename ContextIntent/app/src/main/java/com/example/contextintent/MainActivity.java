package com.example.contextintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.contextintent.databinding.ActivityMainBinding;
import com.example.contextintent.databinding.LoginBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginBinding binding = LoginBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot()); // наблюдать все элементы главного родителя



        SharedPreferences mPref = getPreferences(MODE_PRIVATE); // не видима для отсальных активити, но взломать можно

        LoginPresenter presenter = new LoginPresenter(this, binding, mPref);
        if(presenter.signInPref()){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(presenter.signIn()){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}