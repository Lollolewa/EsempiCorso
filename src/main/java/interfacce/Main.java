package interfacce;

public class Main {
    public static void main(String[] args) {
        Persona  p = new Persona();
        Supereroe s = new Supereroe();
        CanFly s1 = new Supereroe();
        CanFly c = new Aereo();

       // s.doAcrobatics();
        //s1.doAcrobatics();
        //c.doAcrobatics();

        //Persona.maxAge; compilazione non andrà perché maxAge è una variabile statica di una classe e non una variabile di istanza.
        //Persona.maxAge = 10;  Non è possibile modificare la variabile final da un'istanza.'
    }
}