package interfacce.esercizioVik;

import java.util.Date;

public abstract class OperaDArte {
    protected String nome, autore;
    protected int year, value;
    //protected Date d = new Date();

    public OperaDArte(String nome, String autore, int year, int value) {
        this.nome = nome;
        this.autore = autore;
        this.year = year;
        this.value = value;
    }
    @Override
    public String toString(){
        return String.format("Nome: %s%nAutore: %s%nAnno: %d%nCosto: %d%n", nome, autore, year, value);
    }
}
