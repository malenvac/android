package com.example.Tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity implements View.OnClickListener {
EditText ediUser, ediPass, ediNombre, ediApellido;
Button btnEdiActualizar, btnCancelar;
int id=0;
Usuario u;
daoUsuario dao;
Intent x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);
        ediUser = (EditText) findViewById(R.id.EdiUser);
        ediPass = (EditText) findViewById(R.id.EdiPass);
        ediNombre = (EditText) findViewById(R.id.EdiNombre);
        ediApellido = (EditText) findViewById(R.id.EdiApellido);
        btnEdiActualizar = (Button) findViewById(R.id.btnEdiActualizar);
        btnCancelar = (Button) findViewById(R.id.btnEdiCancelar);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        ediUser.setText(u.getUsuario());
        ediPass.setText(u.getPassword());
        ediNombre.setText(u.getNombre());
        ediApellido.setText(u.getApellidos());

    }
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnEdiActualizar:
                    Usuario u=new Usuario();
                    u.setUsuario(ediUser.getText().toString());
                    u.setPassword(ediPass.getText().toString());
                    u.setNombre(ediNombre.getText().toString());
                    u.setApellidos(ediApellido.getText().toString());


                    if(!u.isNull()){
                        Toast.makeText(this,"ERROR: Campos vacios", Toast.LENGTH_LONG).show();
                    } else if (dao.updateUsuario(u)){
                        Toast.makeText(this,"Actualización exitosa", Toast.LENGTH_LONG).show();
                        Intent i2=new Intent(Editar.this,SplashScreen.class);
                        startActivity(i2);
                        finish();
                    }else {
                        Toast.makeText(this,"El usuario ya se encuentra registrado", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.btnEdiCancelar:
                    Intent i = new Intent(Editar.this,SplashScreen.class);
                    startActivity(i);
                    finish();
                    break;
            }

        }

}