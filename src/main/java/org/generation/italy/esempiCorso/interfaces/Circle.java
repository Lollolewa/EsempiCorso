package org.generation.italy.esempiCorso.interfaces;

public class Circle {

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double calculatePerimeter(){
        return 2*radius*Math.PI;
    }

    public static void main(String[] args) {

        Circle circle = new Circle(20);
        circle.radius = 10;

        System.out.println(circle.calculatePerimeter());
    }
}
