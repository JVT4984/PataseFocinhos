package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AdocaoController implements Initializable {
    @FXML
    TableView<Animal> tabelaAnimal;

    @FXML
    TableColumn<Animal, Integer> colunaAnimal_id;

    @FXML
    TableColumn<Animal, Integer> colunaOng_id;

    @FXML
    TableColumn<Animal, String> colunaTipo_animal;

    @FXML
    TableColumn<Animal, String> colunaRaca;

    @FXML
    TableColumn<Animal, String> colunaSexo_animal;

    @FXML
    TableColumn<Animal, String> colunaPorte;

    @FXML
    TableColumn<Animal, Integer> colunaIdade;

    @FXML
    TableColumn<Animal, String> colunaDescribe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaAnimal_id.setCellValueFactory(new PropertyValueFactory<>("animal_id"));
        colunaOng_id.setCellValueFactory(new PropertyValueFactory<>("ong_id"));
        colunaTipo_animal.setCellValueFactory(new PropertyValueFactory<>("tipo_animal"));
        colunaRaca.setCellValueFactory(new PropertyValueFactory<>("raca"));
        colunaSexo_animal.setCellValueFactory(new PropertyValueFactory<>("sexo_animal"));
        colunaPorte.setCellValueFactory(new PropertyValueFactory<>("porte"));
        colunaIdade.setCellValueFactory(new PropertyValueFactory<>("idade_animal"));
        colunaDescribe.setCellValueFactory(new PropertyValueFactory<>("describe"));

        AnimalDAO animalDAO = new AnimalDAO();
        try {
            List<Animal> animais = animalDAO.getAll();
            tabelaAnimal.getItems().addAll(animais);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void adotar() throws IOException {
        HelloApplication.showModal("adocao-modal-view");
    }

    @FXML
    public void voltar() throws IOException {
        HelloApplication.setRoot("main-view");
    }
}
