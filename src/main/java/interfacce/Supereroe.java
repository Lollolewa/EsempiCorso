package interfacce;

public class Supereroe extends Persona implements CanFly {
    public int voloMassimo;
    public void possoVolareCosiAlto(){
        if(voloMassimo>maxHeight){
            System.out.println("muoio");
        }
    }
    @Override
    public boolean fly() {
        faiAcrobazie();
        return false;
    }
    @Override
    public void faiAcrobazie(){
        System.out.println("qual è il senso");
    }
}
