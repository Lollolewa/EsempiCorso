package org.generation.italy.interfacce;

public interface GestioneQuadri {
    void add(OperaDarte opera);
    void remove(OperaDarte opera);
    OperaDarte cercaPerNome(String nome);
    OperaDarte cercaPerAnno(int anno);
}
/*creare un interfaccia che si chiama GestioneQuadri
    al suo interno dovra' avere i seguenti metodi
    -aggiungi
    -rimuovi
    -cercapernome
    -cercaperanno*/
