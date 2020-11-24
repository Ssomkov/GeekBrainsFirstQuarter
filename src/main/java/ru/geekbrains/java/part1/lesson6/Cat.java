package ru.geekbrains.java.part1.lesson6;

public class Cat extends Animal {

    private static final double RUN_LIMIT = 200;
    private static final double JUMP_LIMIT = 2;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(double distance) {
        boolean isRunning = distance <= RUN_LIMIT;
        System.out.printf(isRunning ? "Cat '%s' ran the distance: %.2f%n" : "Cat '%s' didn't run the distance: %.2f%n",
                getName(), distance);
    }

    @Override
    public void swim(double distance) {
        System.out.printf("Cat '%s' can't swim%n", getName());
    }

    @Override
    public void jump(double height) {
        boolean isJumping = height <= JUMP_LIMIT;
        System.out.printf(isJumping ? "Cat '%s' jumped to a height of: %.2f%n" : "Cat '%s' didn't jump to a height of: %.2f%n",
                getName(), height);
    }
}
