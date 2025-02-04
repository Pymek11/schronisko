package com.example.schronisko;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Shelter.*;
import java.io.IOException;
public class AdoptujacyGUIController {
    @FXML
    private Button PowrotButton;
    @FXML
    private Button AdopcjaButton;
    @FXML
    private Button OddanieButton;

    public void onPowrotButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Login");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onOddanieButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dodawaniezw.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) OddanieButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Oddawanie zwierzat");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onAdopcjaButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adopcjazw.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) AdopcjaButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Login");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
