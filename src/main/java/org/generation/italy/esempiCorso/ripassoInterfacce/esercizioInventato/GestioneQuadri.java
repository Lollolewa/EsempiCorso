package org.generation.italy.esempiCorso.ripassoInterfacce.esercizioInventato;

public interface GestioneQuadri {

    void add(OpereDArte op);
    void remove(OpereDArte op);
    OpereDArte cercaPerNome(String nome);
    OpereDArte cercaPerAnno(int anno);
}
