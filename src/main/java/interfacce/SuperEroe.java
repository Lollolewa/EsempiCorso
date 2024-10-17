package interfacce;

public class SuperEroe extends Persona implements CanFly{
    public int voloMassimo;
    public void possoVolareCosiAlto(){
        if(voloMassimo>maxHeight){
            System.out.println("Sei morto");
        }else{
            System.out.println("Puoi volare");
        }
    }
    @Override
    public boolean fly() {
        faiAcrobazia();
        return false;
    }
    @Override
    public void faiAcrobazia(){
        System.out.println("x");
    }
}
