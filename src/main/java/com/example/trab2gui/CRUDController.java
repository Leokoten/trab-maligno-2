package com.example.trab2gui;

import com.example.trab2gui.dao.DataAccess;
import com.example.trab2gui.models.Owner;
import com.example.trab2gui.models.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML
    private TextField read_owner_id;
    @FXML
    private Button read_owner_search_button;
    @FXML
    private TableView<Owner> read_owner_table;
    @FXML
    private TableColumn<Owner, String> read_owner_column_id;
    @FXML
    private TableColumn<Owner, String> read_owner_column_name;
    @FXML
    private TableColumn<Owner, Integer> read_owner_column_age;
    @FXML
    private TableColumn<Owner, Double> read_owner_column_height;
    @FXML
    private TableColumn<Owner, Double> read_owner_column_weight;


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
            System.exit(-1);
        }

        read_pet_column_id.setCellValueFactory(new PropertyValueFactory<Pet, String>("id"));
        read_pet_column_name.setCellValueFactory(new PropertyValueFactory<Pet, String>("name"));
        read_pet_column_type.setCellValueFactory(new PropertyValueFactory<Pet, String>("type"));
        read_pet_column_breed.setCellValueFactory(new PropertyValueFactory<Pet, String>("breed"));
        read_pet_column_gender.setCellValueFactory(new PropertyValueFactory<Pet, String>("gender"));
        read_pet_column_age.setCellValueFactory(new PropertyValueFactory<Pet, Integer>("age"));
        read_pet_column_owner_id.setCellValueFactory(new PropertyValueFactory<Pet, String>("owner"));

        read_owner_column_id.setCellValueFactory(new PropertyValueFactory<Owner, String>("id"));
        read_owner_column_name.setCellValueFactory(new PropertyValueFactory<Owner, String>("name"));
        read_owner_column_age.setCellValueFactory(new PropertyValueFactory<Owner, Integer>("age"));
        read_owner_column_height.setCellValueFactory(new PropertyValueFactory<Owner, Double>("height"));
        read_owner_column_weight.setCellValueFactory(new PropertyValueFactory<Owner, Double>("weight"));

        add_pet_gender.setValue("Fêmea");
        add_pet_gender.getItems().addAll(genders);
        update_pet_gender.setValue("Fêmea");
        update_pet_gender.getItems().addAll(genders);
        delete_pet_gender.setValue("Fêmea");
        delete_pet_gender.getItems().addAll(genders);
    }

    @FXML
    protected void onReadPetsButtonClick(ActionEvent event) {
        if (read_pet_id.getText().equals("")) {
            read_pet_table.setItems(db.getAllPets());
            return;
        }
        Pet pet = db.getPetById(read_pet_id.getText());
        if (pet == null) {
            read_pet_table.setItems(db.getPetsByOwner(read_pet_id.getText()));
            return;
        }
        ObservableList<Pet> pets = FXCollections.observableArrayList();
        pets.add(pet);
        read_pet_table.setItems(pets);
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
    protected void onSearchUpdatePetButtonClick(ActionEvent event) {
        try {
            Pet pet = db.getPetById(update_pet_id.getText());
            if (pet == null) throw new Exception("Pet não encontrado");
            update_pet_name.setText(pet.getName());
            update_pet_type.setText(pet.getType());
            update_pet_breed.setText(pet.getBreed());
            update_pet_gender.setValue(pet.getGender());
            update_pet_age.setText(String.valueOf(pet.getAge()));
            update_pet_owner_id.setText(pet.getOwner());
        } catch (Exception err) {
            update_pet_response.setText("Erro: " + err.getMessage());
        }
    }

    @FXML
    protected void onUpdatePetButtonClick(ActionEvent event) {
        try {
            Pet pet = new Pet(update_pet_name.getText(), update_pet_type.getText(),
                    update_pet_breed.getText(), update_pet_gender.getValue(), Integer.parseInt(update_pet_age.getText()) ,
                    update_pet_owner_id.getText(), update_pet_id.getText());
            db.updatePetById(update_pet_id.getText(), pet);
            update_pet_response.setText("Pet atualizado com sucesso (id: " + pet.getId() + ")");
            update_pet_id.setText("");
            update_pet_name.setText("");
            update_pet_type.setText("");
            update_pet_breed.setText("");
            update_pet_age.setText("");
            update_pet_owner_id.setText("");
        } catch (Exception err) {
            update_pet_response.setText("Erro: " + err.getMessage());
        }
    }

    @FXML
    protected void onSearchDeletePetButtonClick(ActionEvent event) {
        try {
            Pet pet = db.getPetById(delete_pet_id.getText());
            if (pet == null) throw new Exception("Pet não encontrado");
            delete_pet_name.setText(pet.getName());
            delete_pet_type.setText(pet.getType());
            delete_pet_breed.setText(pet.getBreed());
            delete_pet_gender.setValue(pet.getGender());
            delete_pet_age.setText(String.valueOf(pet.getAge()));
            delete_pet_owner_id.setText(pet.getOwner());
        } catch (Exception err) {
            delete_pet_response.setText("Erro: " + err.getMessage());
        }
    }

    @FXML
    protected void onDeletePetButtonClick(ActionEvent event) {
        try {
            db.deletePetById(delete_pet_id.getText());
            delete_pet_response.setText("Pet excluído com sucesso (id: " + delete_pet_id.getText() + ")");
            delete_pet_id.setText("");
            delete_pet_name.setText("");
            delete_pet_type.setText("");
            delete_pet_breed.setText("");
            delete_pet_age.setText("");
            delete_pet_owner_id.setText("");
        } catch (Exception err) {
            delete_pet_response.setText("Erro: " + err.getMessage());
        }
    }

    @FXML
    protected void onReadOwnersButtonClick(ActionEvent event) {
        if (read_owner_id.getText().equals("")) {
            read_owner_table.setItems(db.getAllOwners());
            return;
        }
        Owner owner = db.getOwnerById(read_owner_id.getText());
        ObservableList<Owner> owners = FXCollections.observableArrayList();
        if (owner != null) owners.add(owner);
        read_owner_table.setItems(owners);
    }

    @FXML
    protected void onAddOwnerButtonClick(ActionEvent event) {
        try {
            Owner owner = new Owner(add_owner_name.getText(), Integer.parseInt(add_owner_age.getText()),
                    Double.parseDouble(add_owner_height.getText()), Double.parseDouble(add_owner_weight.getText()));
            db.addOwner(owner);
            add_owner_response.setText("Dono adicionado com sucesso (id: " + owner.getId() + ")");
            add_owner_name.setText("");
            add_owner_age.setText("");
            add_owner_height.setText("");
            add_owner_weight.setText("");
        } catch (Exception e) {
            add_owner_response.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    protected void onSearchUpdateOwnerButtonClick(ActionEvent event) {
        try {
            Owner owner = db.getOwnerById(update_owner_id.getText());
            if (owner == null) throw new Exception("Dono não encontrado");
            update_owner_name.setText(owner.getName());
            update_owner_age.setText(String.valueOf(owner.getAge()));
            update_owner_height.setText(String.valueOf(owner.getHeight()));
            update_owner_weight.setText(String.valueOf(owner.getWeight()));
        } catch (Exception e) {
            update_owner_response.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    protected void onUpdateOwnerButtonClick(ActionEvent event) {
        try {
            Owner owner = new Owner(update_owner_name.getText(), Integer.parseInt(update_owner_age.getText()),
                    Double.parseDouble(update_owner_height.getText()), Double.parseDouble(update_owner_weight.getText()),
                    update_owner_id.getText());
            db.updateOwnerById(owner.getId(), owner);
            update_owner_response.setText("Dono atualizado com sucesso (id: " + owner.getId() + ")");
            update_owner_id.setText("");
            update_owner_name.setText("");
            update_owner_age.setText("");
            update_owner_height.setText("");
            update_owner_weight.setText("");
        } catch (Exception e) {
            update_owner_response.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    protected void onSearchDeleteOwnerButtonClick(ActionEvent event) {
        try {
            Owner owner = db.getOwnerById(delete_owner_id.getText());
            if (owner == null) throw new Exception("Dono não encontrado");
            delete_owner_name.setText(owner.getName());
            delete_owner_age.setText(String.valueOf(owner.getAge()));
            delete_owner_height.setText(String.valueOf(owner.getHeight()));
            delete_owner_weight.setText(String.valueOf(owner.getWeight()));
        } catch (Exception e) {
            delete_owner_response.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    protected void onDeleteOwnerButtonClick(ActionEvent event) {
        try {
            db.deleteOwnerById(delete_owner_id.getText());
            delete_owner_response.setText("Dono excluido com sucesso (id: " + delete_owner_id.getText() + ")");
            delete_owner_id.setText("");
            delete_owner_name.setText("");
            delete_owner_age.setText("");
            delete_owner_height.setText("");
            delete_owner_weight.setText("");
        } catch (Exception e) {
            delete_owner_response.setText("Erro: " + e.getMessage());
        }
    }
}