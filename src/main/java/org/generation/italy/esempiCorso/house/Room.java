package org.generation.italy.esempiCorso.house;

public class Room {

    protected String type;
    protected int side1, side2;

    public Room(String type, int side1, int side2) {

        this.type = type;
        this.side1 = side1;
        this.side2 = side2;

    }

    public int calculateArea() {
        return side1 * side2;
    }

    public String toString(){
        return type + ": " + side1 + " x " + side2 + "= " + calculateArea() + "mq";
    }
}
