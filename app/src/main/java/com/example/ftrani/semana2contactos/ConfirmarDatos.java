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

        Bundle p = getIntent().getExtras();

        String nombre = p.getString(getResources().getString(R.string.pnombre));

        String telefono = p.getString(getResources().getString(R.string.ptelefono));
        String email = p.getString(getResources().getString(R.string.pemail));
        String descripcion = p.getString(getResources().getString(R.string.pdescripcion));
        String fecha = p.getString(getResources().getString(R.string.pfecha));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvFecha = (TextView) findViewById(R.id.tvFecha);

        tvNombre.setText(nombre);
        tvDescripcion.setText(descripcion);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvFecha.setText(fecha);


        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //objeto que vincula las activity origen y destino
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);

                intent.putExtra(getResources().getString(R.string.pnombre), tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tvDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), tvFecha.getText().toString());

                startActivity(intent);
                finish();
            }
        });
    }
}
