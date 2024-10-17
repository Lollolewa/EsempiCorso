package org.generation.italy.esempiCorso.interfaces.explanation;

public class Circle {
    private double radius;
    //variabile statica = dipende dalla classe, non dagli oggetti,
    //.esiste una sola variabile radius
     private final static double maxRadius=1000;
     private static int counter = 0;

    public Circle(double radius) {
        if(radius>1000){
            this.radius = maxRadius;
        }else {
            this.radius = radius;
        }
        counter++;
    }

    public Circle(){
        this.radius = Math.random()*maxRadius;
       // Math m1 = new Math();
       // Math m2 = new Math();
       // double r = m1.sin(10);
       // double r2 = m2.sin(10);
        double x = Math.sin(20);
    }


    public double calculatePerimeter(){
        return 2*radius*Math.PI;
    }

    public static void main (String[] args){
        //Circle c = new Circle(10);
        //c.radius = 20;
        //System.out.println(c.calculatePerimeter());
        //Circle.radius = 10; //nomeClasse.nomeVariabile
        //calculatePerimeter();
        Circle c1 = new Circle(50);
        Circle c2 = new Circle(100);
        System.out.println(c1.radius);
        System.out.println(c1.calculatePerimeter());

    }
}
