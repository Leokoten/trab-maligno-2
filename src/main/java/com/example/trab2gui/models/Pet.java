package com.example.trab2gui.models;

import org.bson.Document;


public class Pet {
    private String id;
    private String name;
    private String type;
    private String breed;
    private String gender;
    private int age;
    private String owner;

    public Pet(String name, String type, String breed, String gender, int age, String owner) throws Exception {
        if (name == null || name.equals("")) throw new Exception("Nome do Pet null");
        if (type == null || type.equals("")) throw new Exception("Tipo do Pet null");
        if (breed == null || breed.equals("")) throw new Exception("Raça do Pet null");
        if (gender == null || gender.equals("")) throw new Exception("Gênero do Pet null");
        if (owner == null || owner.equals("")) throw new Exception("Dono do Pet null");

        if (age <= 0) throw new Exception("Idade inválida");
        if (!gender.equals("Fêmea") && !gender.equals("Macho")) throw new Exception("Gênero inválido");

        this.id = "pet-" + String.format("%09d", (int) (Math.random() * (1000000000)) +1);
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.equals("")) throw new Exception("Nome do Pet null");
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws Exception {
        if (type == null || type.equals("")) throw new Exception("Tipo do Pet null");
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) throws Exception {
        if (breed == null || breed.equals("")) throw new Exception("Raça do Pet null");
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws Exception {
        if (gender == null || gender.equals("")) throw new Exception("Gênero do Pet null");
        if (!gender.equals("Fêmea") && !gender.equals("Macho")) throw new Exception("Gênero inválido");
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age <= 0) throw new Exception("Idade inválida");
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) throws Exception {
        if (owner == null || owner.equals("")) throw new Exception("Dono do Pet null");
        this.owner = owner;
    }

    public Document getDocument() {
        return new Document("id", this.id)
                .append("name", this.name)
                .append("type", this.type)
                .append("breed", this.breed)
                .append("gender", this.gender)
                .append("age", this.age)
                .append("owner", this.owner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (age != pet.age) return false;
        if (!id.equals(pet.id)) return false;
        if (!name.equals(pet.name)) return false;
        if (!type.equals(pet.type)) return false;
        if (!breed.equals(pet.breed)) return false;
        if (!gender.equals(pet.gender)) return false;
        return owner.equals(pet.owner);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + breed.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age;
        result = 31 * result + owner.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", owner='" + owner + '\'' +
                '}';
    }
}
