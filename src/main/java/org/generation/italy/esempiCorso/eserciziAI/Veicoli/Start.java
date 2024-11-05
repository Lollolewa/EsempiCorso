package org.generation.italy.esempiCorso.eserciziAI.Veicoli;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Start {

    public static void main(String[] args){
        List <Auto> autos = new ArrayList<>();
        Auto a1 = new Auto("panda", "auto", 1938, 100);
        Auto a2 = new Auto("mercedes", "auto", 2024, 170);
        Auto a3 = new Auto("golf", "auto", 2012, 215);
        Auto a4 = new Auto("smart", "auto", 1999, 140);
        Moto m1 = new Moto("honda", "moto", 2010, 190);
        Moto m2 = new Moto("yamaha", "moto", 2016, 220);
        Moto m3 = new Moto("kawasaki", "moto", 2020, 240);
        Moto m4 = new Moto("ducati", "moto", 2000, 200);
        List<Veicolo> veicoli = new ArrayList<>();
//        for (Auto a : veicoli){
//            veicoli.add(v);
//        }
        System.out.println(veicoli.size());
    }


}

 /*Descrizione del problema:
    Creiamo un sistema che gestisce diversi tipi di veicoli (come Auto e Moto), utilizzando incapsulamento, ereditarietà e polimorfismo.
    Ogni veicolo ha delle caratteristiche generali (ad esempio, modello, anno, velocità massima). Vogliamo anche usare una lista per mantenere una collezione di veicoli e iterare attraverso di essa per stampare le informazioni di ogni veicolo.

1. Incapsulamento:
    Ogni veicolo ha attributi privati, e li gestiamo tramite metodi getter e setter.

            2. Ereditarietà:
    Auto e Moto erediteranno dalla classe base Veicolo.

            3. Polimorfismo:
    Utilizziamo una lista per contenere oggetti di tipo Veicolo (ma che possono essere Auto o Moto) e stampiamo le informazioni usando il metodo toString(), che sarà sovrascritto nelle classi derivate.

            4. Implementazione di Interfacce:
    Creiamo un'interfaccia VeicoloMotorizzato che richiede la definizione del metodo accelera().

            5. Liste e Cicli:
    Useremo una lista per mantenere gli oggetti di tipo Veicolo e itereremo su di essa con un ciclo for per stampare le informazioni. */
