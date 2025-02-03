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
public class AdoptujacyLoginController {
    @FXML
    private Button PowrotButton;
    @FXML
    private Button ZalogujButton;
    @FXML
    private TextField LoginText;

    public void onZalogujButton(){
        // get id get haslo
        //sprawdzanie czy id -> haslo hashmapy == haslo wpisane
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ZalogujButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Oddawanie zwierzat");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
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
            newStage.setTitle("STRONA SCHRONISKO");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
