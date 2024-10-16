package org.generation.italy.esempiCorso.Slytherin.exercises.OperaDArte.Case;

public class Appartamento extends Casa{
    int energyCode;

    public Appartamento(int surface, int roomNum, int energyCode) {
        super(surface, roomNum);
        this.energyCode = energyCode;
    }

    @Override
    public int HouseValue(){
        return (surface * 1500) + (roomNum * energyCode);
    }
}
