package interfacce.spiegazione;

public class Supereroe extends Persona implements CanFly{
    int maxFly;

    public void canFlyThisHigh(){
        if (maxFly>maxHeight){
            System.out.println("die");
        }
    }
    @Override
    public boolean fly(){
        return false;
    }
    @Override
    public void trial(){
        System.out.println("ciao!!1!1!");
    }
}
