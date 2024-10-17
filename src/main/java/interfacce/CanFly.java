package interfacce;

public interface CanFly {
    //tipo astratto, detto contratto perchè costringe le classi che lo implementano a fare l'override di tutti i suoi metodi;
    //Tutti i metodi sono public e abstract;

    boolean fly();

    //da java8 le interfacce possono avere anche variabili
    //di default le variabili sono public static final
    //static = non si riferisce all'oggetto ma alla classe;

    int maxHeight = 1000;

    //Il default mi permete di creare metodi concreti dentro un'interfaccia
    //nelle classi che implementano l'interfaccia, non ci darà errore perchè non siamo obbligati a fare l'override
    //come per gli altri metodi
    default void acrobazia() {
        System.out.println("Sto facendo acrobazie");
    }
    default void qualcosa() {
        System.out.println("stampa qualcosa");
    }
}
