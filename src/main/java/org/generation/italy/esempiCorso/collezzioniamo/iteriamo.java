package org.generation.italy.esempiCorso.collezzioniamo;

import java.util.*;

public class iteriamo {
    public static void main(String[] args) {
        List<Prodotto> prodotti = new ArrayList<>();
        List<Integer> numeri = new ArrayList<>(); //in questo caso ricorda che l'array list contiene solo primitivi, quindi dobbiamo mettere Integere;
        prodotti.add(new Prodotto("farina", 3));
        prodotti.add(new Prodotto("pomodoro",5));
        prodotti.add(new Prodotto("mozzarella", 4));
        System.out.println(prodotti.size());
        for(Prodotto s : prodotti){
            System.out.print(s.descrizione);
            System.out.println(s.prezzo);
        }
        //-------------------------------------------
        List<Prodotto> listlink = new LinkedList<>();
        listlink.add(new Prodotto("pane",1));
        //il prodotto viene wrappato dentro un altro oggeto; il nuovo oggetto conterà il prodotto più due reference
        //un al prodotto sucesso e un al prodotto precendete;
        //prodotto1<->prodotto2<->prodotto3
        //quindi se abbiamo solo prodotto 1 2 3, verranno visualizzati in questa maniera nel LinkedList:
        //prodotto1[null,prodtto1, prodotto2]
        //prodotto2[prodotto1, prodotto2, prodotto3]
        //prodotto3[prodtto2, prodotto3, null]
        //non sono molto usati, ma esistono perchè è più efficiente aggiungere o togliere elementi a differenza di un array dove bisogna spostare tutto;

        //-------------------------------------------
        //set: si tratta anche qui di un insieme di elementi ma non è ordinato; è un insieme di elementi (tipo un sacco) e non ammette duplicati;
        Set<Integer> numbers = new HashSet<>(); //anche qui qui in mezzo <> possiamo mettere integere ma intellij non è fondamentale;
        numbers.add(23);
        numbers.add(44); //cosi come si aggiungono in maniera molto analogo a prima, e ricorda non si mettono mai 2 elementi uguali!
        //non essendo ordinati, non possu usare il get ma per cercare un elemento devo andare a iterare;
        for(int s : numbers){
            if(s==23){
                System.out.println("Michael Jordan!");
            }
        }
        Set<Prodotto> cibo = new HashSet<>();
        cibo.add(new Prodotto("Cane",5));
        cibo.add(new Prodotto("Cane",5));
        System.out.println(cibo.size());
        //in questo caso essendo che i 2 prodotti non sono primitive, non sono uguali quyindi non verrà ignorato il secondo elemnto anche se per noi è uguale;
        //inoltre bisogna stare attenti anche a confrontare 2 oggetti, perchè quello che si paragona sono le reference, no gli elemtni dentro l'oggetto (cioò lo stato);
        //ciò dovrebbe dare false, ma invece non lo fa perchè quando crei una stringa noi creamo una cella di memoria specifica a cui tutti le stringhe future con gli stessi caratteri punteranno;
        //in poche parole su Java non è possibile modificare stringhe, perche creandone una appunto andiamo ad allocarla ad una specifica cella di memoria,
        //e quando la modifichiamo semplicemente cambiamo l'indiritto della stringa da noi creata;

        Prodotto uno = new Prodotto("topo", 5);
        Prodotto due =new Prodotto("topo",5);
        Boolean grr = uno.equals(due); //la funzione equals, che viene eredita da "object" non fa altro che confrontare le reference, non va bene per verificare se 2 oggetti sono uguali;
        System.out.println(grr);        //se vogliamo che la funzione .equals verifichi come vogliamo noi, ovvero in questo caso 2 oggetti prodotto sono uguali se hanno lo stesso prezzo e descrizione;
        System.out.println(uno.inutile());
        System.out.println(prodotti.get(0).inutile());
        System.out.println(uno.equals(due)); //ora la funzione equal, con le ovverride fatte nella funzione, fa il suo lavoro come si deve! GG;
    }

}
