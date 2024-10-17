package Interfacce;

public interface CanFly {

    //viene detto contratto, è un tipo astratto
    //le classi che lo implementano sono costretti a fare l'override
    boolean isFly();

    int maxHeight = 1000;
    //di default sono public static final
    //static= non si

    //default, posso creare metodi concreti dentro all'interfaccia

    default void acrobazia(){
        System.out.println("sto facendo acrobazia");
    }
    default void qualcosa(){
        System.out.println("non so che scrivere");
    }

}
