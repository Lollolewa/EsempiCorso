package org.generation.italy.esempiCorso.ravenclaw.casa;

public abstract class Casa {

    protected int superfice, nStanze;

    public Casa(int superfice, int nStanze) {
        this.superfice = superfice;
        this.nStanze = nStanze;
    }

    public int getSuperfice() {
        return superfice;
    }

    public int getnStanze() {
        return nStanze;
    }

    public void setSuperfice(int superfice) {
        this.superfice = superfice;
    }

    public void setnStanze(int nStanze) {
        this.nStanze = nStanze;
    }

    public abstract int costoCasa();
}
