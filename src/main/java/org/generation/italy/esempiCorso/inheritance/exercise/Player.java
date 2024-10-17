package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Player {
    protected String nome, cognome, nomePersonaggio, password;
    protected LocalDate dataInizio;
    protected boolean isLogged;
    protected Character character;

    public Player(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataInizio, boolean isLogged) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomePersonaggio = nomePersonaggio;
        this.password = password;
        this.dataInizio = dataInizio;
        this.isLogged = isLogged;
    }
    public void login(String nomePersonaggio, String password){
        if(this.nomePersonaggio.equalsIgnoreCase(nomePersonaggio) && this.password.equalsIgnoreCase(password)){
            isLogged = true;
            System.out.println(" Login effettuato con successo: ");
        }
        else {
            System.out.println(" Nome pg o password errati");
        }
    }
    public void logout(){
        isLogged = false;
        System.out.println("Logout effettuato");
    }
    public void setCharacter(Character character) {
        this.character = character;
        System.out.println(character.getName() + " è stato assegnato a " + name + " " + cognome);
    }

    public Character getCharacter() {
        return character;
    }
    public void setCharacter(Character character) {
        this.character = character;
        System.out.println(character.getName() + " è stato assegnato a " + name + " " + cognome);
        this.character = character.getName();
    }
    //public void setCharacter(Character character) {
       // this.character = character;
        //System.out.println(character.getName() + " è stato assegnato a " + nome + " " + cognome);
    //}

}
