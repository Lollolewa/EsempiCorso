package org.generation.italy.esempiCorso.gryffindor.esercizioRubrica;

public class Contatto {
    private String nome, cognome, numeroTelefono;
    public Contatto(String nome, String cognome, String numeroTelefono){
        this.nome=nome;
        this.cognome=cognome;
        this.numeroTelefono=numeroTelefono;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(obj.getClass()!=this.getClass()){
            return false;
        }
        Contatto other=(Contatto) obj;
        return this.nome.equals(other.nome) && this.cognome.equals(other.cognome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + 7 * cognome.hashCode();
        //evito che mario rosso e rosso mario abbiano stesso hashCode
    }

    public String toString(){
        return nome + " " + cognome + " " + numeroTelefono;
    }

}
