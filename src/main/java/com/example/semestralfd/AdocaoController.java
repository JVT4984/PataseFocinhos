package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

public class AdocaoController {
    @FXML
    TableView<Adocao> tabela_Adocao;
    @FXML
    TableColumn<Adocao, Integer>  coluna_Adocao_id;
    @FXML
    TableColumn<Adocao, Integer> coluna_Adocao_usuario;
    @FXML
    TableColumn<Adocao, Integer> coluna_Adocao_ong;
    @FXML
    TableColumn<Adocao, Date> coluna_data;
}
