package com.example.trab2gui.models;

import org.bson.Document;

public class Owner {
    private String id;
    private String name;
    private int age;
    private double height;
    private double weight;

    public Owner(String name, int age, double height, double weight) throws Exception {
        if (name == null || name.equals("")) throw new Exception("Nome do Dono vazio");

        if (age <= 0) throw new Exception("Idade inválida");
        if (height <= 0) throw new Exception("Altura inválida");
        if (weight <= 0) throw new Exception("Peso inválido");

        this.id = "o" + String.format("%09d", (int) (Math.random() * (1000000000)) +1);
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Owner(Document document) {
        this.id = (String) document.get("id");
        this.name = (String) document.get("name");
        this.age = (int) document.get("age");
        this.height = (double) document.get("height");
        this.weight = (double) document.get("weight");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.equals("")) throw new Exception("Nome do Dono vazio");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age <= 0) throw new Exception("Idade inválida");
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws Exception {
        if (height <= 0) throw new Exception("Altura inválida");
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws Exception {
        if (weight <= 0) throw new Exception("Peso inválido");
        this.weight = weight;
    }

    public Document getDocument() {
        return new Document("id", this.id)
                .append("name", this.name)
                .append("age", this.age)
                .append("height", this.height)
                .append("weight", this.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (age != owner.age) return false;
        if (Double.compare(owner.height, height) != 0) return false;
        if (Double.compare(owner.weight, weight) != 0) return false;
        if (!id.equals(owner.id)) return false;
        return name.equals(owner.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
