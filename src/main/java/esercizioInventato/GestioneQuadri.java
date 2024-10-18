package esercizioInventato;

/*classe astratta OperaDArte con proprieta nome anno autore costo
classe Quadro estende OperaDArte con proprieta boolean corniceCostosa
classe Start: lista di OperaDArte con possibilita' di usare i metodi di GestioneQuadri
 */

public interface GestioneQuadri {
    void aggiungi(OperaDarte c);
    void rimuovi(OperaDarte c);
    OperaDarte cercaPerNome(String nome);
    OperaDarte cercaPerAnno(int anno);

}
