package org.generation.italy.esempiCorso.inheritance.exercise;


import java.time.LocalDate;
import java.util.Scanner;

;
public class Player {
    private String nome, cognome, nomePersonaggio,password;
    protected LocalDate dataInizio;
    protected boolean isLogged;
    Scanner sc = new Scanner(System.in);

    public Player(boolean isLogged, LocalDate dataInizio, String password, String nomePersonaggio, String nome, String cognome){
        this.isLogged = false;
        this.dataInizio = dataInizio;
        this.password = password;
        this.nomePersonaggio = nomePersonaggio;
        this.cognome = cognome;
        this.nome = nome;
    }
    public void login(String nomePersonaggio, String password){
        System.out.println("Benvenuto nel gioco, inserisci username.");
        String username = sc.nextLine();
        System.out.println("Perfetto, inserisci la password.");
        String key = sc.nextLine();
        if(username.equals(nomePersonaggio) && key.equals(password)){
            System.out.println("Login effettuato con successo");
            isLogged = true;
        }
        else {
            System.out.println("nome personaggio o password errati");
        }

    }
    /*
    voglio creare una classe player per rappresentare un gioco in cui vari personaggi Fantasy
    possono combattere tra loro. Il player ha un nome e cognome che sono quelli del giocatore,
    nome del personaggio, password, data in cui ha iniziato a giocare, variabile booleana isLogged
    metodi login / logout
    login riceve nome del personaggio e password e restituisce se sei loggato o no (stampa e basta)
    logout imposta isLogged a false e stampa il messaggio
    viene estesa da una classe Character (personaggi)
    metodo getCharacterClass che restituisce la professione del personaggio
    interi che rappresentano le caratteristiche(forza, intelligenza, carisma, agilità, punti vita)
    il character avrà i seguenti metodi:
    abstract attacca(character x)
    abstract difendi(character y) può dipendere da chi ti sta attaccando
    scappa interrompe combattimento
    altre classi che estendono character e che avranno propri metodi
    -Paladin metodo heal recupera punti ferita
    -Mage metodo throw fireball
    -Amazon metodo castrate
    -Barbarian metodo berserk aumenta il danno ma impedisce di difendersi
    -Rogue metodo steal permette di rubare armi all'avversario
    ogni classe attacca e difende in maniera diversa

    main= crea alcuni personaggi e li fa combattere tra di loro
    il combattimento funziona cosi:
    ciclo while che va avanti finchè un giocatore muore o scappa
    durante il ciclo ogni giocatore può fare due azioni (Attacca, ognuno col proprio metodo e difendi)
    fight ( Character c1, Character c2) //w polimorfismo
    modificando le cose deve essere possibile che durante il ciclo una volta su 5 il character usa l'abilità speciale



     */

}
