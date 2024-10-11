package org.generation.italy.esempiCorso.inheritance.exercise;
//
import java.time.LocalDate;
import java.util.Random;

public class Amazon extends Character {

    public Amazon(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, int puntiVita,
                int forza, int intelligenza, int carisma, int agilità, String nomeClasse, boolean isDefending, int maxHP){
        super(nome, cognome, nomePersonaggio, password, dataIscrizione, isLogged, puntiVita, forza, intelligenza, carisma, agilità, nomeClasse, false,
                maxHP, 0);
    }

    @Override
    public String getCharacterClass() {
        return this.nomeClasse;
    }


    @Override
    public void Attacca(Character nemico) {
        if(nemico.isDefending){
            nemico.puntiVita -= (this.forza - riduzioneDanno)/2;
            nemico.isDefending = false;
        }
        else{
            nemico.puntiVita -= this.forza;
        }
    }

    @Override
    public void Difendi() {
        this.isDefending = true;
    }

    @Override
    public boolean Scappa() {
        int x = (int)(Math.random()*19);
        if(x >= 16){
            return true;
        }
        return false;
    }

    public void castRate(Character nemico){
        if(nomeClasse != "Amazon"){
            if(nemico.isDefending){
                nemico.puntiVita -= forza;
            }else{
                nemico.puntiVita -= forza + 5;
            }
        }else{
            System.out.println("Questa abilità non ha effetto sui nemici sprovvisti di 'gioielli' ");
        }
    }
}
