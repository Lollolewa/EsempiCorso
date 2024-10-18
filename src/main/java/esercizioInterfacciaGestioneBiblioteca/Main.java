package esercizioInterfacciaGestioneBiblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.addResource(new Libro("Il Codice Da Vinci", "Dan Brown", 570, true));
        biblioteca.addResource(new Rivista("Corriere Dello Sport",28, 2024, true));
        biblioteca.addResource(new Dvd("Il grande colpo","Kirk Wong", 91, true));
        biblioteca.addResource(new Libro("La Divina Commedia", "Dante Alighieri", 773, false));
        biblioteca.addResource(new Rivista("AlVolante", 80, 2003 , false));
        biblioteca.addResource(new Dvd("Pulp Fiction", "Quentin Tarantino", 150, false));

        biblioteca.showAvailableResources();
    }
}
