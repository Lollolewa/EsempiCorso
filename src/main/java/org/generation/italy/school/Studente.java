package org.generation.italy.school;

import java.util.ArrayList;

public class Studente {
    private String nome,surname;
    ArrayList<Integer> voti = new ArrayList<>();

    public Studente(String nome, String surname) {
        this.nome = nome;
        this.surname = surname;
        this.voti = new ArrayList<>();
    }
    public void aggiungiVoto(int voto){
        voti.add(voto);
    }
    public double calcolaMedia(){
        int somma = 0;
        int voto= 0;
        for(int i = 0; i<voti.size(); i++) {
            somma += voti.get(i);
        }
        return (double) somma / voti.size();
    }
    @Override
    public String toString() {
        return nome;
    }
    public String getNome() {
        return nome;
    }
    public String getSurname(){
        return surname;
    }
}
/*Crea una classe Studente:

Attributi: nome (String) e voti (ArrayList<Integer>).
Un costruttore per inizializzare questi attributi.
Un metodo per aggiungere un voto.
Un metodo per calcolare la media dei voti.*/