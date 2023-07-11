package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class VerOngsController implements Initializable {

    @FXML
    TableView<Ong> tabelaOng;
    @FXML
    TableColumn<Ong, Integer> colunaOng_id;
    @FXML
    TableColumn<Ong, Integer> colunaOng_endereco;
    @FXML
    TableColumn<Ong, String> colunaOng_nome;
    @FXML
    TableColumn<Ong, String> colunaOng_telefone;
    @FXML
    TableColumn<Ong, String> colunaOng_email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colunaOng_id.setCellValueFactory(new PropertyValueFactory<>("ong_id"));
        colunaOng_endereco.setCellValueFactory(new PropertyValueFactory<>("ong_endereco_id"));
        colunaOng_nome.setCellValueFactory(new PropertyValueFactory<>("ong_nome"));
        colunaOng_telefone.setCellValueFactory(new PropertyValueFactory<>("ong_telefone"));
        colunaOng_email.setCellValueFactory(new PropertyValueFactory<>("ong_email"));

        OngDAO ongDAO = new OngDAO();
        try {
            List<Ong> ongs = ongDAO.getAll();
            tabelaOng.getItems().addAll(ongs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
