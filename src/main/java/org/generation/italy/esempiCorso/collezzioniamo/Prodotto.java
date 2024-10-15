package org.generation.italy.esempiCorso.collezzioniamo;

public class Prodotto {
    String descrizione;
    int prezzo;

    public Prodotto(String descrizione, int prezzo) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }


    /**
     * questa sintassi la usiamo per creare dei commetni che, una volta richiamato il metodo di una funzione di una classe
     * possiamo leggere nello specifico quello che va;
     */
    public int inutile() {
        return 0;
    }
    @Override
    public boolean equals(Object o){
        if(o==null || o.getClass()!= Prodotto.class){// la prima condizione serve per vedere che l'oggetto che passo sia della stessa classe e non nulla;
            return false;
        }
        Prodotto other= (Prodotto)o; //Casting sicuro: il compilatore non conosce la reference nella funzione dell'oggetto o, quindi gliela dobbiamo assegnare noi manualmente;
        if(other.descrizione==null) {
            if(this.descrizione==null) {
                return prezzo == other.prezzo;
            }
            return false;
        }
        return this.descrizione.equals(other.descrizione) && (this.prezzo==other.prezzo);
    }

    //una volta fatto ciò, avendo lo stato di un oggetto dobbiaamo mettere tutti i parametri a confronto e ritornerà vero solo se rispetta le condizioni che noi gli diamo e che servono a noi;
    //regola sacro santa: due oggetti uguali sono tali se hanno lo stesso Hash code (HashCode = indirizzo dove sta l'ogtgetto)!!!
    //quindi dobbiamo ricordarci di andare a fare l'override dell'HashCode per non commettere questo errore fatale!!
    @Override
    public int hashCode(){
        System.out.println("Ho chiamato HashCode");
        return (descrizione !=null ? descrizione.hashCode() : 1) + prezzo;
    }
}