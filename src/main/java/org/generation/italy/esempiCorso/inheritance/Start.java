package org.generation.italy.esempiCorso.inheritance;


import org.generation.italy.esempiCorso.inheritance.school.Employee;
import org.generation.italy.esempiCorso.inheritance.school.Person;
import org.generation.italy.esempiCorso.inheritance.school.Personnel;

import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){


        Teacher teacher = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);
        Personnel bidello = new Personnel("Bobby", "Rocket", 67, 1500, 14, 200, "Bidello");
        teacher.eat();
        teacher.teach();
        teacher.eat();
        System.out.println(teacher.toString());
        System.out.println("\n");
        System.out.println(bidello.toString());
        Person x = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);
        x.eat(); //questa può puntare a oggetti di tipo person o sotto di lui come teacher
        // static binding (è il processo di legare l'invocazione di un metodo alla sua esecuzione)
        // x.teach(); questo no perché guarda solo i metodi della classe person ma non di quelli sotto di lui
        // Personnel y = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);
//        y.doAdministration(); questo no
        Person p1;
        if(Math.random()>.5){
            p1 = new Teacher("Michael", "Johnson", 35,"Math",11, 2500, 14);
        }else{
            p1 = new Personnel("Bobby", "Rocket", 67, 1500, 14, 200, "Bidello");
        }
        p1.eat(); //qua non c'è static binding perché non prevede il futuro
        //in java i metodi sono in dynamic binding che sono fatti in real-time
        //in c# e c++ i metodi sono in static binding
        Person[] pp = {teacher, p1};
        makeIntervalForAll(pp); //wow polimorfismo 🚀 principi s.o.l.i.d. (non soldi(e nemmeno snake)) :(
    }
    public static void makeInterval(Teacher t){
        t.eat();
        t.chat();
    }
    public static void makeInterval(Personnel p) {
        p.eat();
        p.chat();
    }
    // commento nerd: one rocket to rule them all🚀
    public static void makeInterval(Person q){
        q.eat();
        q.chat();
    }
    public static void makeIntervalForAll(Person[]ps){
        for(int i = 0; i<ps.length; i++){ //in questo array ci può essere più di un tipo
            ps[i].eat();
            ps[i].chat();
        }
        // S: principio di responsabilità Singola (ogni classe deve avere una sola responsabilità)
        //   primo motivo: diventa una classe grassa
        //   secondo motivo: quando vai a modificarla cambia tutto quello che viene dopo
        //   terzo motivo: dividere et impera (così si lavora più facilmente in più persone)
        // O: Open-Closed, il codice che scriviamo dovrebbe essere chiuso alla modifica ma allungabile
        // L:
    }
    public void startWorkDay(Employee e){
        e.chat();
        e.doWork(3);
        e.eat();
        e.chat();
        e.doWork(3);

       Teacher teacher = new Teacher("Riccardo","Audano",18, "programmazione", 18);
       System.out.println(teacher.toString()); //tutti gli oggetti creati derivano dalla super classe object


    }
}