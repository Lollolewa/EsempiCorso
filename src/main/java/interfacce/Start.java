package interfacce;

public class Start {
    public static void main(String[] args) {
        Persona p = new Persona();

        Persona.maxAge = 10; //il maxAge non final può essere modificato
        // Persona.staticMaxAge = 10; //ci darà errore dicendoci che una costante non può essere modificata.


        CanFly s = new Supereroe(); //Posso creare il contenitore di tipo CanFly e metterci dentro un oggetto di una delle classi che
                                     // implementano quell'interfaccia. Polimorfismo.
                                     //tuttavia io non posso accedere alle variabili del supereroe perchè ho la reference di tipo CanFly
                                    // e quell'interfaccia non ha all'interno quelle variabili e metodi
        s.acrobazia();

        Supereroe s2 = new Supereroe();
        s2.qualcosa(); //Posso richiamare un metodo di CanFly anche se non l'ho richiamato dentro quella classe
        s2.voloMassimo = 1; //in questo caso posso accedere alle variabili del supereroe perchè la reference è di tipo Supereroe. In questo
                            //caso avremo sia variabili e metodi di supereroe che dell'interfaccia (Oltre che della classe madre Persona);
    }
}
