package com.example.semestralfd;

import java.util.Date;

public class Adocao {

    public int adocao_id;
    public int adocao_usuario_id;
    public int adocao_ong_id;
    public int adocao_animal_id;
    public Date data_adocao;

    public int getAdocao_id() {
        return adocao_id;
    }

    public void setAdocao_id(int adocao_id) {
        this.adocao_id = adocao_id;
    }

    public int getAdocao_usuario_id() {
        return adocao_usuario_id;
    }

    public void setAdocao_usuario_id(int adocao_usuario_id) {
        this.adocao_usuario_id = adocao_usuario_id;
    }

    public int getAdocao_ong_id() {
        return adocao_ong_id;
    }

    public void setAdocao_ong_id(int adocao_ong_id) {
        this.adocao_ong_id = adocao_ong_id;
    }

    public int getAdocao_animal_id() {
        return adocao_animal_id;
    }

    public void setAdocao_animal_id(int adocao_animal_id) {
        this.adocao_animal_id = adocao_animal_id;
    }

    public Date getData_adocao() {
        return data_adocao;
    }

    public void setData_adocao(Date data_adocao) {
        this.data_adocao = data_adocao;
    }
}