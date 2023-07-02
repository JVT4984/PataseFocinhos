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
        HelloApplication.setRoot("hello-view");
    }

    @FXML
    public void entrarOngs() throws IOException{
        HelloApplication.setRoot("ong-view");
    }

    public void entrarUsuarios() throws IOException{
        HelloApplication.setRoot("usuario-view");
    }
}