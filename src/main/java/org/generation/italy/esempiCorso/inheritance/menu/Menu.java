package org.generation.italy.esempiCorso.inheritance.menu;

public class Menu {

    private Dish firstCourse, secondCourse, dessert;

    public Menu(Dish firstCourse, Dish secondCourse, Dish dessert){

        this.firstCourse = firstCourse;
        this.secondCourse = secondCourse;
        this.dessert = dessert;
    }

    public int totalKcal(){
        return firstCourse.getTotCalories() +
                secondCourse.getTotCalories() +
                dessert.getTotCalories();
    }

    public int totalPrice(){
        return firstCourse.getPrice() +
                secondCourse.getPrice() +
                dessert.getPrice();
    }

    public String toString(){
        return firstCourse.toString() + "\n" +
        secondCourse.toString() + "\n" +
        dessert.toString() + "\n" +
        "Il prezzo totale della cena è " + totalPrice() + "€\n" +
        "Le calorie totali della cena sono: " + totalKcal();

    }


}
