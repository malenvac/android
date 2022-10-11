package com.example.Tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity implements View.OnClickListener {
  EditText user , pass;
  Button btnEntrar, btnRegistrar;
  daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        user=(EditText) findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.btnEntrar:
              String u=user.getText().toString();
              String p=pass.getText().toString();
              if (u.equals("")&&p.equals("")){
                  Toast.makeText(this, "Error: Campos Vacios", Toast.LENGTH_SHORT).show();

              }else if(dao.login(u,p)==1){
                  Usuario ux=dao.getUsuario(u,p);
                  Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
                  Intent i2= new Intent(SplashScreen.this,Inicio.class);   //Me lleva a la pantalla de inicio//
                  i2.putExtra("Id", ux.getId());
                  startActivity(i2);

              }else {
                  Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
              }
              break;
          case R.id.btnRegistrar:
              Intent i= new Intent(SplashScreen.this,SingUp.class);
              startActivity(i);
              break;

      }
    }
}












