package com.example.semestralfd;

import java.util.Date;

public class Usuario {

    public  int usuario_id;
    public  String usuario_login;
    public  String usuario_senha;
    public String usuario_nome;
    public String  usuario_numero;
    public String usuario_email;
    public int usuario_endereco_id;
    public int usuario_nvl_acesso;
    public Date usuario_dt_cadastro;

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_login() {return usuario_login;}

    public void setUsuario_login(String usuario_login) {
        this.usuario_login = usuario_login;
    }

    public String getUsuario_senha() {
        return usuario_senha;
    }

    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public String getUsuario_numero() {
        return usuario_numero;
    }

    public void setUsuario_numero(String usuario_numero) {
        this.usuario_numero = usuario_numero;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public int getUsuario_endereco_id(){ return usuario_endereco_id; }

    public void  setUsuario_endereco_id(int usuario_endereco_id) {this.usuario_endereco_id = usuario_endereco_id;}

    public int getUsuario_nvl_acesso() {
        return usuario_nvl_acesso;
    }

    public void setUsuario_nvl_acesso(int usuario_nvl_acesso) {this.usuario_nvl_acesso = usuario_nvl_acesso;}

    public Date getUsuario_dt_cadastro() {return usuario_dt_cadastro;}

    public void setUsuario_dt_cadastro(Date usuario_dt_cadastro) {this.usuario_dt_cadastro = usuario_dt_cadastro;}

}
