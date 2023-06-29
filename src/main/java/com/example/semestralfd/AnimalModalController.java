package com.example.semestralfd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class AnimalModalController implements Initializable {

    @FXML
    TextField animal_idFild;

    @FXML
    TextField ong_idFild;

    @FXML
    TextField tipo_animalFild;

    @FXML
    TextField racaFild;

    @FXML
    TextField sexo_animalFild;

    @FXML
    TextField porteFild;

    @FXML
    TextField idadeFild;

    @FXML
    TextField descriçaoFild;

    public static Animal animal;

    @FXML
    public void salvar() {
        Animal novoAnimal = new Animal();
        if (!animal_idFild.getText().isBlank()){
            novoAnimal.animal_id = Integer.parseInt(animal_idFild.getText());
        }
        novoAnimal.ong_id = Integer.parseInt(ong_idFild.getText());
        novoAnimal.tipo_animal = tipo_animalFild.getText();
        novoAnimal.raca_animal = racaFild.getText();
        novoAnimal.sexo_animal = sexo_animalFild.getText();
        novoAnimal.porte = porteFild.getText();
        novoAnimal.idade_animal = Integer.parseInt(idadeFild.getText());
        novoAnimal.describe = descriçaoFild.getText();

        animal = novoAnimal;

        HelloApplication.closeCurrentWindow();
    }

    @FXML
    public void cancelar() {

        HelloApplication.closeCurrentWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Animal animalSelecionado = AnimalModalController.animal;

        if (animalSelecionado != null) {
            animal_idFild.setText(Integer.toString(animalSelecionado.animal_id));
            ong_idFild.setText(Integer.toString(animalSelecionado.ong_id));
            tipo_animalFild.setText(animalSelecionado.tipo__animal);
            racaFild.setText(animalSelecionado.raca_animal);
            sexo_animalFild.setText(animalSelecionado.sexo_animal);
            porteFild.setText(animalSelecionado.porte);
            idadeFild.setText(Integer.toString(animalSelecionado.idade_animal));
            descriçaoFild.setText(animalSelecionado.describe);
        }
    }
}
