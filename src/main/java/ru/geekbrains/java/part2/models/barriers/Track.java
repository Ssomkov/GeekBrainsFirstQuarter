package ru.geekbrains.java.part2.models.barriers;

import ru.geekbrains.java.part2.abstrct.AbstractBarrier;
import ru.geekbrains.java.part2.abstrct.Barrier;
import ru.geekbrains.java.part2.abstrct.Movable;

public class Track extends AbstractBarrier implements Barrier {

    private int length;

    public Track(String name, int length) {
        super(name);
        this.length = length;
    }

    @Override
    public boolean isPassed(Movable movable) {
        boolean res = movable.getRunLimit() > length;
        if (res) {
            System.out.printf("Attendee '%s' with name '%s' ran the track '%s' with length '%d'%n",
                    movable.getClass().getSimpleName(), movable.getName(), getName(), getLength());
        } else {
            System.out.printf("Attendee '%s' with name '%s' couldn't run the track '%s' with length '%d'%n",
                    movable.getClass().getSimpleName(), movable.getName(), getName(), getLength());
        }
        return res;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
