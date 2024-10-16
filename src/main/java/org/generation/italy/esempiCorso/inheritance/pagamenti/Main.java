package org.generation.italy.esempiCorso.inheritance.pagamenti;

public class Main {
    public static void main(String[] args) {

    Pagamento p1 = new PagamentoContanti();
    Pagamento p2 = new PagamentoCarta("abc5678",2024,10,10);
    Transazione[] transazioni = {new Transazione(50,p1),new Transazione(50,p2),new Transazione(100,p1)};

    for(int i = 0; i< transazioni.length;i++) {
            transazioni[i].esegui();
        }
    }
}
