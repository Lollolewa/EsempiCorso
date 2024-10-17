package org.generation.italy.esempiCorso.inheritance.animali;

public class Uccello extends Animale{
    private String nome;

    public Uccello(String nome) {
        this.nome = nome;
    }

    @Override
    public String verso() {
        return "Il mio verso è pio piooo";
    }

    @Override
    public String presentati() {
        return "Il mio nome e' " + nome+ " e sono un dolce uccellino" + verso();
    }
}
