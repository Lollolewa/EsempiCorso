package interfacce.esercizioVik;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestioneQuadriImpl implements GestioneQuadri{

    List<OperaDArte> opere = new ArrayList<>();

    @Override
    public void add(OperaDArte o){
        opere.add(o);
    }
    @Override
    public void remove(OperaDArte o){
        opere.remove(o);
    }
    @Override
    public Optional<Quadro> searchForName(String s){
        for (OperaDArte o : opere) {
            if (o.getClass() == Quadro.class) {
                if (o.nome.equals(s)){
                    return Optional.of((Quadro) o);
                }
            }
        }
        return Optional.empty();
    }
    public Optional<Quadro> searchForAnno(int i){
        for (OperaDArte o : opere) {
            if (o.getClass() == Quadro.class) {
                if (o.year == i){
                    return Optional.of((Quadro) o);
                }
            }
        }
        return Optional.empty();
    }
}
