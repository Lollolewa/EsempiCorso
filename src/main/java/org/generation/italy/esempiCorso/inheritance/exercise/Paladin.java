package org.generation.italy.esempiCorso.inheritance.exercise;
//
import java.time.LocalDate;
import java.util.Random;

public class Paladin extends Character {

    public Paladin(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, int puntiVita,
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
            nemico.puntiVita -= (int)(this.forza-riduzioneDanno)/2;
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

    public void Heal(){
        if(this.puntiVita == this.maxHP){
            System.out.println("LETSGOSKI SEI GIA FULLVITA SCEMO");
        }else{
            this.puntiVita += 5;
            System.out.println("LETSGOSKI LETS GO ME SO CURATO SONO CARICO E' COSY CHE SI FA");
            if(this.puntiVita > this.maxHP){
                this.puntiVita = this.maxHP;
            }
        }
    }
}
