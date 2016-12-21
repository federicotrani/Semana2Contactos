package com.example.ftrani.semana2contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    TextView tvFecha;
    int dia, mes, anio;
    String nombre, email, telefono, descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle p = getIntent().getExtras();

        nombre = p.getString(getResources().getString(R.string.pnombre));
        telefono = p.getString(getResources().getString(R.string.ptelefono));
        email = p.getString(getResources().getString(R.string.pemail));
        descripcion = p.getString(getResources().getString(R.string.pdescripcion));
        //String fecha = p.getString(getResources().getString(R.string.pfecha));
        dia = p.getInt("Dia");
        mes = p.getInt("Mes");
        anio = p.getInt("Anio");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvFecha = (TextView) findViewById(R.id.tvFecha);

        tvNombre.setText(nombre);
        tvDescripcion.setText(String.format("Descripción: %s", descripcion));
        tvTelefono.setText(String.format("Tel: %s", telefono));
        tvEmail.setText(String.format("Email: %s",email));
        tvFecha.setText(String.format("Fecha Nacimiento: %1d de %2s de %3d",dia,mostrarMes(mes),anio));

    }


    protected void abrirEditar(View v){
        //objeto que vincula las activity origen y destino
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(getResources().getString(R.string.pnombre), this.nombre);
        intent.putExtra(getResources().getString(R.string.ptelefono), this.telefono);
        intent.putExtra(getResources().getString(R.string.pemail), this.email);
        intent.putExtra(getResources().getString(R.string.pdescripcion), this.descripcion);
        intent.putExtra(getResources().getString(R.string.pdia), this.dia);
        intent.putExtra(getResources().getString(R.string.pmes), this.mes);
        intent.putExtra(getResources().getString(R.string.panio), this.anio);

        startActivity(intent);
        finish();
    }

    protected String mostrarMes(int mes){

        String valor = "";
        switch(mes){
            case 1:
                valor = "Enero";
                break;
            case 2:
                valor = "Febrero";
                break;
            case 3:
                valor = "Marzo";
                break;
            case 4:
                valor = "Abril";
                break;
            case 5:
                valor = "Mayo";
                break;
            case 6:
                valor = "Junio";
                break;
            case 7:
                valor = "Julio";
                break;
            case 8:
                valor = "Agosto";
                break;
            case 9:
                valor = "Setiembre";
                break;
            case 10:
                valor = "Octubre";
                break;
            case 11:
                valor = "Noviembre";
                break;
            case 12:
                valor = "Diciembre";
                break;
        }

        return valor;

    }
}
