package com.justforfun.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void loginFacebook(View view){

    }

    public void login(View view){
        Intent intent = new Intent(this,PromotionListActivity.class);
        startActivity(intent);
        finish();
    }
}
