package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioCaseA;

// Appartamento oltre ad avere le sue proprietà, avrà anche quelle di Casa
public class Appartamento extends Casa{

    protected int codiceEnergetico;

    // superficie e numeroStanze vengono valorizzate con il super, utilizzando le proprietà di casa
    public Appartamento(int superficie, int numeroStanze, int codiceEnergetico){

        super(superficie, numeroStanze);
        this.codiceEnergetico = codiceEnergetico;
    }

    // essendo astratto in Casa ovvero che non ha un corpo, deve essere per forza implementato nelle classi
    // che estendono Casa, definendo il corpo
    @Override
    protected int costoCasa() {
        return superficie * 1500 + numeroStanze * codiceEnergetico;
    }
}
