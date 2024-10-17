package org.generation.italy.esempiCorso.inheritance.example.interfaces;

public class Circle {
    private static double radius;
    //la variabile raggio ora dipende dalla classe e non dagli oggetti
    //esiste una sola variabile radius;
    private final double maxRadius = 1000;

    public Circle(double radius) {
        if (radius > 1000) {
            this.radius = radius;
        } else {
            this.radius = radius;
        }
    }

    public double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }


    public static void main(String[] args) {
        //Circle c = new Circle(10);
        //c.radius = 10;
        //System.out.println(c.calculatePerimeter());

        //Circle.radius = 10;
        //Circle.calculatePerimeter();
        //nome classe più variabile
        //variabile statica ne esiste solo una
        //static = è una variabile che appartiene alla classe
        Circle circle = new Circle(50);


    }
}