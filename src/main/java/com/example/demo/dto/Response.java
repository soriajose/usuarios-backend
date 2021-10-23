package com.example.demo.dto;

import java.util.Objects;

public class Response {

    private int estado;
    private String mensaje;
    private Object data;

    public Response(){
        this.estado = 0;
        this.mensaje = "";
    }

    public int getEstado(){
        return estado;
    }

    public void setEstado(int estado){
        this.estado = estado;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(){
        this.mensaje = mensaje;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return estado == response.estado &&
                Objects.equals(mensaje, response.mensaje) &&
                Objects.equals(data, response.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado, mensaje, data);
    }
}
