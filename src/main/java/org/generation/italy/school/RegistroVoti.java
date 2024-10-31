package org.generation.italy.school;

import java.util.ArrayList;

public class RegistroVoti {
    ArrayList<Studente> registroStud = new ArrayList<>();

    public void aggiungiStudente(Studente studente){
        registroStud.add(studente);
    }
    public void registraVoto(String nomeStudente, int voto){
        for (Studente studente : registroStud){
            if (studente.getNome().equals(nomeStudente)) {
                studente.aggiungiVoto(voto);
                System.out.println("Voto registrato per " + nomeStudente);
                return;
            }
        }
        System.out.println("Studente non trovato");
    }
    public void visualizzaMedia(){
        for (Studente studente : registroStud) {
            System.out.println("La media di " + studente + " e': " + studente.calcolaMedia());
        }
    }
}

/*Crea una classe RegistroVoti:

Usa un ArrayList<Studente> per memorizzare gli studenti.
Metodi per:
Aggiungere uno studente.
Registrare un voto per uno studente.
Visualizzare la media dei voti per ogni studente.*/
