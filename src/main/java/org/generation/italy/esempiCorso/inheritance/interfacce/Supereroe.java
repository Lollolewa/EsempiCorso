package org.generation.italy.esempiCorso.inheritance.interfacce;

public class Supereroe extends Persona implements CanFly{

    int voloMassimo;
    public void PossoVolareCosiAlto(){
        if(voloMassimo > maxHeight){
            System.out.println("sono morto");
        }
    }

    @Override
    public boolean fly() {
        return false;
    }

    @Override
    public void faiAcrobazie(){
        System.out.println("why");
    }
}
