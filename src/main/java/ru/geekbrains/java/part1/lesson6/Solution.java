package ru.geekbrains.java.part1.lesson6;

public class Solution {

    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik");
        barsik.run(400);
        barsik.swim(3.3);
        barsik.run(100);
        barsik.jump(1);

        Dog bobik = new Dog("Bobik");
        bobik.run(300);
        bobik.swim(16);
        bobik.jump(0.21);
    }
}
