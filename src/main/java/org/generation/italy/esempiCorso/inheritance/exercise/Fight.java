package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Fight {
    public static void main(String[] args) {
    Character pippo = new Mage("Stefano","Puro","Riku","Ciaociao");
    Character paperino = new Paladin("Boa", "Hancok","Boa","xdxd");

    boolean combattimentoFinito = false;
    pippo.login("Riku", "Ciaociao");
    paperino.login("Boa", "xdxd");
    while(!combattimentoFinito && pippo.isLogged && paperino.isLogged) {

        pippo.attaccalo(paperino);
        paperino.difendimi(pippo);
        pippo.abilitaSpeciale(paperino);
        combattimentoFinito = paperino.isDead();
        System.out.println("Paperino pv: " + paperino.puntiVita);
        if (combattimentoFinito) {
            break;
        }

        paperino.attaccalo(pippo);
        pippo.difendimi(paperino);
        paperino.abilitaSpeciale(paperino);
        combattimentoFinito = pippo.isDead();
        System.out.println("Pippo pv: " + pippo.puntiVita);
    }
        if (pippo.isDead() && pippo.isLogged && paperino.isLogged) {
            System.out.println("Paperino ha vinto");
        } else if (paperino.isDead() && pippo.isLogged && paperino.isLogged) {
            System.out.println("Pippo ha vinto");
        }

    }
    public void abilitaSpeciale(Character x, Character y){
            if(x instanceof Paladin){
                ((Paladin) x).heal();
            } else if (x instanceof Mage) {
                ((Mage) x).throwFireBall(y);
            }
    }
}
