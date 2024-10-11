package org.generation.italy.esempiCorso.inheritance.exercise;
//
import java.time.LocalDate;
import java.util.Random;

public class Barbarian extends Character {

    private boolean canDefend = true;

    public Barbarian(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, int puntiVita,
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
        if(canDefend == true){
            this.isDefending = true;
        }else{
            System.out.println("Non puoi difenderti mentre sei in berserk");
        }
    }

    @Override
    public boolean Scappa() {
        int x = (int)(Math.random()*19);
        if(x >= 16){
            return true;
        }
        return false;
    }

    public void annullaEffetto(){
        this.canDefend = true;
        this.forza = (int)this.forza/2;
    }

    public void Berserk() {
        this.canDefend = false;
        this.forza = (int)this.forza*2;
    }
}
