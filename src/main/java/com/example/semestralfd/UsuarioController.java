package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class UsuarioController {
    @FXML
    TableView<Usuario> tabelaUsuario;

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

    @FXML
    TableColumn<Usuario, Date> colunaUsuario_dtcadastro;

    @FXML
    public void novoUsuario() throws IOException, SQLException {
        CadastroUsuarioController.usuario = null;

        HelloApplication.showModal("cadastro-usuario-view");

        // O modal foi fechado
        Usuario novoUsuario = CadastroUsuarioController.usuario;

        if(novoUsuario != null)
            tabelaUsuario.getItems().add(novoUsuario);

        UsuarioDAO usuario = new UsuarioDAO();
        usuario.insertUsuario(novoUsuario);
    }
}
