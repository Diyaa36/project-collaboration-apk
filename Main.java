package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the login interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/auth_interface.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 300, 200); // Set size for login screen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Authentification");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
