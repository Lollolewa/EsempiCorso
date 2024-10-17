package interfacce;

public class Supereroe extends Persona implements CanFly{
    public int voloMassimo;
    public void possoVolareCosiAlto() {
        if (voloMassimo>CanFly.maxHeight) {
            System.out.println("sono morto");
        }
    }

    @Override
    public void acrobazia() {
        System.out.println("No Sense?");
    }

    @Override
    public boolean fly() {
        return false;
    }
}
