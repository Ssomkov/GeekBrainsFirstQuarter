package ru.geekbrains.java.part1.lesson7;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Plate plate = new Plate(75);

        Cat barsik = new Cat("Barsik", 15);
        Cat bublik = new Cat("Bublik", 4);
        Cat milan = new Cat("Milan", 32);
        Cat orange = new Cat("Orange", 20);
        Cat marusia = new Cat("Marusia", 10);

        ArrayList<Cat> cats = new ArrayList<>(Arrays.asList(barsik, bublik, milan, orange, marusia));

        //check hungry cats
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            plate.info();
        }
        //check repelete cat
        plate.increaseFood(30);
        plate.info();
        orange.eat(plate);
        plate.info();
    }
}
