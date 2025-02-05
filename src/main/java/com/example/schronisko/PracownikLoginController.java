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

public class PracownikLoginController {
    @FXML
    private Button PowrotButton;
    @FXML
    private Button ZalogujButton;
    @FXML
    private TextField IDPracownikaText;
    @FXML
    private PasswordField HasloPracownikaText;

    public void onZalogujButton(){
        if(HasloPracownikaText.getText().equals("admin") && IDPracownikaText.getText().equals("admin")){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikzalogowanyGUI.fxml"));
                Parent root = loader.load();
                Stage currentStage = (Stage) ZalogujButton.getScene().getWindow();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("startGUI.fxml"));
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
