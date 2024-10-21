package org.generation.italy.esempiCorso.collezioniamo.exercises;

public class Contatto
{
    private String nome, cognome, numeroTelefono;

    public Contatto(String nome, String cognome, String numeroTelefono){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getNumeroTelefono(){
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono){
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) // siamo lo stesso oggetto?
            return true;
        if(obj == null)
            return false;
        if(obj.getClass() != this.getClass()) // abbiamo classi diverse?
            return false;
        Contatto other = (Contatto) obj; // castiamo, diciamo al compilatore fidati di me
        return this.nome.equals(other.nome) && this.cognome.equals(other.cognome);
    }
    // ricordate che se due oggetti sono uguali hanno lo stesso hashCode
    @Override
    public int hashCode(){
        return nome.hashCode() + 7 * cognome.hashCode();
    }

    public String toString(){
        return nome + " " + cognome + " " + numeroTelefono;
    }

}
