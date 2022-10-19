package com.example.trab2gui;

import com.example.trab2gui.dao.DataAccess;
import com.example.trab2gui.models.Pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CRUDController implements Initializable {
    private DataAccess db;

    private final String[] genders = {"Fêmea", "Macho"};

    // READ
    @FXML
    private TextField read_pet_id;
    @FXML
    private Button read_pet_search_button;
    @FXML
    private TableView<Pet> read_pet_table;
    @FXML
    private TableColumn<Pet, String> read_pet_column_id;
    @FXML
    private TableColumn<Pet, String> read_pet_column_name;
    @FXML
    private TableColumn<Pet, String> read_pet_column_type;
    @FXML
    private TableColumn<Pet, String> read_pet_column_breed;
    @FXML
    private TableColumn<Pet, Integer> read_pet_column_age;
    @FXML
    private TableColumn<Pet, String> read_pet_column_gender;
    @FXML
    private TableColumn<Pet, String> read_pet_column_owner_id;


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
    @FXML
    private Text add_owner_response;

    // UPDATE
    @FXML
    private TextField update_pet_id;
    @FXML
    private Button update_pet_search_button;
    @FXML
    private TextField update_pet_name;
    @FXML
    private TextField update_pet_type;
    @FXML
    private TextField update_pet_breed;
    @FXML
    private TextField update_pet_age;
    @FXML
    private TextField update_pet_owner_id;
    @FXML
    private ChoiceBox<String> update_pet_gender;
    @FXML
    private Button update_pet_button;
    @FXML
    private Text update_pet_response;

    @FXML
    private TextField update_owner_id;
    @FXML
    private Button update_owner_search_button;
    @FXML
    private TextField update_owner_name;
    @FXML
    private TextField update_owner_age;
    @FXML
    private TextField update_owner_height;
    @FXML
    private TextField update_owner_weight;
    @FXML
    private Button update_owner_button;
    @FXML
    private Text update_owner_response;

    // DELETE
    @FXML
    private TextField delete_pet_id;
    @FXML
    private Button delete_pet_search_button;
    @FXML
    private TextField delete_pet_name;
    @FXML
    private TextField delete_pet_type;
    @FXML
    private TextField delete_pet_breed;
    @FXML
    private TextField delete_pet_age;
    @FXML
    private TextField delete_pet_owner_id;
    @FXML
    private ChoiceBox<String> delete_pet_gender;
    @FXML
    private Button delete_pet_button;
    @FXML
    private Text delete_pet_response;

    @FXML
    private TextField delete_owner_id;
    @FXML
    private Button delete_owner_search_button;
    @FXML
    private TextField delete_owner_name;
    @FXML
    private TextField delete_owner_age;
    @FXML
    private TextField delete_owner_height;
    @FXML
    private TextField delete_owner_weight;
    @FXML
    private Button delete_owner_button;
    @FXML
    private Text delete_owner_response;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            db = new DataAccess();
        } catch (Exception e) {
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
            add_pet_response.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    protected void onUpdatePetButtonClick(ActionEvent event) {
        // TODO: Implementar método que diz o que acontece quando clicar no botão de editar Pet
    }

    @FXML
    protected void onDeletePetButtonClick(ActionEvent event) {
        // TODO: Implementar método que diz o que acontece quando clicar no botão de excluir Pet
    }
}