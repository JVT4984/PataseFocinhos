package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class VerUsuariosController implements Initializable {
    @FXML
    TableView<Usuario> tabela_VerUsuario;

    @FXML
    TableColumn<Usuario, Integer> colunaVerUsuario_id;

    @FXML
    TableColumn<Usuario, String> colunaVerUsuario_nome;

    @FXML
    TableColumn<Usuario, String> colunaVerUsuario_numero;

    @FXML
    TableColumn<Usuario, String> colunaVerUsuario_email;

    @FXML
    TableColumn<Usuario, Integer> colunaVerUsuario_endereco;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaVerUsuario_id.setCellValueFactory(new PropertyValueFactory<>("usuario_id"));
        colunaVerUsuario_nome.setCellValueFactory(new PropertyValueFactory<>("usuario_nome"));
        colunaVerUsuario_numero.setCellValueFactory(new PropertyValueFactory<>("usuario_numero"));
        colunaVerUsuario_email.setCellValueFactory(new PropertyValueFactory<>("usuario_email"));
        colunaVerUsuario_endereco.setCellValueFactory(new PropertyValueFactory<>("usuario_endereco_id"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            List<Usuario> usuarios = usuarioDAO.getAll();
            tabela_VerUsuario.getItems().addAll(usuarios);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

