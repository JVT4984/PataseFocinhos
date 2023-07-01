package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CadastroOngController {

    @FXML
    TextField ong_idFild;
    @FXML
    TextField ong_loginFild;
    @FXML
    TextField ong_senhaFild;
    @FXML
    TextField ong_nomeFild;
    @FXML
    TextField ong_numeroFild;
    @FXML
    TextField ong_emailFild;
    @FXML
    TextField ong_enderecoFild;


    public static Ong ong;

    @FXML
    public void salvar() throws IOException, SQLException {
        Ong novaOng = new Ong();
        if (!ong_idFild.getText().isBlank()){
            novaOng.ong_id = Integer.parseInt(ong_idFild.getText());
        }
        novaOng.ong_login = ong_loginFild.getText();
        novaOng.ong_senha = ong_senhaFild.getText();
        novaOng.ong_nome = ong_nomeFild.getText();
        novaOng.ong_telefone = Integer.parseInt(ong_numeroFild.getText());
        novaOng.ong_email = ong_emailFild.getText();
        novaOng.ong_endereco_id = Integer.parseInt(ong_enderecoFild.getText());

        ong = novaOng;

        new OngDAO().insertOng(novaOng);

        HelloApplication.setRoot("hello-view");
    }


    @FXML
    public void cancelar() throws IOException {

        HelloApplication.setRoot("hello-view");
    }
}
