package org.example.model;

import org.example.model.Animal;
import org.example.model.enam.AnimalType;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Farm implements Serializable {
    private static final Long serialVersionUID = 1L;
    private List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
//        animals.add(new Animal(AnimalType.CHICKEN, 12, "Ганц"));
//        animals.add(new Animal(AnimalType.COW, 2, "Зубр"));
//        animals.add(new Animal(AnimalType.PIG, 1, "Дуня"));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < animals.size(); i++) {
            stringBuilder.append(animals.get(i) + "\n");
        }
        return stringBuilder.toString();
    }

    public void animalDelete(String name) {
        for (int i = 0; i < animals.size(); i++) {
            if (name.equals(animals.get(i).getName())) {
                System.out.println("животное " + animals.get(i) + " удалено");
                animals.remove(i);
            }
        }
    }

    public List<Animal> getAnimalsByType(String type) {
        List<Animal> animals1 = new LinkedList<>();
        for (int i = 0; i < animals.size(); i++) {
            if (type.equals(animals.get(i).getType().getName())) {
                animals1.add(animals.get(i));
            }
        }
        return animals1;
    }

    public void addAnimalToFarm(Animal animal) {
        animals.add(animal);
    }

    public void printAllAnimals(List<Animal> animals) {
        System.out.println("сейчас на ферме живет : " + animals.size() + " животных");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }

    public static List<Animal> loadingList(String link) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(link));
        List<Animal> animal = new ArrayList<>();
        while (stream.available() > 0) {
            Animal animal1 = (Animal) stream.readObject();
            System.out.println(animal1.toString());
            animal.add(animal1);
        }
        stream.close();
        return animal;
    }

    public void safe(String link) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(link));
        for (int i = 0; i < animals.size(); i++) {
            stream.writeObject(animals.get(i));
        }
        stream.close();
    }
}
