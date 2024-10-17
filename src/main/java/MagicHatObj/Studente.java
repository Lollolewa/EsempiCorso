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

}
