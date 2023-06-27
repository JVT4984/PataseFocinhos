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
}