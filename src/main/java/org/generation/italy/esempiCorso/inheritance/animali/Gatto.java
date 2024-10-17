package org.generation.italy.esempiCorso.inheritance.animali;

public class Gatto extends Animale {
    private String nome;

    public Gatto(String nome){
        this.nome=nome;
    }

    @Override
    public String verso() {
        return "Il mio verso è miaooooo";
    }

    @Override
    public String presentati() {
        return "Ciao sono " + nome + " e sono un dolce gatto" + verso();
    }
}
