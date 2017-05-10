package com.tcc.luan.biob.base_application.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tcc.luan.biob.R;
import com.tcc.luan.biob.base_application.model.SESSION;

public class SplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

//        DataBase db = new DataBase(this);
//        String senha = DataBase.toMD5("luna");
//        db.insert("user",new Column[]{new Column("name","luan"), new Column("password",senha)});

        Handler h = new Handler();
        h.postDelayed(this,5000);
    }

    @Override
    public void run() {
        Class<?> destiny;
        if (SESSION.getInstance().getUser() != null)
            destiny = MainActivity.class;
        else
            destiny = LoginActivity.class;

        Intent t = new Intent(this, destiny);
        startActivity(t);
        finish();
    }
}
