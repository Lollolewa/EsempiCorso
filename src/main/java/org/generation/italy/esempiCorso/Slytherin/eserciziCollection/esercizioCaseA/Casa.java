package org.generation.italy.esempiCorso.Slytherin.eserciziCollection.esercizioCaseA;

public abstract class Casa {

    protected int superficie, numeroStanze;

    // metodo astratto costoCasa che tutte le classi figlie dovranno avere
    protected abstract int costoCasa();

    // costruttore per poter valorizzare i parametri superficie e numero stanze nel main
    public Casa(int superficie, int numeroStanze){

        this.superficie = superficie;
        this.numeroStanze = numeroStanze;
    }
}


