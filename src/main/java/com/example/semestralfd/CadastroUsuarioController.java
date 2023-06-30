package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroUsuarioController {

    @FXML
    TextField usuario_idFild;
    @FXML
    TextField usuario_loginFild;
    @FXML
    TextField usuario_senhaFild;
    @FXML
    TextField usuario_nomeFild;
    @FXML
    TextField usuario_numeroFild;
    @FXML
    TextField usuario_emailFild;
    @FXML
    TextField usuario_enderecoFild;

    public static Usuario usuario;

    @FXML
    public void salvar() throws IOException, SQLException {
        Usuario novoUsuario = new Usuario();
        if (!usuario_idFild.getText().isBlank()){
            novoUsuario.usuario_id = Integer.parseInt(usuario_idFild.getText());
        }
        novoUsuario.usuario_login = usuario_loginFild.getText();
        novoUsuario.usuario_senha = usuario_senhaFild.getText();
        novoUsuario.usuario_nome = usuario_nomeFild.getText();
        novoUsuario.usuario_numero = Integer.parseInt(usuario_numeroFild.getText());
        novoUsuario.usuario_email = usuario_emailFild.getText();
        novoUsuario.usuario_endereco_id = Integer.parseInt(usuario_enderecoFild.getText());

        usuario = novoUsuario;

        new UsuarioDAO().insertUsuario(novoUsuario);

        HelloApplication.setRoot("hello-view");
    }


    @FXML
    public void cancelar() throws IOException {

        HelloApplication.setRoot("hello-view");
    }
}
