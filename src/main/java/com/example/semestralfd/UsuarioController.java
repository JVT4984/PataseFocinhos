package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {
    @FXML
    TableView<Usuario> tabela_Usuario;

    @FXML
    TableColumn<Usuario, Integer> colunaUsuario_id;

    @FXML
    TableColumn<Usuario, String> colunaUsuario_login;

    @FXML
    TableColumn<Usuario, String> colunaUsuario_senha;

    @FXML
    TableColumn<Usuario, String> colunaUsuario_nome;

    @FXML
    TableColumn<Usuario, Integer> colunaUsuario_numero;

    @FXML
    TableColumn<Usuario, String> colunaUsuario_email;
    @FXML
    TableColumn<Usuario, Integer> colunaUsuario_endereco;

    @FXML
    TableColumn<Usuario, Integer> colunaUsuario_nvl_acesso;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        Configura as colunas da tabela da interfdce gráfica
         */
        colunaUsuario_id.setCellValueFactory(new PropertyValueFactory<>("usuario_id"));
        colunaUsuario_login.setCellValueFactory(new PropertyValueFactory<>("usuario_login"));
        colunaUsuario_senha.setCellValueFactory(new PropertyValueFactory<>("usuario_senha"));
        colunaUsuario_nome.setCellValueFactory(new PropertyValueFactory<>("usuario_nome"));
        colunaUsuario_numero.setCellValueFactory(new PropertyValueFactory<>("usuario_numero"));
        colunaUsuario_email.setCellValueFactory(new PropertyValueFactory<>("usuario_email"));
        colunaUsuario_endereco.setCellValueFactory(new PropertyValueFactory<>("usuario_endereco_id"));
        colunaUsuario_nvl_acesso.setCellValueFactory(new PropertyValueFactory<>("usuario_nvl_acesso"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            List<Usuario> usuarios = usuarioDAO.getAll();
            tabela_Usuario.getItems().addAll(usuarios);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

