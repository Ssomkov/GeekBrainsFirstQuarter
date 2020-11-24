package ru.geekbrains.java.lesson8.model;

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

    public void increaseFood(int food) {
        if (food > 0) {
            this.food += food;
        }
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }
}
