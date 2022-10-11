package com.example.Tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Iniciar extends AppCompatActivity implements View.OnClickListener {
Button btnEditar, btnEliminar, btnMostrar, btnSalir;
TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar);
        nombre=(TextView) findViewById(R.id.nombreUsuario);
        btnEditar=(Button) findViewById(R.id.btnEditar);
        btnEliminar=(Button) findViewById(R.id.btnEliminar);
        btnMostrar=(Button) findViewById(R.id.btnMostrar);
        btnSalir=(Button) findViewById(R.id.btnSalir);

        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditar:
                Intent i3 = new Intent(Iniciar.this,Editar.class);
                startActivity(i3);
                finish();
                break;
            case R.id.btnEliminar:
                break;
            case R.id.btnMostrar:
                Intent i2 = new Intent(Iniciar.this,Mostrar.class);
                startActivity(i2);
                finish();
                break;
            case R.id.btnSalir:
                Intent i = new Intent(Iniciar.this,SplashScreen.class);
                startActivity(i);
                finish();
                break;
        }

    }
}