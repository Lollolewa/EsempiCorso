package org.generation.italy.esempiCorso.inheritance.veicoloConsumo;

public class Auto extends Veicolo {
    private double chilometriPercorsi;
    private double litriConsumo;

    public Auto(double chilometriPercorsi,double litriConsumo){
        this.chilometriPercorsi = chilometriPercorsi;
        this.litriConsumo= litriConsumo;
    }

    @Override
    public double calcolaConsumo() {
        return (litriConsumo/chilometriPercorsi) * 100;
    }
}
