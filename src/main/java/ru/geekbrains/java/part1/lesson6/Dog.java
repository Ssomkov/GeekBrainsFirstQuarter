package ru.geekbrains.java.part1.lesson6;

import java.util.concurrent.ThreadLocalRandom;

public class Dog extends Animal {

    private int runLimit;
    private static final double JUMP_LIMIT = 0.5;
    private static final double SWIM_LIMIT = 10;

    public Dog(String name) {
        super(name);
        this.runLimit = getRandomRunLimit();
    }

    @Override
    public void run(double distance) {
        boolean isRunning = distance <= getRandomRunLimit();
        System.out.printf(isRunning ? "Dog '%s' ran the distance: %.2f. " : "Dog '%s' didn't run the distance: %.2f. ",
                getName(), distance);
        System.out.printf("Dog '%s' has run limit: %d%n", getName(), getRunLimit());
    }

    @Override
    public void swim(double distance) {
        boolean isSwimming = distance <= SWIM_LIMIT;
        System.out.printf(isSwimming ? "Dog '%s' swam the distance: %.2f%n" : "Cat '%s' didn't swim the distance: %.2f%n",
                getName(), distance);
    }

    @Override
    public void jump(double height) {
        boolean isJumping = height <= JUMP_LIMIT;
        System.out.printf(isJumping ? "Dog '%s' jumped to a height of: %.2f%n" : "Dog '%s' didn't jump to a height of: %.2f%n",
                getName(), height);
    }

    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    private int getRandomRunLimit() {
        int generatedRatio = ThreadLocalRandom.current().nextInt(1, 7);
        return generatedRatio * 100;
    }
}
