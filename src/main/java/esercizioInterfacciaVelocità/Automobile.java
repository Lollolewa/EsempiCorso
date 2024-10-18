package esercizioInterfacciaVelocità;

public class Automobile implements Veicolo{
    int velocitàCorrente = 0;

    @Override
    public void accelera(int incrementoVelocità) {
        velocitàCorrente += incrementoVelocità;
    }

    @Override
    public void ferma() {
        velocitàCorrente = 0;
    }

    public int getVelocità(){
        System.out.println("La velocità corrente è di " + velocitàCorrente + " km/h.");
        return velocitàCorrente;
    }
}
