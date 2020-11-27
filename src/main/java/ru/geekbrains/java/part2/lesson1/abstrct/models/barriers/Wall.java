package ru.geekbrains.java.part2.lesson1.abstrct.models.barriers;

import ru.geekbrains.java.part2.lesson1.abstrct.AbstractBarrier;
import ru.geekbrains.java.part2.lesson1.abstrct.Barrier;
import ru.geekbrains.java.part2.lesson1.abstrct.Movable;

public class Wall extends AbstractBarrier implements Barrier {

    private int height;

    public Wall(String name, int height) {
        super(name);
        this.height = height;
    }

    @Override
    public boolean isPassed(Movable movable) {
        boolean res = movable.getJumpLimit() > height;
        if (res) {
            System.out.printf("Attendee '%s' with name '%s' jumped the wall '%s' with height '%d'%n",
                    movable.getClass().getSimpleName(), movable.getName(), getName(), getHeight());
        } else {
            System.out.printf("Attendee '%s' with name '%s' couldn't jump the wall '%s' with height '%d'%n",
                    movable.getClass().getSimpleName(), movable.getName(), getName(), getHeight());
        }
        return res;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
