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
public class PracownikZalogowanyController {
    @FXML
    private Button WylogujButton;
    @FXML
    private Button DodawanieButton;
    @FXML
    private Button StanButton;

    public void onWylogujButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) WylogujButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onDodawanieButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DodawaniePracownik.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) DodawanieButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onStanButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stanschroniskaGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) StanButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
