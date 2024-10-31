package org.generation.italy.esempiCorso.griffindor.eserciziCollection.arte;

public abstract class OperaDArte {
    public String autore, titolo;

    public OperaDArte(String autore, String titolo) {
        this.autore = autore;
        this.titolo = titolo;
    }

    public abstract double calculateDimensioni();
    private boolean isSameDimensioni(OperaDArte a){
        return this.calculateDimensioni() == a.calculateDimensioni();
    }
    public void compareToString(OperaDArte a){
        if(isSameDimensioni(a))
            System.out.println("Le opere " + this.titolo + " e " + a.titolo + " hanno le stesse dimensioni.");
        else
            System.out.println("Le opere " + this.titolo + " e " + a.titolo + " non hanno le stesse dimensioni.");
    }


}
