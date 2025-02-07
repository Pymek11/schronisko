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

public class WniosekPracownikView {
    Shelter shelter = new Shelter();
    @FXML
    private Button PowrotButton;
    @FXML
    private Button OdrzucButton;
    @FXML
    private Button PoprzedniButton;
    @FXML
    private Button NastepnyButton;
    @FXML
    private Button ZatwierdzButton;
    @FXML
    private TextField IdText;
    @FXML
    private TextField WagaText;
    @FXML
    private TextField WiekText;
    @FXML
    private TextField RasaText;
    @FXML
    private TextField ImieText;
    @FXML
    private ImageView imageView;
    @FXML
    private TextArea OpisText;
    public int i = 0;
    public int j = 0;
    public void initialize(){
        updateImage();
        refresh();
    }
    public Animal getAnimal(int id){
        for(Animal animal:shelter.getAnimalList()){
            if (animal.getID()==id){
                return animal;
            }
        }
        return null;
    }
    public User getAdopting(int id){
        for(User user:shelter.getUserList()){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public void refresh(){
        Adoption adoption = shelter.getAdoptionListElem(i);

        Animal u = getAnimal(shelter.getAdoptionListElem(i).getIdofAnimal());
        User k = getAdopting(shelter.getAdoptionListElem(i).getIdofSubbmiter());
        System.out.println(adoption.getId());

            IdText.setText(Integer.toString(adoption.getId()));

            OpisText.setText("Dane Adoptujacego : " + k.getId() + ", " +
                   k.getName() + ", " +
                    k.getEmail() + ", " +
                    k.getAddress() );
            WagaText.setText(Double.toString(u.getWeight()));
            WiekText.setText(Integer.toString(u.getAge()));
            RasaText.setText(u.getBreed());
            ImieText.setText(u.getImie());

    }
    private void updateImage() {
        //String url = shelter.getAnimalListElem(i).getPicture();
        //System.out.println(shelter.getAnimalListElem(i).getPicture());
        //if (url==null){System.out.println("null");}
        String url = getClass().getResource(shelter.getAnimalListElem(i).getPicture()).toExternalForm();
        Image image_ = new Image(url);
        imageView.setImage(image_);
    }

    public void onPowrotButton(){
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikzalogowanyGUI.fxml"));
            Parent root = loader.load();

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();

            // Create a new stage (window) for the new FXML
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Pracownik Logged In");
            newStage.show();
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onZatwierdzButton(){
        int currentAdoptionId = Integer.parseInt(IdText.getText());

        // Call a method in the Shelter class to remove the adoption by ID
        boolean removalSuccessful = shelter.removeAdoptionById(currentAdoptionId);

        if (removalSuccessful) {
            // Save the updated adoption list to the CSV file
            shelter.saveAdoptionListToCSV();

            // Update the UI to reflect changes
            if (i > 0) {
                i--; // Move to the previous element if possible
            }
            refresh();
            updateImage();
        } else {
            // Show an error if the removal failed
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Removal Failed");
            alert.setContentText("Could not remove the selected adoption request.");
            alert.showAndWait();
        }

        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikzalogowanyGUI.fxml"));
            Parent root = loader.load();

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) ZatwierdzButton.getScene().getWindow();
            currentStage.close();

            // Create a new stage (window) for the new FXML
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Pracownik Logged In");
            newStage.show();
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onOdrzucButton(){
        int currentAdoptionId = Integer.parseInt(IdText.getText());

        // Call a method in the Shelter class to remove the adoption by ID
        boolean removalSuccessful = shelter.removeAdoptionById(currentAdoptionId);

        if (removalSuccessful) {
            // Save the updated adoption list to the CSV file
            shelter.saveAdoptionListToCSV();

            // Update the UI to reflect changes
            if (i > 0) {
                i--; // Move to the previous element if possible
            }
            refresh();
            updateImage();
        } else {
            // Show an error if the removal failed
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Removal Failed");
            alert.setContentText("Could not remove the selected adoption request.");
            alert.showAndWait();
        }

        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikzalogowanyGUI.fxml"));
            Parent root = loader.load();

            // Get the current stage (window) and close it
            Stage currentStage = (Stage) ZatwierdzButton.getScene().getWindow();
            currentStage.close();

            // Create a new stage (window) for the new FXML
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Pracownik Logged In");
            newStage.show();
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onPoprzedniButton(){
        if(i==0){
        }else{
            i-=1;
        }
        if(j==0){
        }else {
            j-=1;
        }
        refresh();
        updateImage();
    }
    public void onNastepnyButton(){
        if(i>=shelter.getAdoptionList().size()-1) {
        }else{
            i+=1;
        }
        if(j>=shelter.getAdoptionList().size()-1) {}
        else{j+=1;}
        refresh();
        updateImage();
    }

}
