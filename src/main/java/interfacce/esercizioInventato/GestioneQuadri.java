package interfacce.esercizioInventato;

public interface GestioneQuadri {

    void add(OpereDArte op);
    void remove(OpereDArte op);
    OpereDArte cercaPerNome(String nome);
    OpereDArte cercaPerAnno(int anno);
}
