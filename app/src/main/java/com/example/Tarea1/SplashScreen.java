package com.example.Tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SplashScreen extends AppCompatActivity implements View.OnClickListener {
  EditText user , pass;
  Button btnEntrar, btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        user=(EditText) findViewById(R.id.UserSingIn);
        pass=(EditText)findViewById(R.id.PasswordSingIn);
        btnEntrar=(Button)findViewById(R.id.singIn);
        btnRegistrar=(Button)findViewById(R.id.singUp1);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.singIn:
              break;
          case R.id.singUp1:
              Intent i= new Intent(SplashScreen.this,SingUp.class);
              startActivity(i);
              break;

      }
    }
}












