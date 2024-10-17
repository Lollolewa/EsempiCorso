package org.generation.italy.esempiCorso.inheritance.animali;

public class Cane extends Animale{
    private String nome;

    public Cane(String nome) {
        this.nome = nome;
    }

    @Override
    public String presentati(){
        return "Ciao sono " + nome + " sono un dolcissimo cane" + verso();
    }
    @Override
    public String verso(){
        return "Il mio verso è bau bauuu";

    }
}
