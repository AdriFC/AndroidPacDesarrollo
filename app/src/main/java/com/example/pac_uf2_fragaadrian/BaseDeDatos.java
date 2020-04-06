package com.example.pac_uf2_fragaadrian;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// Clase para la conexión con la bbdd SQLite

public class BaseDeDatos extends SQLiteOpenHelper {

    //Constructor obligatorio que coincide con el de su clase superior
    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Método para crear, al extender de una clase abstracta es de obligada implementación por el usuario.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE usuarios (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " + "apellido TEXT, " + "nombreUsuario TEXT, " + "contraseña TEXT, " + "email TEXT);";
    }

    //Método para actualizar, al extender de una clase abstracta es de obligada implementación por el usuario.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //Función para insertar datos en la BBDD
    public void insertData (String nombre, String apellido, String nombreUsuario, String contraseña, String email){
        SQLiteDatabase escritura = getWritableDatabase();
        String insert = "INSERT INTO usuarios (nombre, apellido, nombreUsuario, contraseña, email) " +
                "VALUES (\""+ nombre +" \" , \" "+ apellido + " \" , \" "+ nombreUsuario + " \" , \" "+ contraseña + " \" , \" "+ email + "\" );";
        escritura.execSQL(insert);
        escritura.close();
    }

    //Función para recuperar datos de la BBDD
    public void getData (){
        SQLiteDatabase lectura = getReadableDatabase();
        String query = "SELECT * FROM usuarios";
        Cursor cursor = lectura.rawQuery (query, null);
        cursor.moveToFirst();
        do{
            System.out.println("Nombre del usuario: " + cursor.getString(1));
        } while (cursor.moveToNext());
        lectura.close();
    }
}
