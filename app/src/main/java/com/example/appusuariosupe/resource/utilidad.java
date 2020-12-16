package com.example.appusuariosupe.resource;

public class utilidad {
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_DNI="dni";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PROFESION="profesion";
    public static final String CAMPO_EMAIL="email";
    public static final String CAMPO_URL="url";
    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+ TABLA_USUARIO +"("+ CAMPO_DNI+" TEXT, "
            +CAMPO_NOMBRE+" TEXT, "+ CAMPO_PROFESION + " TEXT, " + CAMPO_EMAIL +" TEXT, "+ CAMPO_URL + " TEXT" +")";

}
