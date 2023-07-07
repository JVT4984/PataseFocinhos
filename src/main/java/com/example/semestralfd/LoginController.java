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
        //usuarioLogin.usuario_id = Us
        boolean usuarioExiste = new UsuarioDAO().existe(usuarioLogin);

        if (usuarioExiste) {
            // Usuário existe
            Usuario usuarioLogado = UsuarioDAO.getUsuario(usuarioLogin);

            // Define o nível de acesso do usuário no singleton
            UsuarioSingleton.getUsuarioSingleton().setNivelDeAcesso(usuarioLogado.usuario_nvl_acesso);
            // Armazena as informações do usuário no singleton
            UsuarioSingleton.getUsuarioSingleton().setUsuario_id(usuarioLogado.usuario_id);
            UsuarioSingleton.getUsuarioSingleton().setUsuario_nome(usuarioLogado.usuario_nome);
            UsuarioSingleton.getUsuarioSingleton().setUsuario_numero(usuarioLogado.usuario_numero);
            UsuarioSingleton.getUsuarioSingleton().setUsuario_email(usuarioLogado.usuario_email);
            UsuarioSingleton.getUsuarioSingleton().setUsuario_endereco_id(usuarioLogado.usuario_endereco_id);

            System.out.println(UsuarioSingleton.getUsuarioSingleton().getNivelDeAcesso());
            System.out.println(UsuarioSingleton.getUsuarioSingleton().getUsuario_id());
            System.out.println(UsuarioSingleton.getUsuarioSingleton().getUsuario_nome());
            System.out.println(UsuarioSingleton.getUsuarioSingleton().getUsuario_numero());
            System.out.println(UsuarioSingleton.getUsuarioSingleton().getUsuario_email());
            System.out.println(UsuarioSingleton.getUsuarioSingleton().getUsuario_endereco_id());

            HelloApplication.setRoot("main-view");

        }  else {
            Ong ongLogin = new Ong();
            ongLogin.ong_login = usuarioFild.getText();
            ongLogin.ong_senha = senhaFild.getText();
            boolean ong_existe = new OngDAO().ong_existe(ongLogin);

            if (ong_existe) {
                // Ong existe
                Ong ongLogada = OngDAO.getOng(ongLogin);
                // Define o nível de acesso do usuário no singleton
                OngSingleton.getOngSingleton().setNivelDeAcesso(ongLogada.ong_nvl_acesso);
                // Armazena as informações do usuário no singleton
                OngSingleton.getOngSingleton().setOng_id(ongLogada.ong_id);
                OngSingleton.getOngSingleton().setOng_nome(ongLogada.ong_nome);
                OngSingleton.getOngSingleton().setOng_telefone(ongLogada.ong_telefone);;
                OngSingleton.getOngSingleton().setOng_email(ongLogada.ong_email);
                OngSingleton.getOngSingleton().setOng_endereco_id(ongLogada.ong_endereco_id);

                System.out.println("NVL" +OngSingleton.getOngSingleton().getNivelDeAcesso());
                System.out.println("ID" + OngSingleton.getOngSingleton().getOng_id());
                System.out.println("Nome" +OngSingleton.getOngSingleton().getOng_nome());
                System.out.println("Telefone" +OngSingleton.getOngSingleton().getOng_telefone());
                System.out.println("Email" + OngSingleton.getOngSingleton().getOng_email());
                System.out.println("Endereco" + OngSingleton.getOngSingleton().getOng_endereco_id());

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

