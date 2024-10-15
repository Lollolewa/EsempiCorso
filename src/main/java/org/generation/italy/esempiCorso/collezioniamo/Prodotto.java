package org.generation.italy.esempiCorso.collezioniamo;

import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

class Prodotto {
    private String nome;
    private int costo;

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return String.format("Prodotto{nome='%s', costo=%d}", nome, costo);
    }
}