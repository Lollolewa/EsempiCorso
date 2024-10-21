package org.generation.italy.esempiCorso.exceptions;

public class Persona {
    private String nome;
    private int eta;

    // Costruttore
    public Persona(String nome, int eta) {
        if (eta < 0) {
            throw new IllegalArgumentException("L'età non può essere negativa!"); // throw exception a runtime se l'età è negativa'
        }
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    // Metodo principale
    public static void main(String[] args) {
        try {
            Persona persona1 = new Persona("Mario", 25); // Valido
            Persona persona2 = new Persona("Luigi", 5); // Questo causerà un'eccezione
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

