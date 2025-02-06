package com.example.schronisko;

import com.sun.jdi.Value;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Shelter.*;
import java.io.IOException;
public class AdoptujacyLoginController {
    Shelter shelter = new Shelter();
    @FXML
    private Button PowrotButton;
    @FXML
    private Button ZalogujButton;
    @FXML
    private Button ZarejestrujButton;
    @FXML
    private TextField LoginText;
    @FXML
    private PasswordField HasloText;
    public String getPasswordByEmail(String email) {
        for (User user : shelter.getUserList()) {
            if (user.getEmail().equals(email)) {
                return user.getPassword();
            }
        }
        return "Email not found";
    }
    public String getIdByEmail(String email){
        for (User user : shelter.getUserList()) {
            if (String.valueOf(user.getId()).equals(email)) {
                return String.valueOf(user.getId());
            }
        }
        return "id not found";
    }
    public void onZalogujButton(){
        String password = getPasswordByEmail(LoginText.getText());
        if(password.equals( HasloText.getText()) ){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyGUI.fxml"));
                Parent root = loader.load();
                Stage currentStage = (Stage) ZalogujButton.getScene().getWindow();
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
    public void onPowrotButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("startGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) PowrotButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Strona Schroniska");
            newStage.show();
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onZarejestrujButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RejestacjaUzyt.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ZarejestrujButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Rejestracja");
            newStage.show();
            newStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
