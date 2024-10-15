package org.generation.italy.esempiCorso.interfaces;

public class Circle {
    private double radius; 
    //private static double maxRadius = 1000; //variabile statica = dipende dalla classe, non dagli oggetti; esiste una sola variabile radius
                                            //spesso le variabili statiche sono anche delle costanti (final);
                                            //Per richiamare la variabile statica andremo a scrivere Cirlce.maxRadius
    private static double maxRadius = 1000;
    
    public Circle (double radius) {
        if (radius>1000) {
            this.radius = maxRadius;
        } else {
            this.radius = radius;
        }
    }

    public double calculatePerimeter() {
        return 2*radius*Math.PI;
    }

    public static void main(String[] args) {
        //radius = 10;
        //calculatePerimeter();  //così non può funzionare nè la variabile nè il metodo perchè non ho ancora creato l'oggetto;

        Circle circle = new Circle(10);
        circle.radius = 20;
        //circle.calculatePerimeter(); //non statico, ha bisogno del richiamo all'oggetto prima.

        System.out.println(circle.calculatePerimeter());
        System.out.println(Circle.maxRadius); //esempio sul richiamare la variabile statica

    }
}
