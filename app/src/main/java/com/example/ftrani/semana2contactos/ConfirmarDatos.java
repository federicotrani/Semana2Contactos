package com.example.ftrani.semana2contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    TextView tvFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        //objeto para almacenar parametros pasados en el intent
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvFecha = (TextView) findViewById(R.id.tvFecha);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
        tvFecha.setText(fecha);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //objeto que vincula las activity origen y destino
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);

                intent.putExtra(getResources().getString(R.string.pnombre), tvNombre.getText());
                intent.putExtra(getResources().getString(R.string.ptelefono), tvTelefono.getText());
                intent.putExtra(getResources().getString(R.string.pemail), tvEmail.getText());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tvDescripcion.getText());
                intent.putExtra(getResources().getString(R.string.pfecha), tvFecha.getText());

                startActivity(intent);
                finish();
            }
        });
    }
}
