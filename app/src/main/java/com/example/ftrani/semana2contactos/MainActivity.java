package com.example.ftrani.semana2contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtFecha;
    private EditText edtTelefono;
    private EditText edtEmail;
    private EditText edtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtFecha = (EditText) findViewById(R.id.edtFecha);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);

    }

    protected void abrirContacto(View v){

                //objeto que vincula las activity origen y destino
                Intent intent = new Intent(this, ConfirmarDatos.class);


                intent.putExtra(getResources().getString(R.string.pnombre), edtNombre.getText());
                intent.putExtra(getResources().getString(R.string.ptelefono),edtTelefono.getText());
                intent.putExtra(getResources().getString(R.string.pemail),edtEmail.getText());
                intent.putExtra(getResources().getString(R.string.pdescripcion),edtDescripcion.getText());
                intent.putExtra(getResources().getString(R.string.pfecha),edtFecha.getText());

                startActivity(intent);
                finish();

    }




}
