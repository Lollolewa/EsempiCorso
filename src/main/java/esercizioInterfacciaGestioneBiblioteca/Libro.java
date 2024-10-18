package esercizioInterfacciaGestioneBiblioteca;

public class Libro implements Risorsa{
    String title;
    String author;
    int numPages;
    boolean isAvailable;

    public Libro(String title, String author, int numPages, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.numPages = numPages;
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
