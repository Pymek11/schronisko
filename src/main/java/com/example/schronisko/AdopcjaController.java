package com.example.schronisko;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Shelter.*;
import javafx.scene.image.Image;
import java.io.IOException;
import java.io.InputStream;

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
    @FXML
    private ImageView imageView;
    public int i = 0;
    Shelter shelter = Shelter.getInstance();
    public void initialize(){
        updateImage();
        refresh();
    }
    private void updateImage() {
        //String url = shelter.getAnimalListElem(i).getPicture();
        //System.out.println(shelter.getAnimalListElem(i).getPicture());
        //if (url==null){System.out.println("null");}
        String url = getClass().getResource(shelter.getAnimalListElem(i).getPicture()).toExternalForm();
        Image image_ = new Image(url);
        imageView.setImage(image_);
    }

    public void onAdoptujButton(){
        //shelter.getAnimalList().remove(i);

        i-=1;
        // jak dostac którym userem jesteśmy
        int userid=0;
        Adoption adoption = new Adoption(0,userid,shelter.getAnimalListElem(i).getID());
        shelter.addAdoptionApplicationToList(adoption);
        shelter.saveAnimalListToCSV();
        shelter.saveUserListToCSV();
        shelter.saveAdoptionListToCSV();
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
    public void refresh(){
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
        refresh();
        updateImage();
    }
    public void onNastepnyButton(){
        if(i>=shelter.getAnimalList().size()-1) {
        }else{
            i+=1;
        }
        refresh();
        updateImage();
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
