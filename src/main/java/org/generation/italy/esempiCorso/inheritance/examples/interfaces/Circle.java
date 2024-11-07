package org.generation.italy.esempiCorso.inheritance.examples.interfaces;

public class Circle {
    private  static double radius;  //variabile statica dipende dalla classe e non dagli ogetti, e esisterà una sola variabile radius
    private static double maxRadius = 1000;
    private int counter = 0;
    public Circle (double radius){
        if(radius > 1000){
            this.radius = maxRadius;
        }else {
            this.radius = radius;
        }
        counter++;
    }

    public double calculatePerimeter(){
        return 2*radius*Math.PI;
    }
    public static void main (String[] args){
//        Circle c = new Circle(10);
//        c.radius = 20;
//        System.out.println(c.calculatePerimeter());
        Circle.radius = 10; //nomeClasse.nomeVariabile

    }
}
