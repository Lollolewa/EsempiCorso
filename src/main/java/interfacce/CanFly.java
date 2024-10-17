package interfacce;

public interface CanFly {
//tipo astratto, detto contratto perchè costringe le classi che lo implementano a fare l'override di tutti i suoi metodi
//tutti i metodi sono public e abstract

    boolean fly();

    //da java8 le interfacce possono avere anche variabili
    //di default sono public e static e final
    //static = non riferita all'oggetto ma alla classe

    int maxHeight = 1000;

    //posso creare metodi concreti dentro un interfaccia se sono default
    //spoiler non si usa
    default void faiAcrobazie(){
        System.out.println("sto facendo acrobazie");
    }
    default void qualcosa(){
        System.out.println("non so che scrivere");
    }
}
