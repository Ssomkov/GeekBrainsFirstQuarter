package ru.geekbrains.java.lesson6;

public abstract class Animal {

    private String name;

    public abstract void run(double distance);

    public abstract void swim(double distance);

    public abstract void jump(double height);

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
