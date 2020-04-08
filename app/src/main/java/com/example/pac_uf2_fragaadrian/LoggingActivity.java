package com.example.pac_uf2_fragaadrian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoggingActivity extends AppCompatActivity {

    //Atributos

    EditText texto_nombre_usuario;
    EditText texto_contraseña;
    Button accede_buttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);

        //Asociación de los objectos con su elemento en la interfaz

        texto_nombre_usuario = findViewById(R.id.texto_nombre_usuario);
        texto_contraseña = findViewById(R.id.texto_contraseña);
        accede_buttom = findViewById(R.id.accede_button);
        accede_buttom.setOnClickListener(new View.OnClickListener() {

            //Acciones que suceden al pulsar el botón Accede

            @Override
            public void onClick(View v) {

                BaseDeDatos bd = new BaseDeDatos(LoggingActivity.this, "appAndroid", null, 1);
                //bd.getData();
                if (bd.checkUser(texto_nombre_usuario.getText().toString(), texto_contraseña.getText().toString())){
                    Toast.makeText(LoggingActivity.this,getString(R.string.inicioCorrecto_toast),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoggingActivity.this, LoggedActivity.class));
                }else{
                    Toast.makeText(LoggingActivity.this,getString(R.string.datosIncorrectos_toast),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
