package MagicHatObj;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Studente {
    protected String nome;
    protected String cognome;
    protected Optional<NomiCasate> preferenza;

    public Studente(String nome, String cognome, Optional<NomiCasate> preferenza){
        this.nome = nome;
        this.cognome = cognome;
        this.preferenza = preferenza;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %s, preferenza: %s,", nome, cognome, preferenza);
    }
}
