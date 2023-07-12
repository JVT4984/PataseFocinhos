package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RelatorioUsuarioController implements Initializable {
    @FXML
    TableView<Usuario> tabela_RelatorioUsuario;

    @FXML
    TableColumn<Usuario, Integer> colunaRelatorioUsuario_id;

    @FXML
    TableColumn<Usuario, String> colunaRelatorioUsuario_nome;

    @FXML
    TableColumn<Usuario, String> colunaRelatorioUsuario_numero;

    @FXML
    TableColumn<Usuario, String> colunaRelatorioUsuario_email;

    @FXML
    TableColumn<Usuario, Integer> colunaRelatorioUsuario_endereco;

    @FXML
    TableColumn<Usuario, Date> colunaRelatorio_dtcadastro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        Configura as colunas da tabela da interfdce gráfica
         */
        colunaRelatorioUsuario_id.setCellValueFactory(new PropertyValueFactory<>("usuario_id"));
        colunaRelatorioUsuario_nome.setCellValueFactory(new PropertyValueFactory<>("usuario_nome"));
        colunaRelatorioUsuario_numero.setCellValueFactory(new PropertyValueFactory<>("usuario_numero"));
        colunaRelatorioUsuario_email.setCellValueFactory(new PropertyValueFactory<>("usuario_email"));
        colunaRelatorioUsuario_endereco.setCellValueFactory(new PropertyValueFactory<>("usuario_endereco_id"));
        colunaRelatorio_dtcadastro.setCellValueFactory(new PropertyValueFactory<>("usuario_dt_cadastro"));

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        try {
            List<Usuario> usuarios = relatorioDAO.pesquisarUsuariosOrdenadosPorData();
            tabela_RelatorioUsuario.getItems().addAll(usuarios);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
