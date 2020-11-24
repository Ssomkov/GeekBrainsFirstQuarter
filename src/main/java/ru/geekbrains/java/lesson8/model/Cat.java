package ru.geekbrains.java.lesson8.model;

public class Cat {

    private String name;
    private int appetite;
    private boolean isReplete;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String eat(Plate plate) {
        if (!isReplete) {
            if (plate.getFood() >= appetite) {
                plate.decreaseFood(appetite);
                isReplete = true;
                return String.format("Cat '%s' grabbed a piece '%d' from the plate%n", name, appetite);
            } else {
                return String.format("Cat '%s' couldn't grabb a piece '%d' from the plate%n", name, appetite);
            }
        } else {
            return String.format("Cat '%s' isn't hungry%n", name);
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isReplete=" + isReplete +
                '}';
    }

    public String getName() {
        return name;
    }
}
