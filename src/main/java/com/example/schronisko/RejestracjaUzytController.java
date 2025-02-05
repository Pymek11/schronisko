package com.example.schronisko;

import Shelter.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RejestracjaUzytController {
    Shelter shelter = new Shelter();
    @FXML
    TextField EmailText;
    @FXML
    TextField HasloText;
    @FXML
    TextField ImieText;
    @FXML
    TextField AdressText;
    @FXML
    Button ZarejestrujButton;
    @FXML
    Button PowrotButton;
    public void onZarejestrujButton(){

        for(Emailtext ){
            String email = EmailText.getText();
            String haslo = HasloText.getText();
            String imie = ImieText.getText();
            String adres = AdressText.getText();

            User user = new User(0,imie,adres,email,haslo);
            shelter.getUserList().add(user);
            shelter.saveUserListToCSV();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyLoginGUI.fxml"));
                Parent root = loader.load();
                Stage currentStage = (Stage) ZarejestrujButton.getScene().getWindow();
                currentStage.close();

                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.show();
                newStage.setResizable(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void onPowrotButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
