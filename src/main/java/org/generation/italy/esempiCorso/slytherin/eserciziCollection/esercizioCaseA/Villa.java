package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioCaseA;

public class Villa extends Casa{

    protected boolean piscina;

    public Villa(int superficie, int numeroStanze,boolean piscina){

        super(superficie, numeroStanze);
        this.piscina = piscina;
    }

    // fatto Override anche in Villa perché è un metodo astratto e deve essere implementato in ogni classe
    // figlia che estende Casa
    @Override
    protected int costoCasa(){
        int costoCasa = superficie * 200;
        if(piscina){
            costoCasa += 20_000;
        }
        if(numeroStanze >= 10){
            costoCasa += 10_000;
        }
        return costoCasa;
    }
}
