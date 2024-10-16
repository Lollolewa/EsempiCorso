package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Fight {
    public static void main(String[] args){
        boolean muore, scappa;
        muore = false;
        scappa = false;
        Player player1 = new Player("Riccardo", "Rossi", "Lothar","Ciaociao", LocalDate.of(2022,12,25), true);
        Player player2 = new Player("Dario", "Verdi","Riku", "xdxd",LocalDate.of(2022,12,22), true);
        Character paladin = new Paladin("Lothar",35,25,20,30,250);
        Character mage1 = new Mage("Merlino",20,50 ,30,35,200);
        Character amazon1 = new Amazon("Boa",30,25,50,25,200);
        Character barbarian1 = new Barbarian("Kratos",50,20,25,30,200);
        Character rogue1 = new Rogue("Legolas",35,25,20,50,200);
        player1.login("Lothar","Ciaociao");

        // potremmo cambiare reference dell'oggetto a cui punta player1, da player passa a character

        while(!muore || !scappa){
            if()




        }





    }
}
