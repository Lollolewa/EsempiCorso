package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Paladin extends Character{

    public Paladin(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, int puntiVita, int forza, int intelligenza, int carisma, int agilità, String nomeClasse) {
        super(nome, cognome, nomePersonaggio, password, dataIscrizione, isLogged, puntiVita, forza, intelligenza, carisma, agilità, maxHP);
    }

    @Override
    public void getCharacterClass(){

    }

    @Override
    public void attacca(Character nemico){
        if(nemico.isDefending()){
            nemico.puntiVita -= this.forza/2;
            nemico.isDefending = false;
        }else{
            nemico.puntiVita -= this.forza;
        }
    }

    @Override
    public void difendi(Character nemico){
        this.isDefending = true;
    }


    public boolean scappa(){
        int x = (int)(Math.random()*19);
        if(x >= 16){
            return true;
        }
        return false;
    }

    public void heal(){
        if(this.puntiVita == this.maxHP){
            System.out.println("Hai già il massimo di vita")
        }else{
            this.puntiVita += 5;
            if(this.puntiVita > this.maxHP){
                this.puntiVita = this.maxHP;
            }
        }
    }

}
