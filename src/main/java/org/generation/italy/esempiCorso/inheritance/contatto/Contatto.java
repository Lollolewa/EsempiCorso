package org.generation.italy.esempiCorso.inheritance.contatto;

public class Contatto {
    private String nome,cognome,numeroTelefono;

    public Contatto(String nome,String cognome,String numeroTelefono){
        this.nome=nome;
        this.cognome=cognome;
        this.numeroTelefono=numeroTelefono;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome= nome;
    }

    public String getCognome(){
        return cognome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public String getNumeroTelefono(){
        return getNumeroTelefono();
    }
    public void setNumeroTelefono(String numeroTelefono){
        this.numeroTelefono=numeroTelefono;
    }
    public String toString(){
        return nome + " " + cognome + " " + numeroTelefono;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) //siamo lo stesso oggetto?
            return true;
        if(obj == null) {
            return false; //se mi hai passato un indirizzo nullo
        }
        if(obj.getClass() != this.getClass())
            return false;
        Contatto other = (Contatto) obj; //eseguo il cast Contatto a obj cosi può utilizzare i suoi metodi
        return this.nome.equals(other.nome) && this.cognome.equals(other.cognome);

    }

    @Override
    public int hashCode() {
        return nome.hashCode() + 5 * cognome.hashCode();
    }

}
