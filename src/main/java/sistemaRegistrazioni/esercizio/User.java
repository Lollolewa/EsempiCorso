package sistemaRegistrazioni.esercizio;

public class User extends RegistrazioneImpl {
    public void registra() {
        registrazioneValida = true; // Imposta il flag a true per la registrazione
        inserisciEta(); // Richiama il metodo per inserire l'età
        inserisciPosti(); // Richiama il metodo per inserire i posti
        confermaRegistrazione(); // Conferma la registrazione
    }

    public static void main(String[] args) {
        User user = new User();
        user.registra(); // Avvia il processo di registrazione
    }
}
