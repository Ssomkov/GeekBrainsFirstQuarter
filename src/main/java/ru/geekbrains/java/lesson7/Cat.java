package ru.geekbrains.java.lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean isReplete;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (!isReplete) {
            if (plate.getFood() >= appetite) {
                plate.decreaseFood(appetite);
                isReplete = true;
                System.out.printf("Cat '%s' grabbed a piece '%d' from the plate%n", name, appetite);
            } else {
                System.out.printf("Cat '%s' couldn't grabb a piece '%d' from the plate%n", name, appetite);
            }
        } else {
            System.out.printf("Cat '%s' isn't hungry%n", name);
        }
    }

}
