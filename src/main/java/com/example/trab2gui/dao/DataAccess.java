package com.example.trab2gui.dao;

import com.example.trab2gui.models.Owner;
import com.example.trab2gui.models.Pet;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.bson.Document;

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
        Document document = this.petCollection.find(new Document("id", id)).first();
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
        this.petCollection.updateOne(new Document("id", id), new Document("$set", pet.getDocument()));
    }

    public void deletePetById(String id) throws Exception {
        DeleteResult deleted = this.petCollection.deleteOne(new Document("id", id));
        if (deleted.getDeletedCount() == 0) throw new Exception("Não foi deletado nenhum pet");
        if (deleted.getDeletedCount() > 1) throw new Exception("Foram deletados mais de um pet com o id " + id);
    }

    public Owner getOwnerById(String id) {
        Document document = this.ownerCollection.find(new Document("id", id)).first();
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
        this.ownerCollection.updateOne(new Document("id", id), new Document("$set", owner.getDocument()));
    }

    public void deleteOwnerById(String id) throws Exception {
        DeleteResult deleted = this.ownerCollection.deleteOne(new Document("id", id));
        if (deleted.getDeletedCount() == 0) throw new Exception("Não foi deletado nenhum Dono");
        if (deleted.getDeletedCount() > 1) throw new Exception("Foram deletados mais de um Dono com o id " + id);
    }


}
