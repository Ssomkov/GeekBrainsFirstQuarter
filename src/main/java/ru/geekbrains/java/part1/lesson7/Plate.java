package ru.geekbrains.java.part1.lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int food) {
        if (this.food >= food) {
            this.food -= food;
        }
    }

    public void info() {
        System.out.println("Plate contains: " + food);
    }

    public void increaseFood(int food) {
        if (food > 0) {
            this.food += food;
        }
    }

    public int getFood() {
        return food;
    }
}
