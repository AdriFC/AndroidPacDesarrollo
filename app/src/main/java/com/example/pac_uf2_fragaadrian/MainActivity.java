package com.example.pac_uf2_fragaadrian;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Atributos

    Button buttonRegister;  //Botón para acceder al activity de registro
    Button buttonLogin;     //Botón para acceder al activity de login.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonLogin = findViewById(R.id.logging_button);                   //Asocio el objecto botón de login con el botón del layout
        buttonLogin.setOnClickListener(new View.OnClickListener() {        //Asocio la función register al listener del botón
            @Override
            public void onClick(View v) {
                funcionLogin (v);
            }
        });

        buttonRegister = findViewById(R.id.register_button);                //Asocio el objecto botón de registro con el botón del layout
        buttonRegister.setOnClickListener(new View.OnClickListener() {      //Asocio la función register al listener del botón
            @Override
            public void onClick(View v) {
                funcionRegister (v);
            }
        });
    }

    //Función que se ejecuta al pulsar el botón de Identifícate! Visto en videotutoría
    public void funcionLogin (View v){
        Toast.makeText(this,getString(R.string.loging_toast),Toast.LENGTH_SHORT).show();
        startActivity(new Intent (MainActivity.this, LoggingActivity.class));
    }


    //Función que se ejecuta al pulsar el botón de Regístrate! Visto en videotutoría
    public void funcionRegister (View v){
        Toast.makeText(this,getString(R.string.register_toast),Toast.LENGTH_SHORT).show();
        startActivity(new Intent (MainActivity.this, RegisterActivity.class));
    }
}
