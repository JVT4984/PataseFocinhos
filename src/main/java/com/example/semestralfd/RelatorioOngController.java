package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioOngController implements Initializable {
    @FXML
    TableView<Animal> tabelaAnimal;

    @FXML
    TableColumn<Animal, Integer> colunaRelatorioAnimal_id;

    @FXML
    TableColumn<Animal, Integer> colunaRelatorioOng_id;

    @FXML
    TableColumn<Animal, String> colunaRelatorioTipo_animal;

    @FXML
    TableColumn<Animal, String> colunaRelatorioRaca;

    @FXML
    TableColumn<Animal,String> colunaRelatorioSexo_animal;

    @FXML
    TableColumn<Animal, String> colunaRelatorioPorte;

    @FXML
    TableColumn<Animal, Integer> colunaRelatorioIdade;

    @FXML
    TableColumn<Animal, String> colunaRelatorioDescribe;

    @FXML
    TableColumn<Animal, Date> colunaRelatorioDataCadastro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaRelatorioAnimal_id.setCellValueFactory(new PropertyValueFactory<>("animal_id"));
        colunaRelatorioOng_id.setCellValueFactory(new PropertyValueFactory<>("ong_id"));
        colunaRelatorioTipo_animal.setCellValueFactory(new PropertyValueFactory<>("tipo_animal"));
        colunaRelatorioRaca.setCellValueFactory(new PropertyValueFactory<>("raca"));
        colunaRelatorioSexo_animal.setCellValueFactory(new PropertyValueFactory<>("sexo_animal"));
        colunaRelatorioPorte.setCellValueFactory(new PropertyValueFactory<>("porte"));
        colunaRelatorioIdade.setCellValueFactory(new PropertyValueFactory<>("idade_animal"));
        colunaRelatorioDescribe.setCellValueFactory(new PropertyValueFactory<>("describe"));
        colunaRelatorioDataCadastro.setCellValueFactory(new PropertyValueFactory<>("animal_dt_cadastro"));


        RelatorioDAO relatorioDAO = new RelatorioDAO();
        try {
            List<Animal> animais = relatorioDAO.pesquisarAnimaisOrdenadosPorData();
            tabelaAnimal.getItems().addAll(animais);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

