package interfacce;

public class Supereroe implements CanFly{

        int voloMassimo;
        public void  possoVolareCosiAlto(){
            if(voloMassimo>maxheight){
                System.out.println("Sono morto");
            }
        }


    @Override
    public boolean fly() {
        return false;
    }
}
