package com.example.schronisko;

import Shelter.*;
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
import java.util.HashMap;
import java.util.List;

public class startGUIController {
    @FXML
    private Button pracownikButton;
    @FXML
    private Button adoptujacyButton;
    @FXML
    private Button wyjscieButton;

    Shelter shelter = new Shelter();
    HashMap<Integer, Animal> DogsList = new HashMap<>();
    HashMap<Integer, Animal> CatsList = new HashMap<>();
    HashMap<Integer, User> UserList = new HashMap<>();
    HashMap<Integer, Employee> EmployeeList = new HashMap<>();
    public void initialize(){
       for (Animal animal : shelter.getAnimalList()) {
            if ("pies".equalsIgnoreCase(animal.getSpecies())) {
                DogsList.put(animal.getID(), animal);
            } else if ("kot".equalsIgnoreCase(animal.getSpecies())) {
                CatsList.put(animal.getID(), animal);
            }
        }
        for (User user : shelter.getUserList()) {
            UserList.put(user.getId(), user);
        }
        for (Employee employee : shelter.getEmployeeList()) {
            EmployeeList.put(employee.getId(), employee);
        }


    }
    public void onPracownikButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pracownikLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) pracownikButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onAdoptujacyButton(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adoptujacyLoginGUI.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) adoptujacyButton.getScene().getWindow();
            currentStage.close();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveChanges(){
        shelter.saveUserListToCSV();
        shelter.saveAdoptionListToCSV();
        shelter.saveEmployeeListToCSV();;
        shelter.saveAnimalListToCSV();
    }
    public void onWyjscieButton(){
        System.exit(0);
    }
}
