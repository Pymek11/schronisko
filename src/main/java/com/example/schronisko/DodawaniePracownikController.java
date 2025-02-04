package com.example.schronisko;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Shelter.*;
import java.io.IOException;
public class DodawaniePracownikController {
    @FXML
    private Button PowrotButton;
    @FXML
    private Button DodajButton;
    @FXML
    private TextField WagaText;
    @FXML
    private TextField ImieText;
    @FXML
    private TextField WiekText;
    @FXML
    private TextField RasaText;

    public void onPowrotButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikzalogowanyGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Oddawanie zwierzat");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onDodajButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikzalogowanyGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) DodajButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
