package com.example.ftrani.semana2contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre;
    private DatePicker dtpFecha;
    private EditText edtTelefono;
    private EditText edtEmail;
    private EditText edtDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        //edtFecha = (EditText) findViewById(R.id.edtFecha);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);
        dtpFecha = (DatePicker) findViewById(R.id.dtpFecha);

        //capturo parametros de activity previa
        if(getIntent().getExtras()!=null){

            Bundle p = getIntent().getExtras();

            String nombre = p.getString(getResources().getString(R.string.pnombre));
            String telefono = p.getString(getResources().getString(R.string.ptelefono));
            String email = p.getString(getResources().getString(R.string.pemail));
            String descripcion = p.getString(getResources().getString(R.string.pdescripcion));
            //String fecha = p.getString(getResources().getString(R.string.pfecha));
            int dia = p.getInt(getResources().getString(R.string.pdia));
            int mes = p.getInt(getResources().getString(R.string.pmes));
            int anio = p.getInt(getResources().getString(R.string.panio));


            //asigno parametros a controles de edición
            edtNombre.setText(nombre);
            dtpFecha.updateDate(dia,mes,anio);
            //edtFecha.setText(fecha);
            edtTelefono.setText(telefono);
            edtEmail.setText(email);
            edtDescripcion.setText(descripcion);


        }

    }

    protected void abrirContacto(View v){

                //objeto que vincula las activity origen y destino
                Intent intent = new Intent(this, ConfirmarDatos.class);

                //intent.putExtra(getResources().getString(R.string.pnombre), edtNombre.getText());
                intent.putExtra(getResources().getString(R.string.pnombre), edtNombre.getText().toString().toUpperCase());
                intent.putExtra(getResources().getString(R.string.ptelefono),edtTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),edtEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion),edtDescripcion.getText().toString());
                //intent.putExtra(getResources().getString(R.string.pfecha),edtFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdia), dtpFecha.getDayOfMonth());
                intent.putExtra(getResources().getString(R.string.pmes), dtpFecha.getMonth());
                intent.putExtra(getResources().getString(R.string.panio), dtpFecha.getYear());

                startActivity(intent);
                finish();

    }




}
