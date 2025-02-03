package com.example.schronisko;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.stage.Screen;
public class AdopcjaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        double screenWidth = 600;
        double screenHeight = 400;

        FXMLLoader fxmlLoader = new FXMLLoader(AdopcjaApplication.class.getResource("adopcjazw.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), screenWidth, screenHeight);

        stage.setTitle("Adopcja zwierzat");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}