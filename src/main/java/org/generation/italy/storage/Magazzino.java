package org.generation.italy.storage;

import java.util.ArrayList;

public class Magazzino {
    ArrayList<Prodotto> product = new ArrayList<>();
    public void aggiungiProdotto(Prodotto prodotto){
        product.add(prodotto);
    }
    public void visualizzaProdotti() {
        for (Prodotto prodotto : product) {
            System.out.println(prodotto);
        }
    }
    public Prodotto cercaProdotto(String nome){
         for(Prodotto prodotto : product){
             if(prodotto.getName().equals(nome)){
                 return prodotto;
             }
         }
        return null;
    }
}
/*Classe Magazzino:

Attributo: ArrayList<Prodotto> prodotti per memorizzare i prodotti.
Metodi:
aggiungiProdotto(Prodotto prodotto): per aggiungere un prodotto al magazzino.
visualizzaProdotti(): per visualizzare tutti i prodotti presenti nel magazzino.
cercaProdotto(String nome): per cercare un prodotto per nome e restituire i dettagli del prodotto, se trovato.*/