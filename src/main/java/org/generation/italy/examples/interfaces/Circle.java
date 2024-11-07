package org.generation.italy.examples.interfaces;

public class Circle {
    private static double radius;
    //variabile statica = dipende dalla classe, non dagli oggetti,
    // eiste una sola variabile radius
}
public Circle(double radius) {
        this.radius = radius;
    }
public double calculatePerimeter() {
    return 2 * radius * Math.PI;
}