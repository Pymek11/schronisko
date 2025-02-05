package com.example.schronisko;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Shelter.*;
import java.io.IOException;
public class AdoptujacyLoginController {
    @FXML
    private Button PowrotButton;
    @FXML
    private Button ZalogujButton;
    @FXML
    private TextField LoginText;
    @FXML
    private PasswordField HasloText;

    public void onZalogujButton(){
        if(LoginText.getText().equals("admin") && HasloText.getText().equals("admin") || LoginText.getText().equals("0") && HasloText.getText().equals("0") ){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyGUI.fxml"));
                Parent root = loader.load();
                Stage currentStage = (Stage) ZalogujButton.getScene().getWindow();
                currentStage.close();
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.setTitle("Oddawanie zwierzat");
                newStage.show();
                newStage.setResizable(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void onPowrotButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("startGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Strona Schroniska");
            newStage.show();
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
