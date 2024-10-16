package org.generation.italy.esempiCorso.inheritance.menu;

public class MenuManagement {
    public static void main(String[] args) {

        Dish carbonara = new Dish("carbonara", 30, 15, 6, 12);
        Dish tartare = new Dish("tartare", 17, 16, 3, 14);
        Dish tiramisu = new Dish("tiramisu", 22, 15, 16, 15);

        Menu menu = new Menu(carbonara, tartare, tiramisu);

        System.out.println(menu.toString());
    }
}
