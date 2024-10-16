package org.generation.italy.esempiCorso.inheritance.menu;

public class DishManagement {
    public static void main(String[] args) {

        Dish carbonara = new Dish("carbonara", 30, 15, 6, 12);
        Dish tartare = new Dish("tartare", 17, 16, 3, 14);
        Dish tiramisu = new Dish("tiramisu", 22, 15, 16, 15);

        System.out.println(carbonara.toString());
        System.out.println(tartare.toString());
        System.out.println(tiramisu.toString());
        System.out.println("Il prezzo totale della cena: " + getPrice(carbonara, tartare, tiramisu));
        System.out.println("Kcal totali del menu: " + getCalories(carbonara, tartare, tiramisu));
    }

    public static int getPrice(Dish carbonara, Dish amatriciana, Dish cacioPepe){
        return carbonara.getPrice() + amatriciana.getPrice() + cacioPepe.getPrice();
    }

    public static int getCalories(Dish carbonara, Dish amatriciana, Dish cacioPepe){
        return carbonara.getTotCalories() + amatriciana.getTotCalories() + cacioPepe.getTotCalories();
    }


}
