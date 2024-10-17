package interfacce;

public interface CanFly{
//viene detta tipo astratto, è un contratto, perchè costringe le classi che lo implementano a fare l'override di tutti i suoi metodi
    boolean fly();
    // le variabili sono public, static e final. Static = si riferisce alla classe e non all'oggetto.
    int maxHeight = 1000;

    // posso creare metodi concreti dentro un interfaccia se sono default

    default void faiAcrobazia(){
        System.out.println("Sto facendo acrobazie");
    }
    default void qualcosa(){
        System.out.println("si");
    }
}
