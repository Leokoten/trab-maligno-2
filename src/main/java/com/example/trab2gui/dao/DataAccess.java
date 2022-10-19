package com.example.trab2gui.dao;

import com.example.trab2gui.models.Pet;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

    public void addPet(Pet pet) {
        this.petCollection.insertOne(pet.getDocument());
    }
}
