package ru.geekbrains.java.part2.lesson1.abstrct;

import java.util.ArrayList;

public interface Movable {

    void check(ArrayList<Barrier> barriers);

    String getName();

    int getRunLimit();

    int getJumpLimit();
}
