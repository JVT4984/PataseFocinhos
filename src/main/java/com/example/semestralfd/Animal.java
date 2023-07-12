package com.example.semestralfd;

import java.util.Date;

public class Animal {

    public int animal_id;
    public int ong_id;
    public String tipo_animal;
    public String raca_animal;
    public String sexo_animal;
    public String porte;
    public int idade_animal;
    public String describe;
    public Date animal_dt_cadastro;

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public int getOng_id() {
        return ong_id;
    }

    public void setOng_id(int ong_id) {
        this.ong_id = ong_id;
    }

    public String getTipo_animal() {
        return tipo_animal;
    }

    public void setTipo_animal(String tipo_animal) {
        this.tipo_animal = tipo_animal;
    }

    public String getRaca() {
        return raca_animal;
    }

    public void setRaca(String raca) {
        this.raca_animal = raca;
    }

    public String getSexo_animal() {
        return sexo_animal;
    }

    public void setSexo_animal(String sexo_animal) {
        this.sexo_animal = sexo_animal;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public int getIdade_animal() {
        return idade_animal;
    }

    public void setIdade_animal(int idade_animal) {
        this.idade_animal = idade_animal;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getAnimal_dt_cadastro() {
        return animal_dt_cadastro;
    }

    public void setAnimal_dt_cadastro(Date animal_dt_cadastro) {
        this.animal_dt_cadastro = animal_dt_cadastro;
    }
}
