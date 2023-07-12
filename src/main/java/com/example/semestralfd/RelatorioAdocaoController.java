package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioAdocaoController implements Initializable {
    @FXML
    TableView tabelaAdocao;
    @FXML
    TableColumn colunaAdocao_id;
    @FXML
    TableColumn colunaAdocao_ongid;
    @FXML
    TableColumn colunaAdocao_usuarioid;
    @FXML
    TableColumn colunaAdocao_animalid;
    @FXML
    TableColumn colunaAdocao_dt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        Configura as colunas da tabela da interfdce gráfica
         */
        colunaAdocao_id.setCellValueFactory(new PropertyValueFactory<>("adocao_id"));
        colunaAdocao_ongid.setCellValueFactory(new PropertyValueFactory<>("usuario_usuario_id"));
        colunaAdocao_usuarioid.setCellValueFactory(new PropertyValueFactory<>("ong_ong_id"));
        colunaAdocao_animalid.setCellValueFactory(new PropertyValueFactory<>("animal_animal_id"));
        colunaAdocao_dt.setCellValueFactory(new PropertyValueFactory<>("data_adocao"));

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        try {
            List<Adocao> adocoes = relatorioDAO.pesquisarAdocoesOrdenadosPorData();
            tabelaAdocao.getItems().addAll(adocoes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
