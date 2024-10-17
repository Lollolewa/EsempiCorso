package interfacce;

public interface CanFly {
    int maxHeight = 1000;
    boolean fly();
    default void faiAcrobazia(){
        System.out.println("sto facendo acrobazie");
    }

    default void trial(){
        System.out.println("ciao!");
    }
    default void something(){
        System.out.println("boh");
    }
}
