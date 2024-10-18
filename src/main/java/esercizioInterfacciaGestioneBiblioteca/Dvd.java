package esercizioInterfacciaGestioneBiblioteca;

public class Dvd implements Risorsa{
    String title;
    String director;
    int duration;
    boolean isAvailable;

    public Dvd(String title, String director, int duration, boolean isAvailable){
        this.title = title;
        this.director = director;
        this.duration = duration;
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
