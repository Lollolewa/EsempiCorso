package org.generation.italy.esempiCorso.interfaces;

public class Circle {
    private static double radius; // varibiale statica: della classe, non degli oggetti
    private static final double maxRadius = 1000;
    public Circle(double radius){
        if (radius > 1000){
            this.radius = maxRadius;
        } else {
            this.radius = radius;
        }
    }
    public double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }

    public static void main (String[] args) {
        radius = 10;
        Circle.radius = 15;
    }
}
