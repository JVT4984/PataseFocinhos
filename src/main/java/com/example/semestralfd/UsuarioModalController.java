package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UsuarioModalController implements Initializable {

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
        novoUsuario.usuario_numero = usuario_numeroFild.getText();
        novoUsuario.usuario_email = usuario_emailFild.getText();
        novoUsuario.usuario_endereco_id = Integer.parseInt(usuario_enderecoFild.getText());

        usuario = novoUsuario;

        new UsuarioDAO().insertUsuario(novoUsuario);

        HelloApplication.closeCurrentWindow();
    }


    @FXML
    public void cancelar() throws IOException {

        HelloApplication.closeCurrentWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario usuarioSelecionado = UsuarioModalController.usuario;

        if (usuarioSelecionado != null) {
            usuario_idFild.setText(Integer.toString(usuarioSelecionado.usuario_id));
            usuario_loginFild.setText((usuarioSelecionado.usuario_login));
            usuario_senhaFild.setText(usuarioSelecionado.usuario_senha);
            usuario_nomeFild.setText(usuarioSelecionado.usuario_nome);
            usuario_numeroFild.setText(usuarioSelecionado.usuario_numero);
            usuario_emailFild.setText(usuarioSelecionado.usuario_email);
            usuario_enderecoFild.setText(Integer.toString(usuarioSelecionado.usuario_endereco_id));
        }
    }
}


