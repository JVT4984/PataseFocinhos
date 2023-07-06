package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    TextField usuarioFild;

    @FXML
    PasswordField senhaFild;

    @FXML
    Label lableEntrar;

    @FXML
    public void entrar() throws IOException, SQLException {
        Usuario usuarioLogin = new Usuario();
        usuarioLogin.usuario_login = usuarioFild.getText();
        usuarioLogin.usuario_senha = senhaFild.getText();
        usuarioLogin.usuario_nvl_acesso = 2;
        boolean usuarioExiste = new UsuarioDAO().existe(usuarioLogin);

        if (usuarioExiste) {
            // Usuário existe
            System.out.println("Entrando...");
            lableEntrar.setText("Entrando...");
            System.out.println(usuarioLogin.usuario_nvl_acesso);
            // Define o nível de acesso do usuário no singleton
            UsuarioSingleton.getUsuarioSingleton().setNivelDeAcesso(usuarioLogin.usuario_nvl_acesso);
            HelloApplication.setRoot("main-view");

        } else {
            Ong ongLogin = new Ong();
            ongLogin.ong_login = usuarioFild.getText();
            ongLogin.ong_senha = senhaFild.getText();
            ongLogin.ong_nvl_acesso = 3;
            boolean ong_existe = new OngDAO().ong_existe(ongLogin);

            if (ong_existe) {
                // Usuário existe
                System.out.println("Entrando...");
                lableEntrar.setText("Entrando...");
                // Define o nível de acesso da ONG no singleton
                OngSingleton.getOngSingleton().setNivelDeAcesso(ongLogin.ong_nvl_acesso);
                HelloApplication.setRoot("main-view");

            } else {
                // Usuário não existe
                System.out.println("Usuário ou Senha Incorreto!");
                lableEntrar.setText("Usuário ou Senha Incorreto!");
            }
        }
    }

    public void cadastrarUsuario() throws IOException {
        HelloApplication.showModal("cadastro-usuario-view");
    }

    public void cadastrarOng() throws IOException {
        HelloApplication.showModal("cadastro-ong-view");
    }
}

