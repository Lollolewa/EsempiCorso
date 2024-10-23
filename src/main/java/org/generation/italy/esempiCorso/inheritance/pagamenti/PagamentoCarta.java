package org.generation.italy.esempiCorso.inheritance.pagamenti;
import java.time.LocalDate;

public class PagamentoCarta extends Pagamento {
    protected String numeroCarta;
    protected LocalDate scadenza =  LocalDate.of(2024,10,10);

    public PagamentoCarta(String numeroCarta,LocalDate scadenza){
        this.numeroCarta=numeroCarta;
        this.scadenza=scadenza;
    }

    public PagamentoCarta(String abc550, int i, int i1, int i2) {
        super();
    }

    @Override
    public void effettuaPagamento() {

        System.out.println("Il pagamento è stato effettuato con carta, letsgoski");
    }
}
