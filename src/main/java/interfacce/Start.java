package interfacce;

import static interfacce.Persona.maxAge;

public class Start {
    public static void main(String[] args) {
        Persona p = new Persona();
        System.out.println(maxAge);
        CanFly s = new SuperEroe();
        s.faiAcrobazia();
        SuperEroe eroe = new SuperEroe();
        eroe.qualcosa();
        eroe.voloMassimo = 10;

    }
}
