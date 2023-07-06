package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {
    @FXML
    public void entrarAnimal() throws IOException {
        HelloApplication.setRoot("animal-view");
    }

    @FXML
    public void sair() throws IOException {

      if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == 2){
            UsuarioSingleton.getUsuarioSingleton().setNivelDeAcesso(0);
          HelloApplication.setRoot("hello-view");
      }
      else {
          OngSingleton.getOngSingleton().getNivelDeAcesso(0);
          HelloApplication.setRoot("hello-view");
      }
    }

    @FXML
    public void entrarOngs() throws IOException{
        HelloApplication.setRoot("ong-view");
    }

    public void entrarUsuarios() throws IOException {
        // Verifica se o usuário tem permissão para acessar a visualização do usuário
        if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == 2) {
            // O usuário tem permissão para acessar a visualização do usuário
            HelloApplication.setRoot("usuario-view");
        } else {
            // O usuário não tem permissão para acessar a visualização do usuário

            // Exibe uma mensagem de erro ou redireciona o usuário para outra visualização
        }
    }

    public void fazerAdocoes() throws IOException{
        HelloApplication.setRoot("adocao-view");
    }
}