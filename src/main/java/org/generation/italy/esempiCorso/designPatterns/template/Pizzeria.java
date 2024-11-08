package org.generation.italy.esempiCorso.designPatterns.template;

public class Pizzeria {
    public static void main(String[] args) {
        PizzaChef pz1 = new PizzaQuattroStagioniChef();
        Pizza p1 = pz1.cookPizza();
        System.out.println(p1);

        PizzaChef pz2 = new PizzaMarinaraChef();
        Pizza p2 = pz2.cookPizza();
        System.out.println(p2);
    }
}
