package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AnimalController implements Initializable {

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
    TableColumn<Animal,String> colunaSexo_animal;

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
    public void novo() throws IOException, SQLException {
        AnimalModalController.animal = null;

        HelloApplication.showModal("animal-modal-view");

        // O modal foi fechado
        Animal novoAnimal = AnimalModalController.animal;

        if(novoAnimal != null)
            tabelaAnimal.getItems().add(novoAnimal);

        AnimalDAO animal = new AnimalDAO();
        animal.insert(novoAnimal);
    }

    @FXML
    public void excluir() throws SQLException {

        //Obter o aniaml selecionada
        Animal animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();

        //Confirmação de exclusão
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Excluir produto");
        alert.setHeaderText("Código do animal: " + animalSelecionado.animal_id + ", Ong: " + animalSelecionado.ong_id + ", Raça: " + animalSelecionado.raca_animal);
        alert.setContentText("Deseja excluir o animal?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){

            AnimalDAO delete = new AnimalDAO();
            delete.delete(animalSelecionado);
            // Excluir o animal
            tabelaAnimal.getItems().remove(animalSelecionado);
        }
    }

    @FXML
    public void editar() throws IOException, SQLException {
        Animal animalSelecionado = tabelaAnimal.getSelectionModel().getSelectedItem();

        AnimalModalController.animal = animalSelecionado;

        HelloApplication.showModal("animal-modal-view");

        // O modal foi fechado

        Animal animalEditado = AnimalModalController.animal;

        animalSelecionado.animal_id = animalEditado.animal_id;
        animalSelecionado.ong_id = animalEditado.ong_id;
        animalSelecionado.raca_animal = animalEditado.raca_animal;
        animalSelecionado.porte = animalEditado.porte;
        animalSelecionado.idade_animal = animalEditado.idade_animal;
        animalSelecionado.describe = animalEditado.describe;

        tabelaAnimal.refresh();
        new AnimalDAO().update(animalEditado);
    }

    @FXML
    public void voltar() throws IOException {
        HelloApplication.setRoot("main-view");
    }
}

