package ru.geekbrains.java.part2.lesson1.abstrct.models.runners;

import ru.geekbrains.java.part2.lesson1.abstrct.Barrier;
import ru.geekbrains.java.part2.lesson1.abstrct.Movable;

import java.util.ArrayList;

public class Man implements Movable{

    private String name;
    private int runLimit;
    private int jumpLimit;

    public Man(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void check(ArrayList<Barrier> barriers) {
        for (Barrier barrier : barriers) {
            if (!barrier.isPassed(this)) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

}
