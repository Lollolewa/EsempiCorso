package esercizioInterfacciaGestioneBiblioteca;

public interface Risorsa {
    String getTitle();
    boolean isAvailable();
    void lend();
    void giveBack();
}
