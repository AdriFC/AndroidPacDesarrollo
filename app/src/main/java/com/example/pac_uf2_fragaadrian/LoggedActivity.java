package com.example.pac_uf2_fragaadrian;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoggedActivity extends AppCompatActivity {

    //Atributos

    Button play_button;
    Button stop_button;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        play_button = findViewById(R.id.play_buttom);                   //Asocio el objecto botón de play con el botón del layout
        play_button.setOnClickListener(new View.OnClickListener() {     //Asocio la función play al listener del botón
            @Override
            public void onClick(View v) {
                funcionPlay (v);
            }
        });

        stop_button = findViewById(R.id.stop_button);                   //Asocio el objecto botón de stop con el botón del layout
        stop_button.setOnClickListener(new View.OnClickListener() {     //Asocio la función stop al listener del botón
            @Override
            public void onClick(View v) {
                funcionStop (v);
            }
        });
    }

    //Definición de la función Play para reproducir la música, consultado en la API de Android

    private void funcionPlay (View v){
        mediaPlayer = MediaPlayer.create(this, R.raw.adrifc);
        mediaPlayer.start();
    }

    //Definición de la función Stop para detener la música, consultado en la API de Android

    private void funcionStop (View v){
        mediaPlayer.stop();
    }
}
