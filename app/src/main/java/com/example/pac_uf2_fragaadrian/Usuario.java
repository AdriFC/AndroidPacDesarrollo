package com.example.pac_uf2_fragaadrian;

import java.io.Serializable;

// Clase para la gestión de usuarios de la BBDD
// Implementa la clase serializable para poder enviarse con el putExtra entre Activities (visto en
// https://stackoverflow.com/questions/2736389/how-to-pass-an-object-from-one-activity-to-another-on-android )
public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contraseña;
    private String email;

    //Constructor de la clase
    public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contraseña, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.email = email;
    }

    //Getters & Setters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
