package org.generation.italy.examples.interfaces;

public class Circle {
    private static double radius;
    private final static double maxRadius = 1000;
    private static int  counter = 0;
    public Circle( double radius){
        if(radius>1000){
            this.radius = maxRadius;
        }else {
            this.radius = radius;
        }
        counter++;
    }
    public Circle(){
        this.radius = Math.random()*maxRadius;
        // random metodo statico della classe Math
    }
    //metodo normale si invoca in un contesto normale, mentro il metodo statico all'interno della classe.
    // variabile statica = dipende dalla classe, non dagli oggetti.
    // esiste una sola variabile radius
    // variabile statica appartiene direttamente alla classe e ne esiste 1 sola copia.
    // classe di utilita sono contenitori di metodi che non so dove mettere
    public double calculatePerimeter(){
        return 2*this.radius*Math.PI;
    }
    public static void main(String[] args){
//        Circle c = new Circle(10);
//        c.radius = 20;
//        System.out.println(c.calculatePerimeter());
        Circle.radius = 10;

    }
    // non esiste nessun raggio se non creo oggetti di classe Circle.
}
