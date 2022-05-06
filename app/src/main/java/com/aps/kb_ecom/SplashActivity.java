package com.aps.kb_ecom;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.aps.kb_ecom.activities.LoginActivity;
import com.aps.kb_ecom.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(()->{
            startActivity(new Intent(getApplicationContext() , LoginActivity.class) ) ;
        } , 1000) ;

    }
}