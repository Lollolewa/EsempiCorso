package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Player {
    protected String name, surname, userName, password;
    protected boolean isLogged;
    protected LocalDate startDate;

    public Player(String name, String surname, String userName, String password, boolean isLogged, LocalDate startDate) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
        this.isLogged = isLogged;
        this.startDate = startDate;
    }

    public boolean login(String userName, String password){
        if (this.userName.equals(userName) && this.password.equals(password)){
            isLogged = true;
        }
    }
    public void logout(){

    }
}
// Voglio rappresentare un gioco testuale in cui vari personaggi di un mondo fantasy possano combattere tra di loro
// Il player è un'entità che ha un nome e cognome (li stessi del giocatore), poi un nome del personaggio,una password,
// booleano che dice se sia loggato o meno ed una data di quando il player ha cominciato a giocare

// La classe salva anche la data dalla quale il player ha cominciato a giocare
// La classe ha un metodo login ed uno logout;
// login prende in input nome e password e restituisce se sia loggato o meno
// logout che setta il booleano false

// La classe player viene estesa da una classe Character
// La classe char avrà interi per Punti vita, Forza, Intelligenza, Carisma, Agilità
// ed un metodo professione: getCharacterClass, che restituisce la professione del personaggio
// Il character avrà i metodi Attacca che prende in input un character(
// ed uno Difendi che prende in input un character (quello che mi sta attaccando)
// e Scappa che interrompe il combattimento

// Altri classi che estendono Character: Paladin, Mage, Amazon, Barbarian, Rogue
// Alcune di queste classi avrà metodi loro:
// Paladin ha il metodo heal che gli permette di recuperare punti vita
// Mage avrà throw fireball
// Amazon avrà castrate
// Barbarian avrà berserk che gli boosta le stat
// rogue avrà steal che permette di rubare armi dell'avversario

// Il programma fa combattere i personaggi
// Funziona così; fight: metodo che prende in input 2 Character,
// ciclo while che va avanti finchè un giocatore muore o scappa
// durante il ciclo ogni giocatore può fare 2 azione (attacca o difendi)
// 1 iterazione su 5 il character può usare la sua abilità speciale


// Ogni personaggio partirà da una base di stats in base al suo tipo ovviamente, tutti avranno la stessa somma di punti
// base, poi avranno n punti che inserirà l'utente con uno scanner da scegliersi con eventuali robe in più.

// d20; da 1 a 5 scazzi tutto, da 6 a 15 fai l'attacco normale o la difesa normale, da 16 a 20 final

// Character avrà anche un sesso