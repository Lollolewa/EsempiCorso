package org.generation.italy.esempiCorso.inheritance.game;

import org.generation.italy.esempiCorso.inheritance.game.bots.AmazonBot;
import org.generation.italy.esempiCorso.inheritance.game.bots.PaladinBot;
import org.generation.italy.esempiCorso.inheritance.game.characters.Barbarian;
import org.generation.italy.esempiCorso.inheritance.game.characters.Mage;
import org.generation.italy.esempiCorso.inheritance.game.characters.Paladin;
import org.generation.italy.esempiCorso.inheritance.game.bots.MageBot;

import java.time.LocalDate;
import java.util.Scanner;

public class Arcade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Character p1 = new Paladin("BobbyRocket", "Bobby", "Rocket", LocalDate.of(2020, 5, 2), "pippo");
        Character p2 = new Mage("tommynasa", "Tommy", "nasa", LocalDate.of(2020, 5, 2), "pippo");

        Bot bot1 = new PaladinBot();
        Bot bot2 = new MageBot();

        System.out.println("Seleziona chi su quale accaount voi accedere ed effettua il login:");
        System.out.println("1: BobbyRocket");
        System.out.println("2: tommynasa");
        int choiceP = sc.nextInt();
        Character player = (choiceP ==1) ? p1 : p2; //operazione ternaria per decidere su quale account loggare.
        player.login();
        System.out.println("Seleziona un nemico per combattere:");
        System.out.println("1: PaladinBot");
        System.out.println("2: MageBot");
        int choice = sc.nextInt();
        Bot enemy = (choice == 1) ? bot1 : bot2; //operazione ternario per scegliere chi combattere, in questo caso ok perchè sono solo 2 nemici fra cui scegliere, nel caso poi da vedere e implementare per dare più scelte.

        // Ciclo che permette che una volta scelto il giocatore e il nemico li fa combattere;
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n" + player.getCharacterClass() + " (Salute: " + player.getHp() + ") vs " + enemy.getBotClass() + " (Salute: " + enemy.getHp() + ")");
            System.out.println("Cosa vuoi fare? (1: Attacca, 2: Scappa, 3: Mossa finale)");

            int action = sc.nextInt();

            switch (action) { //con lo switch permettiamo di volta in volta di far scegliere al giocatore che mossa fare
                case 1: // Attacca
                    enemy.defend(player);
                    System.out.println(enemy.getBotClass() + " ha subito danno!");
                    break;

                case 2: // Scappa
                    System.out.println(player.getCharacterClass() + " scappa dal combattimento!");
                    sc.close();
                    return;

                case 3: // Mossa finale
                    System.out.println(player.getCharacterClass() + " usa una mossa finale!");
                    player.ultimate(enemy); // Assicurati di avere un metodo per la mossa finale
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

            // Controlla se il nemico è ancora in vita e nel caso lo sia il giocatore subisce l'attacco;
            if (enemy.isAlive()) {
                player.defend(enemy);
                System.out.println(player.getCharacterClass() + " ha subito danno!");
            }
        }

        // Verifica chi ha vinto
        if (!player.isAlive()) {
            System.out.println("Sei stato sconfitto!");
        } else {
            System.out.println("Hai vinto!");
        }

        sc.close();
    }
}
