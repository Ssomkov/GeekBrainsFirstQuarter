package ru.geekbrains.java.lesson8.utils;

import ru.geekbrains.java.lesson8.model.Cat;
import ru.geekbrains.java.lesson8.model.Plate;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Handler {

    private ArrayList<Cat> catList;
    private Plate plate;

    public Handler() {
        catList = new ArrayList<>();
        plate = new Plate(0);
    }

    public void generateCats() {
        int catRatio = ThreadLocalRandom.current().nextInt(3, 9);
        ArrayList<Integer> appetiteList = new ArrayList<>();

        for (int i = 0; i < catRatio; i++) {
            appetiteList.add(ThreadLocalRandom.current().nextInt(1, 8) * 10);
        }

        for (int i = 0; i < catRatio; i++) {
            catList.add(new Cat(("Barsik" + i), appetiteList.get(i)));
        }
    }

    public void generateFood() {
        plate.setFood(ThreadLocalRandom.current().nextInt(10, 15) * 10);
    }

    public String goEat() {
        StringBuilder sb = new StringBuilder();
        if (!catList.isEmpty()) {
            for (Cat cat : catList) {
                sb.append(cat.eat(plate));
            }
        }
        return sb.toString();
    }

    public Cat getCat(String name) {
        for (Cat cat : catList) {
            if (cat.getName().equals(name)) return cat;
        }
        return null;
    }

    public ArrayList<Cat> getCatList() {
        return catList;
    }

    public Plate getPlate() {
        return plate;
    }
}
