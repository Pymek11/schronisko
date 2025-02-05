package com.example.schronisko;

import Shelter.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class startGUIController {
    @FXML
    private Button pracownikButton;
    @FXML
    private Button adoptujacyButton;
    @FXML
    private Button wyjscieButton;

    Shelter shelter = new Shelter();
    public void onPracownikButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) pracownikButton.getScene().getWindow();
            currentStage.close();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
            newStage.setResizable(false);
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
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveChanges(){
        shelter.saveUserListToCSV();
        shelter.saveAdoptionListToCSV();
        shelter.saveEmployeeListToCSV();;
        shelter.saveAnimalListToCSV();
    }
    public void onWyjscieButton(){
        System.exit(0);
    }

}
