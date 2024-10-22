package eserciziEccezioni.esercizio1;

public class StringaVuotaException extends RuntimeException{
    public StringaVuotaException(String message){
        super(message);
    }
    public StringaVuotaException(String message, Throwable causa){
        super(message, causa);
    }
}
