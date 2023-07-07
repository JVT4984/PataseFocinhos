package com.example.semestralfd;

import java.util.Date;

public class OngSingleton {

    private static OngSingleton ongSingleton;
    private int nivelDeAcesso;
    private int ong_id;
    private String ong_nome;
    private String ong_telefone;
    private String ong_email;
    private int ong_endereco_id;


    public static OngSingleton getOngSingleton() {
        if (ongSingleton == null) {
            ongSingleton = new OngSingleton();
        }
        return ongSingleton;
    }

    public int getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(int nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public int getOng_id() {
        return ong_id;
    }

    public void setOng_id(int ong_id) {
        this.ong_id = ong_id;
    }

    public String getOng_nome() {
        return ong_nome;
    }

    public void setOng_nome(String ong_nome) {
        this.ong_nome = ong_nome;
    }

    public String getOng_telefone() {
        return ong_telefone;
    }

    public void setOng_telefone(String ong_telefone) {
        this.ong_telefone = ong_telefone;
    }

    public String getOng_email() {
        return ong_email;
    }

    public void setOng_email(String ong_email) {
        this.ong_email = ong_email;
    }

    public int getOng_endereco_id() {
        return ong_endereco_id;
    }

    public void setOng_endereco_id(int ong_endereco_id) {
        this.ong_endereco_id = ong_endereco_id;
    }

}
