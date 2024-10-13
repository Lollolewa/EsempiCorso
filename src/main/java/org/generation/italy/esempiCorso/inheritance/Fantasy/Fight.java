package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Fight {
    public static void main(String[] args){
        Player player1 = new Player("Riccardo", "Rossi", "Lothar","Ciaociao", LocalDate.of(2022,12,25), true);
        Player player2 = new Player("Dario", "Verdi","Riku", "xdxd",LocalDate.of(2022,12,22), true);
        Character character1 = new Paladin(player1.nome,player1.cognome, player1.nomePersonaggio, player1.password,player1.dataInizio,player1.isLogged, false, false, 35,25,20,30,250," ", false);
        Character character2 = new Amazon(player2.nome,player2.cognome, player2.nomePersonaggio, player2.password,player2.dataInizio,player2.isLogged, false, false, 35,25,20,30,250," ", false);
        boolean isP1Logged = player1.login("Lothar","Ciaociao");
        boolean isP2Logged = player2.login("Riku","xdxd");
        delay();

        while(isP1Logged && isP2Logged && !character1.dies && !character2.dies && !character1.runsAway && !character2.runsAway){

            Random r = new Random();
            boolean rand_bool1 = ThreadLocalRandom.current().nextBoolean(); //booleano random
            if (rand_bool1) {
                character1.attaccoSpeciale(character2,character1);
            } else {
                character1.attaccalo(character2,character1);
            }
            delay();

            character2.difendimi(character2,character1);
            delay();

            character1.isDead();
            character2.isDead();
            delay();
            character1.hasWon(character1,character2);

            double randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            //System.out.println(randomNum);
            if (randomNum <= 2) { //20% di probabilità (2/10)
                character2.scappa();
                character1.hasWon(character1,character2);
                break;  //metto il break perchè altrimenti continua ad eseguire il resto del blocco di codice finchè non ricontrolla la condizione
            }
            boolean rand_bool2 = ThreadLocalRandom.current().nextBoolean(); //booleano random
            if (rand_bool2) {
                character2.attaccoSpeciale(character1,character2);
            } else {
                character2.attaccalo(character1,character2);
            }
            delay();

            character1.difendimi(character1,character2);
            delay();

            character1.isDead();
            character2.isDead();
            delay();
            character1.hasWon(character2,character1);

            double randomNum2 = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            //System.out.println(randomNum2);
            if (randomNum2 <= 2) { //20% di probabilità (2/10)
                character1.scappa();
                character2.hasWon(character2,character1);
            }
        }
        delay();
        player1.logout();
        player2.logout();
    }
    public static void delay () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
