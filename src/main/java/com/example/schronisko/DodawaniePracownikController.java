package com.example.schronisko;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Shelter.*;
import org.w3c.dom.Text;

import javax.swing.text.html.ImageView;
import java.io.IOException;
public class DodawaniePracownikController {
    Shelter shelter = Shelter.getInstance();
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
    @FXML
    private TextField GatunekText;
    @FXML
    private TextField Image;

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
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onDodajButton(){
        String imie = ImieText.getText();
        int wiek = Integer.parseInt(WiekText.getText());
        String rasa = RasaText.getText();
        float waga = Float.parseFloat(WagaText.getText());
        Animal animal = new Animal(0,imie,"gatunek",rasa, wiek,waga);
        animal.setPicture(Image.getText());
        shelter.getAnimalList().add(animal);

        shelter.saveAnimalListToCSV();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikzalogowanyGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) DodajButton.getScene().getWindow();
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
