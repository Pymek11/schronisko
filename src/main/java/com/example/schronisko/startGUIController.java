package com.example.schronisko;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class startGUIController {
    @FXML
    private Button pracownikButton;
    @FXML
    private Button adoptujacyButton;
    @FXML
    private Button wyjscieButton;

    public void onPracownikButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) pracownikButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onAdoptujacyButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) adoptujacyButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onWyjscieButton(){
        System.exit(0);
    }
}
