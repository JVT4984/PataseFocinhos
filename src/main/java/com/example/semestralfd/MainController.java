package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class MainController {
    @FXML
    public void entrarAnimal() throws IOException {
        if (OngSingleton.getOngSingleton().getNivelDeAcesso() == 3) {
            HelloApplication.setRoot("animal-view");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Apenas ongs tem permissão para gerenciar animais");

            alert.showAndWait();
        }
    }

    @FXML
    public void sair() throws IOException {
            UsuarioSingleton.getUsuarioSingleton().setNivelDeAcesso(0);
            OngSingleton.getOngSingleton().setNivelDeAcesso(0);
            HelloApplication.setRoot("hello-view");
    }

    @FXML
    public void entrarOngs() throws IOException {
        if (OngSingleton.getOngSingleton().getNivelDeAcesso() == 3) {
            HelloApplication.setRoot("ong-view");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Você não tem permissão para gerenciar ongs");

            alert.showAndWait();
        }
    }

    public void entrarUsuarios() throws IOException {
        if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == 2) {
            HelloApplication.setRoot("usuario-view");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Você não tem permissão para gerenciar usuarios");

            alert.showAndWait();
        }
    }

    public void fazerAdocoes() throws IOException {
        if (UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso() == 2) {
            HelloApplication.setRoot("adocao-view");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Apenas usuarios podem fazer adoções");

            alert.showAndWait();
        }
    }

    public void verAdocoes() throws IOException {
        HelloApplication.showModal("ver-adocao-view");
    }

    public void verUsuario() throws IOException {
        HelloApplication.showModal("ver-usuarios-view");
    }

    public void verOng() throws IOException {
        HelloApplication.showModal("ver-ongs-view");
    }

    public void relatorioUsuario() throws IOException {
        HelloApplication.showModal("relatorio-usuarios-view");
    }

    public void relatorioOng() throws IOException {
        HelloApplication.showModal("relatorio-ong-view");
    }

    public void relatorioAdocao() throws IOException {
        HelloApplication.showModal("relatorio-adocao-view");
    }
}