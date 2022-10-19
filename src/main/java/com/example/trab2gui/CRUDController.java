package com.example.trab2gui;

import com.example.trab2gui.dao.DataAccess;
import com.example.trab2gui.models.Pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CRUDController implements Initializable {
    private DataAccess db;

    // ADD
    @FXML
    private TextField add_pet_name;
    @FXML
    private TextField add_pet_type;
    @FXML
    private TextField add_pet_breed;
    @FXML
    private TextField add_pet_age;
    @FXML
    private TextField add_pet_owner_id;
    @FXML
    private ChoiceBox<String> add_pet_gender;

    private final String[] genders = {"Fêmea", "Macho"};

    @FXML
    private Button add_pet_button;

    @FXML
    private Text add_pet_response;

    @FXML
    private TextField add_owner_name;
    @FXML
    private TextField add_owner_age;
    @FXML
    private TextField add_owner_height;
    @FXML
    private TextField add_owner_weight;
    @FXML
    private Button add_owner_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            db = new DataAccess();
        } catch (Exception e) {
            System.out.println("Fudeu");
            throw new RuntimeException(e);
        }
        add_pet_gender.setValue("Fêmea");
        add_pet_gender.getItems().addAll(genders);
    }

    @FXML
    protected void onAddPetButtonClick(ActionEvent event) {
        try {
            Pet pet = new Pet(add_pet_name.getText(), add_pet_type.getText(), add_pet_breed.getText(),
                    add_pet_gender.getValue(), Integer.parseInt(add_pet_age.getText()), add_pet_owner_id.getText());
            db.addPet(pet);
            add_pet_response.setText("Pet adicionado com sucesso (id: " + pet.getId() + ")");
            add_pet_name.setText("");
            add_pet_type.setText("");
            add_pet_breed.setText("");
            add_pet_age.setText("");
            add_pet_owner_id.setText("");
        } catch (Exception e) {
            add_pet_response.setText(e.getMessage());
        }
    }

}