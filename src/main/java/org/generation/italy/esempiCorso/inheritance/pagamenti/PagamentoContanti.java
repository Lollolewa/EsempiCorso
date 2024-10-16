package org.generation.italy.esempiCorso.inheritance.pagamenti;

public class PagamentoContanti extends Pagamento{

    @Override
    public void effettuaPagamento(){
        System.out.println("Il pagamento è stato effettuato in contanti");

    }
}
