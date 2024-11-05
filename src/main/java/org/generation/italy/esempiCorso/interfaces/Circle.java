package org.generation.italy.esempiCorso.interfaces;

public class Circle {
    private double radius;
    //variabile statica dipende dalla classe, non dagli oggetti
    //esiste una sola variabile radius, non ha senso
    //private static double radius
    private static double maxRadius=1000;
    private int counter=0;
    //in questo modo la variabile dipende dall'oggetto, esistono n counter quanti n oggetti circle creati
    private static int counte=0;
    //nei metodi statici (che appartiene alla classe non agli oggetti) non hanno il puntatore this.

    public Circle(double radius){
        if(radius>1000){
            this.radius = maxRadius;
        } else{
            this.radius=radius;
        }
        counter++;

    }
    public double calculatePerimeter(){
        return 2*radius*Math.PI;
    }
    public static void main(String[] args){
        Circle c = new Circle(10);
        c.calculatePerimeter();
        //radius = 10;
        //calculatePerimeter();
        //non funziona perchè non è stato creato nessun cerchio, per cui il raggio di chi?
        //le funzioni devono esssere chiamate nel contesto dell'oggetto
    }
}
