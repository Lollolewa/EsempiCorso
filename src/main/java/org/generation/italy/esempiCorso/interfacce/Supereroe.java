package org.generation.italy.esempiCorso.interfacce;

public class Supereroe extends Persona implements CanFly {
    int maxHeightCanFly;
    public void canFlyHeight(){
        if(maxHeightCanFly > maxHeight){
            System.out.println("Il Supereroe non può volare altezze fino a " + maxHeightCanFly + " metri, muore.");
        }else{
            System.out.println("Il Supereroe può volare altezze fino a " + maxHeightCanFly + " metri.");
        }
    }

    @Override
    public boolean fly() {
        System.out.println("Supereroe vola!");
        doAcrobatics();
        return false;
    }
}
