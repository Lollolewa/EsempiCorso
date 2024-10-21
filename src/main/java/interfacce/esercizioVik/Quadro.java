package interfacce.esercizioVik;

public class Quadro extends OperaDArte{
    boolean expFram;

    public Quadro(String nome, String autore, int year, int value, boolean expFram) {
        super(nome, autore, year, value);
        this.expFram = expFram;
    }
    @Override
    public String toString(){
        String x = String.format("Nome: %s%nAutore: %s%nAnno: %d%nCosto: %d%nCornice: ", nome, autore, year, value);
        return expFram ? x + "si" : x + "no";
    }
}
