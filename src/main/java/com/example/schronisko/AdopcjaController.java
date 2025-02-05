package com.example.schronisko;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import Shelter.*;
import java.io.IOException;
import java.sql.Ref;

public class AdopcjaController {
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
    @FXML
    private TextField GatunekText;
    public int i = 0;
    Shelter shelter = Shelter.getInstance();
    public void onAdoptujButton(){
        shelter.getAnimalList().remove(i);
        shelter.saveAnimalListToCSV();
        i-=1;
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
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Refresh(){
        OpisText.setText(shelter.getAnimalListElem(i).getDescription());
        WagaText.setText(Double.toString(shelter.getAnimalListElem(i).getWeight()));
        WiekText.setText(Integer.toString(shelter.getAnimalListElem(i).getAge()));
        RasaText.setText(shelter.getAnimalListElem(i).getBreed());
        ImieText.setText(shelter.getAnimalListElem(i).getImie());
        GatunekText.setText(shelter.getAnimalListElem(i).getSpecies());
        //}
    }
    public void onPoprzedniButton(){
        if(i==0){
            }else{
            i-=1;
        }
        Refresh();
    }
    public void onNastepnyButton(){
        if(i>=shelter.getAnimalList().size()-1) {
        }else{
            i+=1;
        }
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
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
