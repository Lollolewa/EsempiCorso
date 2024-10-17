package Interfacce;

import org.generation.italy.esempiCorso.inheritance.school.Person;

public class Start {
    public static void main(String[] args) {
        Persona p = new Persona();
        //CanFly s = new Supereroe(); polimorfismo posso creare un contenitore di tipo Canfly e metterci dentro supereroe

        CanFly s = new Supereroe();
        //s puo accedere soltanto ai metodi canFly non a quelli di Supereroe
        s.acrobazia();
        s.qualcosa();


        //static= è di classe, perchè riguarda l'intera categoria e non all'oggetto
        //statico cambia, final no;
    }
}
