package esercizioInterfacciaVelocità;

public class Main {
    public static void main(String[] args) {
        Automobile auto = new Automobile();
        Motocicletta moto = new Motocicletta();

        auto.accelera(100);
        System.out.println(auto.getVelocità());
        auto.ferma();

        moto.accelera(150);
        System.out.println(moto.getVelocità());
        moto.ferma();
    }
}
