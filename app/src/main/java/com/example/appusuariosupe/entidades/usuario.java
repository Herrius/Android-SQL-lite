package com.example.appusuariosupe.entidades;

public class usuario {
    public String dni;
    public String nombre;
    public String profesion;
    public String email;
    public String url;
    public usuario(){
        this.dni="123456789";
        this.nombre="enrique";
        this.profesion="profesion";
        this.email="asd@hotmail.com";
        this.url="https://w.wallhaven.cc/full/39/wallhaven-39dmkd.jpg";
    }
    public usuario(String dni, String nombre, String profresion, String email,String url) {
        this.dni = dni;
        this.nombre = nombre;
        this.profesion = profresion;
        this.email = email;
        this.url=url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

