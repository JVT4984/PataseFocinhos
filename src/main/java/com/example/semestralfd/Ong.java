package com.example.semestralfd;

import java.util.Date;

public class Ong {

    public int ong_id;

    public String ong_login;

    public String ong_senha;

    public String ong_nome;

    public String ong_telefone;

    public String ong_email;

    public int ong_endereco_id;

    public int ong_nvl_acesso;

    public Date ong_dt_cadastro;


    public int getOng_id() {
        return ong_id;
    }

    public void setOng_id(int ong_id) {
        this.ong_id = ong_id;
    }

    public String getOng_login() {
        return ong_login;
    }
    public void setOng_login(String ong_login) {
        this.ong_login = ong_login;
    }
    public String getOng_senha() {
        return ong_senha;
    }
    public void setOng_senha(String ong_senha) {
        this.ong_senha = ong_senha;
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
    public int getOng_nvl_acesso() {
        return ong_nvl_acesso;
    }
    public void setOng_nvl_acesso(int ong_nvl_acesso) {
        this.ong_nvl_acesso = ong_nvl_acesso;
    }
    public Date getOng_dt_cadastro() {return ong_dt_cadastro;}
    public void setOng_dt_cadastro(Date ong_dt_cadastro) {this.ong_dt_cadastro = ong_dt_cadastro;}
}
