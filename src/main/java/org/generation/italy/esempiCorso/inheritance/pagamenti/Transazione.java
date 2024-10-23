package org.generation.italy.esempiCorso.inheritance.pagamenti;
public class Transazione {
    private int importo = 0;
   private Pagamento metodoPagamento;

    public Transazione(int importo, Pagamento metodoPagamento) {
        this.importo = importo;
        this.metodoPagamento = metodoPagamento;
    }

    public void esegui() {
        this.metodoPagamento.effettuaPagamento();
    }

}