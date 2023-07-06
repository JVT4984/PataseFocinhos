package com.example.semestralfd;

public class UsuarioSingleton {

    private static UsuarioSingleton usuarioSingleton;
    private int nivelDeAcesso;

    public int usuario_id;

    public static UsuarioSingleton getUsuarioSingleton() {
        if (usuarioSingleton == null) {
            usuarioSingleton = new UsuarioSingleton();
        }
        return usuarioSingleton;
    }

    public void setNivelDeAcesso(int nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public int getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public int getUsuario_id() {return usuario_id;}

    public void setUsuario_id(int usuario_id) {this.usuario_id = usuario_id;}
}