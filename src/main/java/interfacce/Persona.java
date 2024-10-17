package interfacce;

public class Persona {
    String nome, cognome;
    public static int maxAge = 120;             //questa variabile non riguarderà ogni singola persona che crei.
    public static final int staticMaxAge = 120;//non riguardano l'oggetto preso singolarmente ma l'intera classe dell'oggetto.
                                              //tant'è che andando a scrivere p. (piccolo) per richiamare i metodi e le variabili di persona
                                             // ad un oggetto persona, non ci apparirà maxAge perchè non è una variabile relativa all'oggetto singolo
                                            // ma relativa alla classe intera dell'oggetto, quindi scrivendo Persona. il maxAge apparirà

                                    //inserendo il final stiam dicendo che non vogliamo che la costante venga modificata nel corso del programma
                                   //perciò non verrà modificata nella main ecc


}
