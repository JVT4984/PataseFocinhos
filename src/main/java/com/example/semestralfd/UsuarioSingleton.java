package com.example.semestralfd;

import java.util.Date;

public class UsuarioSingleton {

    private static UsuarioSingleton usuarioSingleton;
    private int nivelDeAcesso;
    private   int usuario_id;
    private String usuario_nome;
    private String  usuario_numero;
    private String usuario_email;
    private int usuario_endereco_id;
    private Date usuario_dt_cadastro;



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

    public String getUsuario_nome() {return usuario_nome;}

    public void setUsuario_nome(String usuario_nome) {this.usuario_nome = usuario_nome;}

    public String getUsuario_numero() {return usuario_numero;}

    public void setUsuario_numero(String usuario_numero) {this.usuario_numero = usuario_numero;}

    public String getUsuario_email() {return usuario_email;}

    public void setUsuario_email(String usuario_email) {this.usuario_email = usuario_email;}

    public int getUsuario_endereco_id() {return usuario_endereco_id;}

    public void setUsuario_endereco_id(int usuario_endereco_id) {this.usuario_endereco_id = usuario_endereco_id;}

    public Date getUsuario_dt_cadastro() {return usuario_dt_cadastro;}

    public void setUsuario_dt_cadastro(Date usuario_dt_cadastro) {this.usuario_dt_cadastro = usuario_dt_cadastro;}

}