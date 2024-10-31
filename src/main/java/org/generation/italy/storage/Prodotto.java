package org.generation.italy.storage;

public class Prodotto {
    private String name;
    private double price;
    private int quantity;

    public Prodotto(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String toString(){
        return "prodotto : " + name + "\n" + "prezzo : "+ price + "\n" + "quantita' : " + quantity;
    }
    public void aggiungiQuantity(int quantity){
        this.quantity += quantity;
    }
    public void removeQuantity(int quantity){
        if(this.quantity>=quantity){
            this.quantity-=quantity;
        }else{
            System.out.println("quantita' insufficente per rimuovere");
        }
    }
    public String getName(){
        return name;
    }
}


/*classe prodotto
Attributi: nome, prezzo, quantità.
        Metodi:
Costruttore per inizializzare i campi.
toString() per visualizzare i dettagli del prodotto.
aggiungiQuantità(int quantità) per aumentare la quantità del prodotto.
rimuoviQuantità(int quantità) per diminuire la quantità del prodotto (assicurati che non diventi negativa).*/