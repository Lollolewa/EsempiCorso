package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.*;

public class Start {
    public static void main(String[] args){
        Teacher t = new Teacher("Pippo", "Pippo", 25, 1500, 13, "Informatica", 12); //tutti gli oggetti creati derivano dalla super classe object, ereditiamo in automatico certi metodi
        Personnel p = new Personnel("Peppe", "Peppe", 28, 1500, 13, "Amministratore", 1600);
        System.out.println(p);
        System.out.println(t);
        Person b = new Teacher("Pippone", "Pippo", 25, 1500, 13, "Informatica", 12);
        b.eat(); //si perchè posso usare metodo person su oggetto teacher // con override viene eseguito quello di teacher non quello di person
        //b.teach(); //no perchè non posso usare metodo di teacher con person
        Person p1;
        if(Math.random()>.5){
            p1 = new Teacher("Pippo", "Pippo", 25, 1500, 13, "Informatica", 12);
        }else{
            p1 = new Personnel("Peppe", "Peppe", 28, 1500, 13, "Amministratore", 1600);
        }
        p1.eat(); //compilatore non sa a cosa sta puntando, solo a runtime lo saprà
        Person[] pp = {p1, b};
        makeIntervalForAll(pp); // polimorfismo, principi S.O.L.I.D.
    }   // S. : Single responsibility: una classe deve avere una sola responsabilità o una sola ragione per poter cambiare
        // O. : Open closed: Il codice deve essere idealmente aperto all'estensione ma chiuso alla modifica
        // L. :
        // I. :
        // D. :
    public static void makeInterval(Teacher t){
        t.eat();
        t.chat();
    }

    public static void makeInterval(Personnel p){
        p.eat();
        p.chat();
    }

    // una referenza per tutto
    public static void makeInterval(Person per){
        per.eat();
        per.chat();
    }

    public static void makeIntervalForAll(Person[] ps){
        for(int i = 0; i <ps.length; i++) {
            ps[i].eat();
            ps[i].chat();
        }
    }

    public void startWorkDay(Employee e){
        e.chat();
        if(e.getClass() != Stagista.class){ // violazione del principio di Liskov
            e.doWork(3); // dovrei riuscire a eseguire questo metodo senza dovermi preoccupare di quale figlia ci va dentro
        }
        e.eat();
        e.chat();
        if(e.getClass() != Stagista.class){
            e.doWork(3);
        }

    }
}
