package com.example.pac_uf2_fragaadrian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

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

        //Asociación de los objectos con su elemento en la interfaz

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

            }
        });
    }

    //Función para registrar un nuevo usuario en la BBDD SQLite de la app visto en videotutoría

    private void registerUser() {

        //Variable para comprobar que el campo email es un formato válido

        boolean isValidEmail = validEmail(texto_email.getText().toString());

        //Comprobación de que ningún campo queda vacío

        if (texto_nombre.length()==0){
            Toast.makeText(this,getString(R.string.nombre_toast),Toast.LENGTH_SHORT).show();
        }
        if (texto_apellido.length()==0){
            Toast.makeText(this,getString(R.string.apellido_toast),Toast.LENGTH_SHORT).show();
        }
        if (texto_nombre_usuario.length()==0) {
            Toast.makeText(this, getString(R.string.userName_toast), Toast.LENGTH_SHORT).show();
        }
        if (texto_contraseña.length()==0){
            Toast.makeText(this,getString(R.string.contraseña_toast),Toast.LENGTH_SHORT).show();
        }
        if (texto_email.length()==0){
            Toast.makeText(this,getString(R.string.email_toast),Toast.LENGTH_SHORT).show();
        }
        if (!isValidEmail) {
            Toast.makeText(this,getString(R.string.emailValido_toast),Toast.LENGTH_SHORT).show();
        }

        //Si todos los campos están cubiertos se realiza el registro en la bbdd y se cambia de activity

        if(texto_nombre.length()>0 && texto_apellido.length()>0 && texto_nombre_usuario.length()>0 && texto_contraseña.length()>0 && texto_email.length()>0 && isValidEmail) {
            BaseDeDatos bd = new BaseDeDatos(this, "appAndroid", null, 1);
            bd.insertData(texto_nombre.getText().toString(), texto_apellido.getText().toString(), texto_nombre_usuario.getText().toString(), texto_contraseña.getText().toString(), texto_email.getText().toString());
            // bd.getData();
            startActivity(new Intent(RegisterActivity.this, LoggingActivity.class));
        }
    }

    /*
    Método para validar que se introduce un email correcto, información consultada en:
    https://stackoverflow.com/questions/18909746/android-email-validation/18909955
    */

    private boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

}
