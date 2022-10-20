package com.example.trab2gui.dao;

import com.example.trab2gui.models.Owner;
import com.example.trab2gui.models.Pet;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.bson.Document;

import java.util.Iterator;

public class DataAccess {
    private final MongoCollection<Document> petCollection;
    private MongoCollection<Document> ownerCollection;

    public DataAccess() throws Exception {
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://criadin:123@clusterdecriado.l70wtoe.mongodb.net/test"));
            MongoDatabase db = mongoClient.getDatabase("trab");
            this.petCollection = db.getCollection("pets");
            this.ownerCollection = db.getCollection("owners");
        } catch (MongoException mongoException) {
            System.err.println(mongoException.getMessage());
            throw new Exception(mongoException.getMessage());
        }
    }

    public Pet getPetById(String id) {
        Document document = this.petCollection.find(new BasicDBObject("id", id)).first();
        if (document == null) return null;
        return new Pet(document);
    }
    public ObservableList<Pet> getAllPets() {
        MongoCursor<Document> cursor = this.petCollection.find().iterator();
        ObservableList<Pet> pets = FXCollections.observableArrayList();
        while(cursor.hasNext()) {
            pets.add(new Pet(cursor.next()));
        }
        return pets;
    }

    public void addPet(Pet pet) {
        this.petCollection.insertOne(pet.getDocument());
    }

    public void updatePetById(String id, Pet pet) {
        // TODO: Método de atualizar Pet pelo id
    }

    public void deletePetById(String id) {
        // TODO: Método de deletar Pet pelo id
    }

    public Owner getOwnerById(String id) {
        Document document = this.ownerCollection.find(new BasicDBObject("id", id)).first();
        if (document == null) return null;
        return new Owner(document);
    }

    public ObservableList<Owner> getAllOwners() {
        MongoCursor<Document> cursor = this.ownerCollection.find().iterator();
        ObservableList<Owner> owners = FXCollections.observableArrayList();
        while(cursor.hasNext()) {
            owners.add(new Owner(cursor.next()));
        }
        return owners;
    }

    public void addOwner(Owner owner) {
        this.ownerCollection.insertOne(owner.getDocument());
    }

    public void updateOwnerById(String id, Owner owner) {
        // TODO: Método de atualizar Owner pelo id
    }

    public void deleteOwnerById(String id) {
        // TODO: Método de deletar Owner pelo id
    }


}
