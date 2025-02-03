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

public class AdopcjaController {
    @FXML
    private ComboBox<String> ComboboxZwierzaki  ;
    @FXML
    private Button PowrotButton;
    @FXML
    private Button PoprzedniButton;
    @FXML
    private Button NastepnyButton;
    @FXML
    private Button AdoptujButton;
    @FXML
    private TextArea OpisText;
    @FXML
    private TextField WagaText;
    @FXML
    private TextField WiekText;
    @FXML
    private TextField RasaText;
    @FXML
    private TextField ImieText;

    public void Refresh(){
        //selected animal
        // if selected animal != null
        // else {
        OpisText.setText("");
        WagaText.setText("");
        WiekText.setText("");
        RasaText.setText("");
        ImieText.setText("");
        //}
    }
    public void onAdoptujButton(){
        //selected animal
        //if selected animal != null
        //remove animal from hashmap
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyGUI.fxml"));
            Parent root = loader.load();

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();

            // Create a new stage (window) for the new FXML
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Adoptujący GUI");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onPoprzedniButton(){
        //get selected animal
        // selected animal == animal + 1
        // if selected animal(index w hashmapie) > size(hashmapa)
        //return animal(0)
        Refresh();
    }
    public void onNastepnyButton(){
        //get selected animal
        // selected animal == animal - 1
        // if selected animal(index w hashmapie) < 0
        //return animal( index max hashmapy -1)
        Refresh();
    }
    public void onPowrotButton(){
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyGUI.fxml"));
            Parent root = loader.load();

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();

            // Create a new stage (window) for the new FXML
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Adoptujący GUI");
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
