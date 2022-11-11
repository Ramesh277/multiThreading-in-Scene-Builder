package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


    //step -2
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("downloadManager"), 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    //change the view
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    //step -3
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    //step -1
    //  application lunch
    public static void main(String[] args) {
        launch();


    }

}