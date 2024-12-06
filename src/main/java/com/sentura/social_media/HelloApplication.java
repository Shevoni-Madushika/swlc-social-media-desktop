package com.sentura.social_media;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the main layout from FXML and cast it to AnchorPane
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        AnchorPane root = loader.load();


        // Set a fixed size for the Scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Make the window non-resizable
        primaryStage.setResizable(false);

        // Show the primary stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
