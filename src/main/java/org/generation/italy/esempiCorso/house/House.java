package org.generation.italy.esempiCorso.house;

public class House {

    protected String name;
    protected Room livingRoom;
    protected Room bathRoom;
    protected Room bedRoom;

    public House(String name, Room livingRoom, Room bedRoom, Room bathRoom){

        this.name = name;
        this.livingRoom = livingRoom;
        this.bedRoom = bedRoom;
        this.bathRoom = bathRoom;
    }

    public int totalArea(){
        return livingRoom.calculateArea() + bathRoom.calculateArea() + bedRoom.calculateArea();
    }

    @Override
    public String toString(){
        return "Area totale: " + totalArea() + "mq";
    }
}

