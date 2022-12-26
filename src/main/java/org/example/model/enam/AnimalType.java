package org.example.model.enam;

public enum AnimalType {
    PIG("Свинья"), COW("Корова"), CHICKEN("Курица"), TRANSFORMER("такого животного не существует");
    private String name;

    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
