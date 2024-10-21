package interfacce.spiegazione;

public class Start {
    public static void main(String[] args) {
        Persona p = new Persona();
        System.out.println(Persona.maxAge);
        Supereroe s = new Supereroe();
        s.trial();
        Supereroe s1 = new Supereroe();
        s1.something();
        CanFly c = new Supereroe();

    }
}
