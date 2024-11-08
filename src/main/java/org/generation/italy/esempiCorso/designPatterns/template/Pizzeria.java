package org.generation.italy.esempiCorso.designPatterns.template;

public class Pizzeria {
    public static void main(String[] args) {
        PizzaChef pz = new PizzaQuattroStagioniChef();
        Pizza p1 = pz.cookPizza();
        System.out.println(p1);
        PizzaChef pz1 = new PizzaMarinaraChef();
        Pizza p2 = pz1.cookPizza();
        System.out.println(p2);
    }
}
