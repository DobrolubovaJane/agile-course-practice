package ru.unn.agile.PositionalNotation.view;
/**
 * Created by Jane on 21.11.2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Converter.fxml"));
        primaryStage.setTitle("Converter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
