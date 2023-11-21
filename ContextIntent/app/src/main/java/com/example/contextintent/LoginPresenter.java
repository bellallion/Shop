package com.example.contextintent;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.contextintent.databinding.LoginBinding;

public class LoginPresenter {
    private static String TRUEPASSWORD = "1234";
    private static String TRUELOGIN = "1234";

    private Context context;
    private LoginBinding binding;
    private SharedPreferences mPref;

    public LoginPresenter(Context context, LoginBinding binding, SharedPreferences mPref){
        this.binding = binding;
        this.mPref = mPref;
        this.context = context;

    }
    public boolean signInPref(){ // уже введено
        String loginPref = mPref.getString("LOGIN","");
        String passwordPref = mPref.getString("PASSWORD","");

        if(loginPref.equals(TRUELOGIN) && passwordPref.equals(TRUEPASSWORD)){
            return true;
        }
        return false;
    }
    public boolean signIn(){

        // есть ли информация и совпадает ли она
        SharedPreferences.Editor edit  = mPref.edit();

        String login = binding.login.getText().toString();
        String password = binding.password.getText().toString();

        if(login.equals(TRUELOGIN)&&password.equals(TRUEPASSWORD)){
            //вовратит через который можем изменять инфу
            // присвоить в кеш (дополнительная память, края не зависит от активити

            edit.putString("LOGIN", login);
            edit.putString("PASSWORD", password);
            edit.commit();
            return true;
        }
        return false;
    }
}
