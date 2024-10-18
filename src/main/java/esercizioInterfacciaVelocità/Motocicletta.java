package esercizioInterfacciaVelocità;

public class Motocicletta implements Veicolo{
    int velocitàCorrente = 0;

    @Override
    public void accelera(int incrementoVelocità) {
        velocitàCorrente += incrementoVelocità;
        //System.out.println("La moto sta andando a " + velocitàCorrente + " km/h.");
    }

    @Override
    public void ferma() {
        velocitàCorrente = 0;
        //System.out.println("La moto si è fermata, ora è a " + velocitàCorrente + " km/h.");
    }
    public int getVelocità(){
        System.out.println("La velocità corrente è di " + velocitàCorrente + " km/h.");
        return velocitàCorrente;
    }

}
