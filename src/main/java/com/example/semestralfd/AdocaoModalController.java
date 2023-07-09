package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdocaoModalController {
    @FXML
    TextField adocao_idFild;
    @FXML
    TextField adocao_ongidFild;
    @FXML
    TextField adocao_usuarioidFIld;
    @FXML
    TextField adocao_animalidFild;
    @FXML
    DatePicker adocao_dtFild;

    public static Adocao adocao;

    @FXML
    public void adotar() throws IOException, SQLException {
        Adocao novaAdocao = new Adocao();
        if (!adocao_idFild.getText().isBlank()){
            novaAdocao.adocao_id = Integer.parseInt(adocao_idFild.getText());
        }
        novaAdocao.adocao_ong_id = Integer.parseInt(adocao_ongidFild.getText());
        novaAdocao.adocao_usuario_id = Integer.parseInt(adocao_usuarioidFIld.getText());
        novaAdocao.adocao_animal_id = Integer.parseInt(adocao_animalidFild.getText());

        LocalDate localDate = adocao_dtFild.getValue();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        novaAdocao.data_adocao = sqlDate;

        adocao = novaAdocao;

        new AdocaoDAO().insertAdocao(novaAdocao);

        HelloApplication.closeCurrentWindow();
    }
    @FXML
    public void cancelarAdocoa() throws IOException {

        HelloApplication.closeCurrentWindow();
    }
}