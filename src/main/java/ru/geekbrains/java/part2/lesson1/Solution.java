package ru.geekbrains.java.part2.lesson1;

import ru.geekbrains.java.part2.lesson1.abstrct.Barrier;
import ru.geekbrains.java.part2.lesson1.abstrct.Movable;
import ru.geekbrains.java.part2.lesson1.models.barriers.Track;
import ru.geekbrains.java.part2.lesson1.models.barriers.Wall;
import ru.geekbrains.java.part2.lesson1.models.runners.Cat;
import ru.geekbrains.java.part2.lesson1.models.runners.Man;
import ru.geekbrains.java.part2.lesson1.models.runners.Robot;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        ArrayList<Movable> runners = new ArrayList<>();
        runners.add(new Robot("Robo", 50, 50));
        runners.add(new Robot("Buba", 55, 5));
        runners.add(new Man("Petya", 30, 5));
        runners.add(new Man("Vasya", 35, 10));
        runners.add(new Cat("Barsik", 25, 15));

        ArrayList<Barrier> barriers = new ArrayList<>();
        barriers.add(new Track("Track number 1", 30));
        barriers.add(new Track("Track number 2", 20));
        barriers.add(new Wall("Wall number 1", 10));
        barriers.add(new Wall("Wall number 2", 5));


        for (Movable runner : runners) {
            runner.check(barriers);
        }
    }
}
