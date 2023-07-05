package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OngModalController implements Initializable {

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
        //if (!ong_loginFild.getText().isBlank()){
          //  novaOng.ong_login = ong_loginFild.getText();
        //}
        //if (!ong_senhaFild.getText().isBlank()){
          //  novaOng.ong_senha = ong_senhaFild.getText();
        //}
        novaOng.ong_login = ong_loginFild.getText();
        novaOng.ong_senha = ong_senhaFild.getText();
        novaOng.ong_nome = ong_nomeFild.getText();
        novaOng.ong_telefone = ong_numeroFild.getText();
        novaOng.ong_email = ong_emailFild.getText();
        novaOng.ong_endereco_id = Integer.parseInt(ong_enderecoFild.getText());

        ong = novaOng;

        HelloApplication.closeCurrentWindow();
    }


    @FXML
    public void cancelar() throws IOException {

        HelloApplication.setRoot("ong-view");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ong ongSelecionada = OngModalController.ong;

        if (ongSelecionada != null) {
            ong_idFild.setText(Integer.toString(ongSelecionada.ong_id));
            ong_loginFild.setText((ongSelecionada.ong_login));
            ong_senhaFild.setText(ongSelecionada.ong_senha);
            ong_nomeFild.setText(ongSelecionada.ong_nome);
            ong_numeroFild.setText(ongSelecionada.ong_telefone);
            ong_emailFild.setText(ongSelecionada.ong_email);
            ong_enderecoFild.setText(Integer.toString(ongSelecionada.ong_endereco_id));
        }
    }
}


