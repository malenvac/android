package com.example.Tarea1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Iniciar extends AppCompatActivity implements View.OnClickListener {
Button btnEditar, btnEliminar, btnMostrar, btnSalir;
TextView nombre;
int id=0;
Usuario u;
daoUsuario dao;

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

        Bundle b = getIntent().getExtras();
        id = b.getInt("Id");
        dao = new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText("Hola " + u.getNombre() + " " + u.getApellidos());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditar:
                Intent a = new Intent(Iniciar.this,Editar.class);
                a.putExtra("Id", id);
                startActivity(a);
                finish();
                break;
            case R.id.btnEliminar:
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setMessage("Su cuenta sera eliminada ¿Desea continuar?");
                b.setCancelable(false);
                b.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dao.deleteUsuario(id)){
                            Toast.makeText(Iniciar.this,"Eliminación exitosa", Toast.LENGTH_LONG).show();
                            Intent a = new Intent(Iniciar.this,SplashScreen.class);
                            startActivity(a);
                            finish();

                        } else{
                            Toast.makeText(Iniciar.this,"Error: No se puede eliminar", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                public void onClick(DialogInterface dialogInterface, int i){
                        dialogInterface.cancel();
                    }
            });
                b.show();

                break;
            case R.id.btnMostrar:
                Intent c= new Intent(Iniciar.this,Mostrar.class);
                startActivity(c);
                break;
            case R.id.btnSalir:
                Intent i = new Intent(Iniciar.this,SplashScreen.class);
                startActivity(i);
                finish();
                break;
        }

    }
}