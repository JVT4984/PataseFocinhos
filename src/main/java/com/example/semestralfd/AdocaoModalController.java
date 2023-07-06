package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdocaoModalController implements Initializable {
    @FXML
    TextField adocao_idFild;
    @FXML
    TextField adocao_ongiidFild;
    @FXML
    TextField adocao_usuarioidFIld;
    @FXML
    TextField adocao_animalidFild;
    @FXML
    TextField adocao_dtFild;

    public static Adocao adocao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        {
            Animal animalSelecionado = AnimalModalController.animal;

            if (animalSelecionado != null) {
                adocao_ongiidFild.setText(Integer.toString(animalSelecionado.ong_id));
                adocao_animalidFild.setText(String.valueOf(animalSelecionado.animal_id));
            }
        }
    }
}
