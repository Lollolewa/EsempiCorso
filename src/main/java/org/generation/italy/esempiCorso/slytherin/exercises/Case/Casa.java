package org.generation.italy.esempiCorso.slytherin.exercises.Case;

public abstract class Casa {
    protected int surface, roomNum;

    public Casa(int surface, int roomNum) {
        this.surface = surface;
        this.roomNum = roomNum;
    }

    public abstract int HouseValue();
}
