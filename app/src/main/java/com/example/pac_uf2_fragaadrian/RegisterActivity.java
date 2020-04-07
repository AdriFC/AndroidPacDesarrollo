package com.example.pac_uf2_fragaadrian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    //Atributos

    EditText texto_nombre;
    EditText texto_apellido;
    EditText texto_nombre_usuario;
    EditText texto_contraseña;
    EditText texto_email;
    Button registernow_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        texto_nombre = findViewById(R.id.texto_nombre);
        texto_apellido = findViewById(R.id.texto_apellido);
        texto_nombre_usuario = findViewById(R.id.texto_nombre_usuario);
        texto_contraseña = findViewById(R.id.texto_contraseña);
        texto_email = findViewById(R.id.texto_email);
        registernow_button = findViewById(R.id.registernow_button);
        registernow_button.setOnClickListener(new View.OnClickListener() {

            //Acciones que suceden al pulsar el botón Regístrame ya! Se llama a la función que registra un nuevo usuario en la bbdd y se pasa a la activity de login
            @Override
            public void onClick(View v) {
                registerUser ();
                startActivity(new Intent(RegisterActivity.this, LoggingActivity.class));
            }
        });
    }

    //Función para registrar un nuevo usuario en la BBDD SQLite de la app
    private void registerUser() {
        BaseDeDatos bd = new BaseDeDatos(this, "appAndroid", null, 1);
        bd.insertData(texto_nombre.getText().toString(), texto_apellido.getText().toString(), texto_nombre_usuario.getText().toString(), texto_contraseña.getText().toString(), texto_email.getText().toString());
        bd.getData();
    }
}
