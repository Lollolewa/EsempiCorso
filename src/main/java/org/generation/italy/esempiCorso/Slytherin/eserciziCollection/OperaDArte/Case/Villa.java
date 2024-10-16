package org.generation.italy.esempiCorso.Slytherin.eserciziCollection.OperaDArte.Case;

public class Villa extends  Casa{
    boolean pool;

    public Villa(int surface, int roomNum, boolean pool) {
        super(surface, roomNum);
        this.pool = pool;
    }

    @Override
    public int HouseValue() {
        int price = surface * 2000;
        if (pool) {
            price += 20000;
        }
        if (roomNum >= 10) {
            price += 10000;
        }
        return price;
    }
}
