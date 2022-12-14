package com.example.Tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingUp extends AppCompatActivity implements View.OnClickListener {
 EditText us, pas, nom, ap;
 Button reg,can;
 daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        us=(EditText) findViewById(R.id.UserSingUp);
        nom=(EditText) findViewById(R.id.name);
        ap=(EditText) findViewById(R.id.lastName);
        pas=(EditText)findViewById(R.id.PasswordSingUp);

        reg=(Button)findViewById(R.id.buttonSingUp);
        can=(Button)findViewById(R.id.btnRegCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new daoUsuario(this);


    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.buttonSingUp:
            Usuario u=new Usuario();
            u.setUsuario(us.getText().toString());
            u.setNombre(nom.getText().toString());
            u.setApellidos(ap.getText().toString());
            u.setPassword(pas.getText().toString());

            if(!u.isNull()){
                Toast.makeText(this,"ERROR: Campos vacios", Toast.LENGTH_LONG).show();
            } else if (dao.insertUsuario(u)){
                Toast.makeText(this,"Registro exitoso", Toast.LENGTH_LONG).show();
                Intent i2=new Intent(SingUp.this,SplashScreen.class);
                startActivity(i2);
                finish();
            }else {
                Toast.makeText(this,"El usuario ya se encuentra registrado", Toast.LENGTH_LONG).show();
            }
            break;
            case  R.id.btnRegCancelar:
                Intent i = new Intent(SingUp.this,SplashScreen.class);
                startActivity(i);
                finish();
                break;
    }
    }
}









