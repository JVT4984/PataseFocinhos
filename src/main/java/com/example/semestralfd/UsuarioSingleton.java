package com.example.semestralfd;

public class UsuarioSingleton {

    private static UsuarioSingleton usuarioSingleton;
    private int nivelDeAcesso;

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
}