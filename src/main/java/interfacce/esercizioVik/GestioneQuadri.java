package interfacce.esercizioVik;

import java.util.Optional;

public interface GestioneQuadri {

    void add(OperaDArte o);
    void remove(OperaDArte o);
    Optional<Quadro> searchForName(String s);
    Optional<Quadro> searchForAnno(int i);
}
