package com.example.pac_uf2_fragaadrian;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Clase para la conexión con la bbdd SQLite

public class BaseDeDatos extends SQLiteOpenHelper {

    //Constructor obligatorio que coincide con el de su clase superior
    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Método para crear la bbdd, al extender de una clase abstracta es de obligada implementación por el usuario.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE  usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nombre TEXT," +
                        "apellido TEXT, " +
                        "nombreUsuario TEXT, " +
                        "contraseña TEXT, " +
                        "email TEXT);";

        db.execSQL(createTable);
    }

    //Método para actualizar, al extender de una clase abstracta es de obligada implementación por el usuario.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //Función para insertar datos en la BBDD
    public void insertData (String nombre, String apellido, String nombreUsuario, String contraseña, String email){
        SQLiteDatabase escritura = getWritableDatabase();
        String insert = "INSERT INTO usuarios (nombre, apellido, nombreUsuario, contraseña, email) " +
                "VALUES (\""+ nombre +" \" , \""+ apellido + " \" , \""+ nombreUsuario + " \" , \""+ contraseña + " \" , \""+ email + "\" );";
        escritura.execSQL(insert);
        escritura.close();
    }

    //Función para recuperar datos de la BBDD
    public void getData (){
        SQLiteDatabase lectura = getReadableDatabase();
        String query = "SELECT * FROM usuarios";
        Cursor cursor = lectura.rawQuery (query, null);
        cursor.moveToFirst();
        List<Usuario> usuarios = new ArrayList<>();

        do{
            usuarios.add(new Usuario(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
        } while (cursor.moveToNext());
        Iterator iterator = usuarios.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        lectura.close();
    }
}
