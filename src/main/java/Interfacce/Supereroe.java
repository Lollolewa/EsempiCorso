package Interfacce;

public class Supereroe extends Persona implements CanFly{
     int voloMassimo;

    public void possoVolareCosiAlto(){
        if(voloMassimo > CanFly.maxHeight){
            System.out.println("Sono Mortooooo");
        } else{
            System.out.println("Sto volando alla giusta altezza");
        }

    }

    @Override
    public void acrobazia(){
        System.out.println("Io non faccio acrobazie");
    }

    @Override
    public boolean isFly() {
        return false;
    }
}
