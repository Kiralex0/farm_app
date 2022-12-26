package org.example.model;

import org.example.model.enam.AnimalType;

import java.io.Serializable;

public class Animal implements Serializable {

    private AnimalType type;
    private int age;
    private String name;

    public Animal(AnimalType type, int age, String name) {
        this.type = type;
        this.age = age;
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "тип: " + type.getName() + "; " + "имя: " + name + "; " + "лет: " + age;
    }
}
