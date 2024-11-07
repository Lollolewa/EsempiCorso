package org.generation.italy.esempiCorso.interfacce.esercizioNuovo;

public interface GestioneQuadri {
     void aggiungi(OperaDArte c);
     void rimuovi(OperaDArte c);
     OperaDArte cercaPerNome(String name);
     OperaDArte cercaPerAnno(int anno);


}
