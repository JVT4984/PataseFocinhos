package com.example.semestralfd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {
    @FXML
    TableView<Usuario> tabela_Usuario;

    @FXML
    TableColumn<Usuario, Integer> colunaUsuario_id;

    @FXML
    TableColumn<Usuario, String> colunaUsuario_nome;

    @FXML
    TableColumn<Usuario, String> colunaUsuario_numero;

    @FXML
    TableColumn<Usuario, String> colunaUsuario_email;
    @FXML
    TableColumn<Usuario, Integer> colunaUsuario_endereco;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        Configura as colunas da tabela da interfdce gráfica
         */
        colunaUsuario_id.setCellValueFactory(new PropertyValueFactory<>("usuario_id"));
        colunaUsuario_nome.setCellValueFactory(new PropertyValueFactory<>("usuario_nome"));
        colunaUsuario_numero.setCellValueFactory(new PropertyValueFactory<>("usuario_numero"));
        colunaUsuario_email.setCellValueFactory(new PropertyValueFactory<>("usuario_email"));
        colunaUsuario_endereco.setCellValueFactory(new PropertyValueFactory<>("usuario_endereco_id"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            List<Usuario> usuarios = usuarioDAO.getAll();
            tabela_Usuario.getItems().addAll(usuarios);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void excluir() throws SQLException {

        //Obter o produto selecionada
        Usuario usuarioSelecionado = tabela_Usuario.getSelectionModel().getSelectedItem();

        //Confirmação de exclusão
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Você realmente deseja exluir a sua conta" + usuarioSelecionado.usuario_nome);
        alert.setHeaderText(null);
        alert.setContentText("Deseja excluir a conta?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){

            UsuarioDAO delete = new UsuarioDAO();
            delete.delete(usuarioSelecionado);
            // Excluir o produto
            tabela_Usuario.getItems().remove(usuarioSelecionado);
        }
    }

    @FXML
    public void editar() throws IOException, SQLException {
        Usuario usuarioSelecionado = tabela_Usuario.getSelectionModel().getSelectedItem();

        UsuarioModalController.usuario = usuarioSelecionado;

        HelloApplication.showModal("ong-modal-view");

        // O modal foi fechado

        Usuario usuarioEditado = UsuarioModalController.usuario;

        usuarioSelecionado.usuario_id = usuarioEditado.usuario_id;
        usuarioSelecionado.usuario_login = usuarioEditado.usuario_login;
        usuarioSelecionado.usuario_senha = usuarioEditado.usuario_senha;
        usuarioSelecionado.usuario_nome = usuarioEditado.usuario_nome;
        usuarioSelecionado.usuario_email = usuarioEditado.usuario_email;
        usuarioSelecionado.usuario_numero= usuarioEditado.usuario_numero;
        usuarioSelecionado.usuario_endereco_id= usuarioEditado.usuario_endereco_id;

        tabela_Usuario.refresh();
        new UsuarioDAO().update(usuarioEditado);
    }

    @FXML
    public void voltar() throws IOException {
        HelloApplication.setRoot("main-view");
    }
}

