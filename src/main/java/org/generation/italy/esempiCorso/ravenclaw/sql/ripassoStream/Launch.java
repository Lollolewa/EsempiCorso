package org.generation.italy.esempiCorso.ravenclaw.sql.ripassoStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Launch {
    public static void main(String[] args) {
        Missile missile1 = new Missile("Viper", "USA", LocalDate.of(2015, 5, 10), 15000, LocalDateTime.of(2024, 11, 8, 15, 30));
        Missile missile2 = new Missile("Cyclone", "Russia", LocalDate.of(2018, 8, 15), 13000, LocalDateTime.of(2024, 11, 8, 17, 0));
        Missile missile3 = new Missile("Titan", "China", LocalDate.of(2012, 4, 12), 20000, LocalDateTime.of(2024, 11, 8, 18, 45));
        Missile missile4 = new Missile("Falcon", "India", LocalDate.of(2020, 3, 9), 12000, LocalDateTime.of(2024, 11, 8, 19, 30));
        Missile missile5 = new Missile("Wasp", "North Korea", LocalDate.of(2011, 7, 22), 8000, LocalDateTime.of(2024, 11, 8, 20, 0));
        Missile missile6 = new Missile("Phoenix", "Pakistan", LocalDate.of(2016, 9, 3), 11000, LocalDateTime.of(2024, 11, 8, 13, 50));
        Missile missile7 = new Missile("Hawk", "Israel", LocalDate.of(2019, 11, 10), 9000, LocalDateTime.of(2024, 11, 8, 16, 15));
        Missile missile8 = new Missile("Scorpion", "France", LocalDate.of(2017, 2, 1), 10000, LocalDateTime.of(2024, 11, 8, 12, 45));
        Missile missile9 = new Missile("Jaguar", "Germany", LocalDate.of(2021, 6, 25), 14000, LocalDateTime.of(2024, 11, 8, 14, 10));
        Missile missile10 = new Missile("Thunder", "UK", LocalDate.of(2014, 1, 8), 16000, LocalDateTime.of(2024, 11, 8, 13, 30));
        Nation nation1 = new Nation("USA", "Joe Biden", 331000000, 70000, List.of(missile1, missile2));
        Nation nation2 = new Nation("Russia", "Vladimir Putin", 145000000, 100000, List.of(missile3, missile4));
        Nation nation3 = new Nation("China", "Xi Jinping", 1400000000, 200000, List.of(missile5));
        Nation nation4 = new Nation("India", "Narendra Modi", 1380000000, 35000, List.of(missile6, missile7));
        Nation nation5 = new Nation("North Korea", "Kim Jong-un", 25000000, 5000, List.of(missile8));
        Nation nation6 = new Nation("Pakistan", "Arif Alvi", 225000000, 25000, List.of(missile9));
        Nation nation7 = new Nation("Israel", "Isaac Herzog", 9000000, 7000, List.of(missile10));
        Nation nation8 = new Nation("France", "Emmanuel Macron", 67000000, 45000, List.of(missile1));
        Nation nation9 = new Nation("Germany", "Olaf Scholz", 83000000, 55000, List.of(missile2, missile3));
        Nation nation10 = new Nation("UK", "Rishi Sunak", 67000000, 35000, List.of(missile4, missile5));

        System.out.println(getNumTargets(nation1));
        System.out.println(getTargets(nation1));
        System.out.println(isTargetingOther(nation2, nation3));
    }
    //data una nazione dice a quante nazioni sta sparando i missili
    public static long getNumTargets(Nation nation){
        return nation.getMissileStream()
                     //.map(new MissileMapper()) o così
                     //.map(m -> m.getLocation()) o così
                     .map(Missile::getTarget) //o così
                     .distinct()
                     .count();
    }
    //data una nazione dice i nomi delle nazioni dove sta sparando i missili
    public static List<String> getTargets(Nation nation){
        return nation.getMissileStream()
                     .map(Missile::getTarget)
                     .distinct()
                     .toList();
    }
    //un metodo che prende due nazioni dice se la prima ha come target la seconda
    public static boolean isTargetingOther(Nation source, Nation target){
        return source.getMissileStream()
                     //.map(Missile::getLocation) così carino ma meglio sotto
                     .anyMatch(m -> m.getTarget().equals(target.getName()));
    }
    //una funzione che data una lista di nazioni in input e una nazione (target) e questo metodo deve restituire una
    //booleana che dice se la somma di tutte le aree di tutti i missili è maggiore dell'area della nazione target
    public static List<Nation> findAnnihilatingNations(List<Nation> source, Nation target){
        return source.stream()
                     .filter(n -> n.getMissileStream()
                             .mapToInt(Missile::getAoe).sum() > target.getArea())
                     .toList();
    }
    //data una lista di nazioni voglio avere come risultato l'area totale che distruggerebbero con i loro missili
    public static int getTotalAreaDestroyed(List<Nation> nations){
        return nations.stream()
                      .flatMap(Nation::getMissileStream)
                              .mapToInt(Missile::getAoe).sum();
    }
//    Filtra i missili per paese Scrivi una funzione che, data una lista di missili, ritorni una lista di missili che appartengono a una specifica nazione.
//    Missili lanciati dopo una certa data Scrivi una funzione che, data una lista di missili, ritorni tutti i missili che sono stati lanciati dopo una data specificata (usa LocalDateTime per filtrare).
//    Somma delle portate di tutti i missili di una nazione Scrivi una funzione che, data una lista di nazioni, calcoli la somma della portata di tutti i missili associati a ciascuna nazione.
//    Trova il missile con la portata massima Scrivi una funzione che ritorni il missile con la portata massima tra tutti i missili di una lista. Se ci sono missili con la stessa portata, restituisci il primo che appare.
//    Calcola la media della portata dei missili per nazione Scrivi una funzione che calcoli la media della portata dei missili per ciascuna nazione e ritorni un Map<String, Double>, dove la chiave è il nome della nazione e il valore è la media della portata.
//    Trova le nazioni che hanno più missili di una certa portata Scrivi una funzione che, dato un valore di portata, ritorni le nazioni che possiedono almeno un missile con una portata superiore a tale valore.
//    Numero di missili per nazione Scrivi una funzione che ritorni una mappa che associa ogni nazione al numero di missili che possiede. La chiave della mappa è il nome della nazione e il valore è il numero di missili.
//    Raggruppa missili per anno di produzione Scrivi una funzione che raggruppi i missili per anno di produzione e ritorni una mappa, dove la chiave è l'anno e il valore è una lista di missili prodotti quell'anno.
//    Nazioni con almeno un missile lanciato prima di una data Scrivi una funzione che ritorni tutte le nazioni che hanno almeno un missile la cui data di lancio è precedente a una data specifica.
//    Nazioni con missile più vecchio Scrivi una funzione che, data una lista di nazioni, ritorni il nome della nazione con il missile più vecchio in base alla data di produzione del missile.
}