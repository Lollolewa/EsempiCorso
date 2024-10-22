package org.generation.italy.esempiCorso.house;

public class HouseManagement {
    public static void main(String[] args) {

        Room r1 = new Room("Living Room", 6, 5);
        Room r2 = new Room("Bathroom", 5, 5);
        Room r3 = new Room("Bedroom", 4, 3);
        House h1 = new House("Villetta infestata", r1, r2, r3) ;

        System.out.println(h1.name + "\n" + r1.toString() + "\n" + r2.toString() + "\n" + r3.toString());
        System.out.println(h1.toString());

    }

}
