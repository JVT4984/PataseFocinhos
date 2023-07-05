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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class OngController implements Initializable {

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

    @FXML
    public void excluir() throws SQLException {

        //Obter o produto selecionada
        Ong ongSelecionada = tabelaOng.getSelectionModel().getSelectedItem();

        //Confirmação de exclusão
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Você realmente deseja exluir a sua conta" + ongSelecionada.ong_nome);
        alert.setHeaderText(null);
        alert.setContentText("Deseja excluir a conta?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){

            OngDAO delete = new OngDAO();
            delete.delete(ongSelecionada);
            // Excluir o produto
            tabelaOng.getItems().remove(ongSelecionada);
        }
    }

    @FXML
    public void editar() throws IOException, SQLException {
        Ong ongSelecionada = tabelaOng.getSelectionModel().getSelectedItem();

        OngModalController.ong = ongSelecionada;

        HelloApplication.showModal("ong-modal-view");

        // O modal foi fechado

        Ong ongEditada = OngModalController.ong;

        ongSelecionada.ong_id = ongEditada.ong_id;
        ongSelecionada.ong_login = ongEditada.ong_login;
        ongSelecionada.ong_senha = ongEditada.ong_senha;
        ongSelecionada.ong_nome = ongEditada.ong_nome;
        ongSelecionada.ong_email = ongEditada.ong_email;
        ongSelecionada.ong_telefone= ongEditada.ong_telefone;
        ongSelecionada.ong_endereco_id= ongEditada.ong_endereco_id;

        tabelaOng.refresh();
        new OngDAO().update(ongEditada);
    }

    @FXML
    public void voltar() throws IOException {
        HelloApplication.setRoot("main-view");
    }
}


