package com.example.semestralfd;

import javafx.fxml.FXML;
import java.io.IOException;

public class MainController {
    @FXML
    public void entrarAnimal() throws IOException {
        if (OngSingleton.getOngSingleton().getNivelDeAcesso() == 3){
            HelloApplication.setRoot("animal-view");
        }
        else {
            System.out.println("Vc não tem permição");
        }
    }

    @FXML
    public void sair() throws IOException {
        if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == UsuarioSingleton.getUsuarioSingleton().getUsuario_id()) {
            UsuarioSingleton.getUsuarioSingleton().setNivelDeAcesso(0);
            HelloApplication.setRoot("hello-view");
        } else {
            OngSingleton.getOngSingleton().setNivelDeAcesso(0);
            HelloApplication.setRoot("hello-view");
        }
    }

    @FXML
    public void entrarOngs() throws IOException {
        if (OngSingleton.getOngSingleton().getNivelDeAcesso() == 3){
            HelloApplication.setRoot("ong-view");
        }else {
            System.out.println("vc não tem permissão");
        }
    }

    public void entrarUsuarios() throws IOException {
        if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == 2) {
            HelloApplication.setRoot("usuario-view");
        } else {
            System.out.printf("Vc Não tem permissão");
        }
    }

    public void fazerAdocoes() throws IOException {
        if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == 2){
            HelloApplication.setRoot("adocao-view");
        }else {
            System.out.println("Vc não tem permissão");
        }
    }
}