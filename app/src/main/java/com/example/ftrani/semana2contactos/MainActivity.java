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

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //objeto que vincula las activity origen y destino
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

                intent.putExtra(getResources().getString(R.string.pnombre), edtNombre.getText());
                intent.putExtra(getResources().getString(R.string.ptelefono),edtTelefono.getText());
                intent.putExtra(getResources().getString(R.string.pemail),edtEmail.getText());
                intent.putExtra(getResources().getString(R.string.pdescripcion),edtDescripcion.getText());
                intent.putExtra(getResources().getString(R.string.pfecha),edtFecha.getText());

                startActivity(intent);
                finish();
            }
        });

    }




}
