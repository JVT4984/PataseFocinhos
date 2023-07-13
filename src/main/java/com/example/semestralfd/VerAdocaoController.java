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

public class VerAdocaoController implements Initializable {
    @FXML
    TableView<Adocao> tabelaAdocao;
    @FXML
    TableColumn<Adocao, Integer> ColunaAdocao_id;
    @FXML
    TableColumn<Adocao, Integer> ColunaAdocao_usuario_id;
    @FXML
    TableColumn<Adocao, Integer> ColunaAdocao_ong_id;
    @FXML
    TableColumn<Adocao, Integer> ColunaAdocao_animal_id;
    @FXML
    TableColumn<Adocao, Date> Coluna_Dt_adocao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ColunaAdocao_id.setCellValueFactory(new PropertyValueFactory<>("adocao_id"));
        ColunaAdocao_usuario_id.setCellValueFactory(new PropertyValueFactory<>("adocao_usuario_id"));
        ColunaAdocao_ong_id.setCellValueFactory(new PropertyValueFactory<>("adocao_ong_id"));
        ColunaAdocao_animal_id.setCellValueFactory(new PropertyValueFactory<>("adocao_animal_id"));
        Coluna_Dt_adocao.setCellValueFactory(new PropertyValueFactory<>("data_adocao"));

        AdocaoDAO adocaoDAO = new AdocaoDAO();
        try {
            List<Adocao> adocoes = adocaoDAO.getAdocoes();
            tabelaAdocao.getItems().addAll(adocoes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void voltar() throws IOException {
        HelloApplication.closeCurrentWindow();
    }
}
