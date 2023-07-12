package com.example.semestralfd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Scene scene;
    private static Stage modalStage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("hello-view"), 750, 450);
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Define a tela sendo exibida com base no nome do arquivo fxml
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Exibe uma janela em modo modal com base no nome do arquivo fxml
     */
    public static void showModal(String fxml) throws IOException {
        // Obtém a tela atual

        // Carrega a nova tela
        Scene modalScene = new Scene(loadFXML(fxml));

        // Abre o modal
        modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.initOwner(scene.getRoot().getScene().getWindow());
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    /**
     * Fecha a janela atual
     */
    public static void closeCurrentWindow() {
        modalStage.close();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}