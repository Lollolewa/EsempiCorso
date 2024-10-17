package eserciziInterfaccia;

public interface gestioneQuadri {
    void aggiungi(OperaArte op);
    void rimuovi(OperaArte op);
    OperaArte cercaPerNome(String nome);
    OperaArte cercaPerAnno(int anno);
}
