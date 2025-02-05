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
    private ImageView imageView;
    public int i = 0;
    Shelter shelter = Shelter.getInstance();
    public void initialize(){
        updateImage();
    }
    private void updateImage() {
        //String imageUrl = "src/main/resources/com/example/schronisko/pictures"+ shelter.getAnimalListElem(i).getPicture();
        String imageUrl = getClass().getResource("/pies1.jpg").toExternalForm();
        //String imageUrl = new File("C:/Users/Fisher/IdeaProjects/schronisko/src/main/resources/pies1.jpg").toURI().toString();
        try {
            Image image_ = new Image(imageUrl);
            System.out.println("1");
            imageView.setImage(image_);
            System.out.println("2");
            //System.out.println(imageUrl);
        }catch (Exception e){
            System.out.println("zły url");
            //System.out.println(imageUrl);
        }
    }
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
