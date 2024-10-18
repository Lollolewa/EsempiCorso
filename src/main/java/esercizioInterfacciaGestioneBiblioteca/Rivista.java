package esercizioInterfacciaGestioneBiblioteca;

public class Rivista implements Risorsa{
    String title;
    int numVolume;
    int publicationDate;
    boolean isAvailable;

    public Rivista (String title,int numVolume, int publicationDate, boolean isAvailable){
        this.title = title;
        this.numVolume = numVolume;
        this.publicationDate = publicationDate;
        this.isAvailable = isAvailable;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void lend() {
        isAvailable = false;
    }

    @Override
    public void giveBack() {
        isAvailable = true;
    }
}
