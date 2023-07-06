package com.example.semestralfd;

public class OngSingleton {

    private static OngSingleton ongSingleton;
    private int nivelDeAcesso;

    public static OngSingleton getOngSingleton() {
        if (ongSingleton == null) {
            ongSingleton = new OngSingleton();
        }
        return ongSingleton;
    }

    public void setNivelDeAcesso(int nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public int getNivelDeAcesso(int i) {
        return nivelDeAcesso;
    }
}
