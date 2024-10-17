package esercizioInventato;

public interface GestioneQuadri {
    void aggiungi(OperaDarte c);
    void rimuovi(OperaDarte c);
    OperaDarte cercaPerNome(String nome);
    OperaDarte cercaPerAnno(int anno);

}
