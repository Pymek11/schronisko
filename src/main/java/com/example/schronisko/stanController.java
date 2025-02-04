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
import java.util.HashMap;

public class stanController {
    Shelter shelter = Shelter.getInstance();
    @FXML
    private Button PowrotButton;
    @FXML
    private TextField iloscAdText;
    @FXML
    private TextField iloscZwText;
    public void Refresh(){
        iloscAdText.setText(String.valueOf(shelter.getAdoptionList().size()));
        iloscZwText.setText(String.valueOf(shelter.getAnimalList().size()));
    }
    public void initialize(){
        Refresh();
    }
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
}
