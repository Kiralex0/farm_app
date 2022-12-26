package org.example.ui;

import org.example.Info;
import org.example.model.Animal;
import org.example.model.Farm;
import org.example.model.enam.AnimalType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    private Farm farm;

    public UI(Farm farm) {
        this.farm = farm;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("1 - добавить новое животное");
            System.out.println("2 - вывести всех животных");
            System.out.println("3 - удалить животное с фермы");
            System.out.println("4 - вывести определенный тип животного");
            System.out.println("5 - сохранить данные");
            System.out.println("9 - загрузить животных из файла");

            System.out.println("введите вашу команд");
            String command = reader.readLine();
            while (!command.equals("вых")) {
                switch (command) {
                    case "1":
                        System.out.println("введите тип животного");
                        AnimalType type = getAnimalType(reader.readLine());
                        System.out.println("введите возраст животного");
                        int age = Integer.parseInt(reader.readLine());
                        System.out.println("введите имя животного");
                        String name = reader.readLine();

                        Animal animal = new Animal(type, age, name);
                        farm.addAnimalToFarm(animal);
                        break;

                    case "2":
                        farm.printAllAnimals(farm.getAnimals());
                        break;

                    case "3":
                        System.out.println("введите имя животного, которое хотите удалить");
                        farm.animalDelete(reader.readLine());
                        break;

                    case "4":
                        System.out.println("введите тип животных, которых хотите найти");
                        farm.printAllAnimals(farm.getAnimalsByType(reader.readLine()));
                        break;

                    case "5":
                        System.out.println("сохраните программу");
                        farm.safe(Info.SAFE_FILE);
                        break;

                    case  "9":
                        farm.setAnimals(Farm.loadingList(Info.SAFE_FILE));
                        System.out.println("загрузка завершена");
                        break;
                }
                System.out.println("введите вашу команду");
                command = reader.readLine();
            }
        }
    }

    private AnimalType getAnimalType(String string) {
        switch (string) {
            case "Свинья":
                return AnimalType.PIG;
            case "Корова":
                return AnimalType.COW;
            case "Курица":
                return AnimalType.CHICKEN;
            default:
                return AnimalType.TRANSFORMER;
        }
    }

    private String inputFromKeyBoard() throws IOException {
        BufferedReader bufferedReader = null;
        String string = "";
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            string = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("не удалось прочитать");
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return string;
    }
}

