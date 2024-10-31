package org.generation.italy.libreria;

import java.util.ArrayList;

public class Inventario {
    ArrayList<Libro> collection = new ArrayList<Libro>();

    public void aggiungiLibro(Libro libro){
        collection.add(libro);
    }

    public void visualizzaCollection() {
        for(int i=0;  i<collection.size(); i++){
            System.out.println(collection.get(i));
        }
    }
}


/*Crea una classe Inventario:

Usa un array o un ArrayList per memorizzare i libri.
Metodi per:
Aggiungere un libro.
Visualizzare tutti i libri nell'inventario.*/