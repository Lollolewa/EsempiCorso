package org.generation.italy.esempiCorso.designPatterns;

public class Pizzeria {
    public static void main(String[] args) {
        PizzaChef pz = new PizzaQuattroStagioniChef();
        Pizza p1 = pz.cookPizza();
        System.out.println(p1);
        System.out.println("""
                ---------------------------------------------------""");

        PizzaChef pz2 = new PizzaMarinaraChef();
        Pizza p2 = pz2.cookPizza();
        System.out.println(p2);
    }
}
