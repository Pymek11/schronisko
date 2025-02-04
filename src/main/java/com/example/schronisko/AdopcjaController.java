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
    public startGUIController startguicontroller;
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
    public int i = 0;

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
    public void Refresh(){

        OpisText.setText(startguicontroller.shelter.getAnimalListElem(i).getDescription());
        WagaText.setText(Double.toString(startguicontroller.shelter.getAnimalListElem(i).getWeight()));
        WiekText.setText(Integer.toString(startguicontroller.shelter.getAnimalListElem(i).getAge()));
        RasaText.setText(startguicontroller.shelter.getAnimalListElem(i).getBreed());
        //ImieText.setText(startguicontroller.shelter.getAnimalListElem(i).getName());
        //}
    }
    public void onPoprzedniButton(){
        i-=1;
    }
    public void onNastepnyButton(){
        //get selected animal
        // selected animal == animal - 1
        // if selected animal(index w hashmapie) < 0
        //return animal( index max hashmapy -1)

        i+=1;



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
