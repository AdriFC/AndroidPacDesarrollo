package com.example.pac_uf2_fragaadrian;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRegister = findViewById(R.id.register_button);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionRegister (v);
            }
        });
    }
    public void funcionRegister (View v){
        Toast.makeText(this,getString(R.string.register_toast),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (MainActivity.this, RegisterActivity.class);
        startActivity(intent);

    }
}
