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
    TableView<Adocao> tabelaAdocao;

    @FXML
    TableColumn<Adocao, Integer> colunaAdocao_id;

    @FXML
    TableColumn<Adocao, Integer> colunaUsuarioid;

    @FXML
    TableColumn<Adocao, Integer> colunaOng_id;

    @FXML
    TableColumn<Adocao, Integer> colunaAnimal_id;

    @FXML
    TableColumn<Adocao,Date> colunaData_adocao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaAdocao_id.setCellValueFactory(new PropertyValueFactory<>("adocao_id"));
        colunaUsuarioid.setCellValueFactory(new PropertyValueFactory<>("usuario_usuario_id"));
        colunaOng_id.setCellValueFactory(new PropertyValueFactory<>("ong_ong_id"));
        colunaAnimal_id.setCellValueFactory(new PropertyValueFactory<>("animal_animal_id"));
        colunaData_adocao.setCellValueFactory(new PropertyValueFactory<>("data_adocao"));

        AdocaoDAO adocaoDAO = new AdocaoDAO();
        try {
            List<Adocao> adocaos = adocaoDAO.getAdocoes();
            tabelaAdocao.getItems().addAll(adocaos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void adotar() throws IOException {
        HelloApplication.showModal("adocao-modal-view");
    }

    @FXML
    public void voltar() throws  IOException {
        HelloApplication.setRoot("main-view");
    }
}
