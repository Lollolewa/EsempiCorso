/*

    Voglio creare una classe player per rappresentare un gioco i cui vari personaggi Fantasy
    possono combattere tra di loro.
    Il player ha un nome e cognome che sono quelli del giocatore, il nome del personaggio, password, boolean isLogged, data d'iscrizione al gioco.
    La classe player ha i metodi login(nome personaggio, password) stampa e basta, logout().
    la classe è estesa dalla classe character, getCharacterClass(), int forza, int intelligenza, int carisma, int agilità, int punti vita);
    altre classi che estendono character: Paladin, Mage, Amazon, Barbarian, Rogue
    character avra i seguenti metodi:
    attack(character); metodo astratto
    defendFrom(character); metodo astratto
    flee(); interrompe combattimento probabilmente concreto

    ogni classe attacca a modo suo

    alcune classi avranno metodi loro, paladin avrà metodo heal() che gli permetterà di recuperare punti vita, mage avrà throwFireball(); Amazon castrate(), Barbarian berserk() aumenta il danno ma impedisce di difendersi, rogue ha steal()
    combattimento è un while che continua finchè tutti e due sono vivi e nessuno scappa, durante ogni ciclo il giocatore può fare due azioni, che normalmentep otrebbero essere attacca o difendi o a discrezione una delle abilità
    questo è tra due character, sarebbe la funzione fight(), l'abilità ha possibilità di essere chiamata una volta su 5 turni magari

*/

package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Scanner;

public class Player {

    protected String nome, cognome, nomePersonaggio, password;
    protected LocalDate dataIscrizione;
    protected boolean isLogged, isDead;
    Scanner sc = new Scanner(System.in);

    public Player(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, boolean isDead){
        this.nome = nome;
        this.cognome = cognome;
        this.nomePersonaggio = nomePersonaggio;
        this.password = password;
        this.dataIscrizione = dataIscrizione;
        this.isLogged = isLogged;
        this.isDead = isDead;

    }

    public static String login(String nomePersonaggio, String password){
        System.out.println("Inserisci: ");
        String nome = sc.nextLine();
        String password = sc.nextLine();
        if(nomePersonaggio == this.nomePersonaggio && password == this.password) {
            this.isLogged = true;
            return "LOGIN ESEGUITO";
        }
        this.isLogged = false;
        return "LOGIN NON EFFETTUATO";
    }

    public static void logout(){
        if(this.isLogged){
            this.isLogged = false;
            return "LOGOUT EFFETTUATO";
        }
        return "NON SEI LOGGATO";
    }



}
