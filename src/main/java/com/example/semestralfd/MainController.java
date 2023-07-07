package com.example.semestralfd;

import javafx.fxml.FXML;
import java.io.IOException;

public class MainController {
    @FXML
    public void entrarAnimal() throws IOException {
        HelloApplication.setRoot("animal-view");
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
        HelloApplication.setRoot("ong-view");
    }

    public void entrarUsuarios() throws IOException {
        // Verifica se o usuário tem permissão para acessar a visualização do usuário
        if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == 2) {
            HelloApplication.setRoot("usuario-view");
        } else {
            System.out.printf("Vc Não tem permissão");
        }
    }

    public void fazerAdocoes() throws IOException {
        HelloApplication.setRoot("adocao-view");
    }
}