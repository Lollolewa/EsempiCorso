package org.generation.italy.esempiCorso.interfacce.esercizio;

import org.generation.italy.esempiCorso.griffindor.eserciziCollection.arte.OperaDArte;

public interface GestioneQuadri {
    void aggiungiQuadro(OperaDArte opera);
    void rimuoviQuadro(OperaDArte opera);
    OpereDArte cercaPerNome(String nome);
    OpereDArte cercaPerAnno(int anno);
}
