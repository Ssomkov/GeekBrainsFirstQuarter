package ru.geekbrains.java.part2.lesson1.abstrct;

public abstract class AbstractBarrier {

    private String name;

    public AbstractBarrier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
