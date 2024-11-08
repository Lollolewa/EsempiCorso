package org.generation.italy.esempiCorso.ravenclaw.sql.ripassoStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Launch {
    public static void main(String[] args) {
        //tutti i miei missili
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
        Missile missile11 = new Missile("Arrow", "Israel", LocalDate.of(2016, 7, 5), 15000, LocalDateTime.of(2024, 11, 8, 10, 30));
        Missile missile12 = new Missile("Tempest", "USA", LocalDate.of(2019, 3, 1), 17000, LocalDateTime.of(2024, 11, 8, 11, 15));
        Missile missile13 = new Missile("Reaper", "Russia", LocalDate.of(2014, 10, 10), 13500, LocalDateTime.of(2024, 11, 8, 14, 55));
        Missile missile14 = new Missile("Dragon", "China", LocalDate.of(2020, 11, 23), 19000, LocalDateTime.of(2024, 11, 8, 17, 5));
        Missile missile15 = new Missile("Maverick", "North Korea", LocalDate.of(2013, 5, 15), 8000, LocalDateTime.of(2024, 11, 8, 18, 20));
        Missile missile16 = new Missile("Raven", "Pakistan", LocalDate.of(2018, 6, 6), 12000, LocalDateTime.of(2024, 11, 8, 13, 0));
        Missile missile17 = new Missile("Falcon-2", "India", LocalDate.of(2022, 1, 19), 12500, LocalDateTime.of(2024, 11, 8, 14, 35));
        Missile missile18 = new Missile("Shark", "Germany", LocalDate.of(2020, 3, 25), 11000, LocalDateTime.of(2024, 11, 8, 12, 5));
        Missile missile19 = new Missile("Puma", "France", LocalDate.of(2017, 10, 10), 16000, LocalDateTime.of(2024, 11, 8, 16, 45));
        Missile missile20 = new Missile("Leopard", "UK", LocalDate.of(2021, 12, 15), 14500, LocalDateTime.of(2024, 11, 8, 17, 50));
        Missile missile21 = new Missile("Raptor", "USA", LocalDate.of(2014, 4, 8), 18000, LocalDateTime.of(2024, 11, 8, 20, 15));
        Missile missile22 = new Missile("Blizzard", "Russia", LocalDate.of(2016, 11, 1), 16000, LocalDateTime.of(2024, 11, 8, 21, 30));
        Missile missile23 = new Missile("Eagle", "China", LocalDate.of(2015, 5, 30), 14000, LocalDateTime.of(2024, 11, 8, 22, 45));
        Missile missile24 = new Missile("Inferno", "India", LocalDate.of(2017, 3, 2), 12000, LocalDateTime.of(2024, 11, 8, 23, 10));
        Missile missile25 = new Missile("Typhoon", "North Korea", LocalDate.of(2019, 8, 14), 11000, LocalDateTime.of(2024, 11, 8, 12, 25));
        Missile missile26 = new Missile("Vortex", "Pakistan", LocalDate.of(2016, 6, 12), 13000, LocalDateTime.of(2024, 11, 8, 13, 40));
        Missile missile27 = new Missile("Dragonfly", "Israel", LocalDate.of(2015, 10, 22), 14000, LocalDateTime.of(2024, 11, 8, 11, 0));
        Missile missile28 = new Missile("Falcon-X", "France", LocalDate.of(2018, 2, 5), 15000, LocalDateTime.of(2024, 11, 8, 10, 30));
        Missile missile29 = new Missile("Griffin", "Germany", LocalDate.of(2019, 7, 18), 11000, LocalDateTime.of(2024, 11, 8, 9, 50));
        Missile missile30 = new Missile("Nightmare", "UK", LocalDate.of(2020, 5, 25), 15500, LocalDateTime.of(2024, 11, 8, 18, 0));
        Missile missile31 = new Missile("Tornado", "USA", LocalDate.of(2017, 12, 10), 17000, LocalDateTime.of(2024, 11, 8, 8, 30));
        Missile missile32 = new Missile("Pheonix-X", "Russia", LocalDate.of(2018, 9, 7), 16000, LocalDateTime.of(2024, 11, 8, 7, 0));
        Missile missile33 = new Missile("Leviathan", "China", LocalDate.of(2019, 4, 18), 18000, LocalDateTime.of(2024, 11, 8, 6, 15));
        Missile missile34 = new Missile("Apocalypse", "India", LocalDate.of(2021, 1, 12), 14000, LocalDateTime.of(2024, 11, 8, 5, 10));
        Missile missile35 = new Missile("Tempest-X", "North Korea", LocalDate.of(2020, 2, 28), 12000, LocalDateTime.of(2024, 11, 8, 4, 30));
        Missile missile36 = new Missile("Widowmaker", "Pakistan", LocalDate.of(2021, 3, 15), 13000, LocalDateTime.of(2024, 11, 8, 3, 40));
        Missile missile37 = new Missile("Cobra", "Israel", LocalDate.of(2016, 5, 5), 12500, LocalDateTime.of(2024, 11, 8, 2, 55));
        Missile missile38 = new Missile("Thunderstrike", "France", LocalDate.of(2019, 9, 20), 14500, LocalDateTime.of(2024, 11, 8, 1, 10));
        Missile missile39 = new Missile("Hurricane", "Germany", LocalDate.of(2020, 7, 10), 16000, LocalDateTime.of(2024, 11, 8, 0, 20));
        Missile missile40 = new Missile("Spectre", "UK", LocalDate.of(2021, 6, 30), 17500, LocalDateTime.of(2024, 11, 8, 23, 50));
        //tutte le mia nazioni
        Nation nation1 = new Nation("USA", " Donald John Trump.", 331000000, 70000, List.of(
                missile1, missile2, missile12, missile13, missile21, missile31
        ));

        Nation nation2 = new Nation("Russia", "Vladimir Putin", 145000000, 100000, List.of(
                missile3, missile2, missile13, missile6, missile22, missile32
        ));
        Nation nation3 = new Nation("China", "Xi Jinping", 1400000000, 200000, List.of(
                missile5, missile3, missile14, missile19, missile23, missile33
        ));
        Nation nation4 = new Nation("India", "Narendra Modi", 1380000000, 35000, List.of(
                missile4, missile7, missile17, missile24, missile34
        ));
        Nation nation5 = new Nation("North Korea", "Kim Jong-un", 25000000, 5000, List.of(
                missile5, missile15, missile25, missile35
        ));
        Nation nation6 = new Nation("Pakistan", "Arif Alvi", 225000000, 25000, List.of(
                missile6, missile16, missile26, missile36
        ));
        Nation nation7 = new Nation("Israel", "Isaac Herzog", 9000000, 7000, List.of(
                missile7, missile11, missile27, missile37
        ));
        Nation nation8 = new Nation("France", "Emmanuel Macron", 67000000, 45000, List.of(
                missile8, missile19, missile28, missile38
        ));
        Nation nation9 = new Nation("Germany", "Olaf Scholz", 83000000, 55000, List.of(
                missile9, missile18, missile20, missile29, missile39
        ));
        Nation nation10 = new Nation("UK", "Rishi Sunak", 67000000, 35000, List.of(
                missile10, missile20, missile12, missile30, missile40
        ));
        //--------------------------------------------------------------------------------------------------------------------------------------Il resto>
        List<Missile>allMissile = List.of(missile1, missile2, missile3, missile4, missile5, missile6, missile7, missile8,
                missile9, missile10, missile11, missile12, missile13, missile14, missile15, missile16, missile17, missile18,
                missile19, missile20, missile21, missile22, missile23, missile24, missile25, missile26, missile27, missile28,
                missile29, missile30, missile31, missile32, missile33, missile34, missile35, missile36, missile37, missile38,
                missile39, missile40);
//        System.out.println(getNumTargets(nation1));
//        System.out.println(getTargets(nation1));
//        System.out.println(isTargetingOther(nation2, nation3));
//        List<Missile> a = missileThaTargetNation(allMissile,nation5);
//        stampaNameMissili(a);
//        LocalDateTime x = LocalDateTime.of(2024, 11, 8, 23, 10);
//        List<Missile> b = missileLaunchOnDate(allMissile,x);
//        stampaNameMissili(b);
//        System.out.println(aoeAllMissile(nation7));
        var biggestMissile = maxAoeMissile(allMissile);
        System.out.println(biggestMissile.getName());
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
    //creo una funzione per stampare solo i nomi dei missili da una lista di missili
    public static void stampaNameMissili(List<Missile> o){
        for(Missile missile : o){
            System.out.println(missile.getName());
        }
    }

//Filtra i missili per paese: Scrivi una funzione che, data una lista di missili, ritorni una lista di missili che targettano una specifica nazione.
    public static List<Missile> missileThaTargetNation (List<Missile> missili, Nation nation){
         return missili.stream().filter(missile -> missile.getTarget().equals(nation.getName())).toList();
    }
//    Missili lanciati dopo una certa data Scrivi: una funzione che, data una lista di missili, ritorni tutti i missili che sono stati lanciati dopo una data specificata (usa LocalDateTime per filtrare).
public static List<Missile> missileLaunchOnDate(List<Missile> missili,LocalDateTime x){
        return missili.stream().filter(missile ->missile.getDol().equals(x)).toList();
}
//    Somma delle portate di tutti i missili di una nazione: Scrivi una funzione che, data una nazione, calcoli la somma della portata di tutti i missili associati a ciascuna nazione.
public static int aoeAllMissile (Nation nazione){
    return nazione.getMissileStream().mapToInt(Missile::getAoe).sum();
}
//    Trova il missile con la portata massima: Scrivi una funzione che ritorni il missile con la portata massima tra tutti i missili di una lista. Se ci sono missili con la stessa portata, restituisci il primo che appare.
public static Missile maxAoeMissile (List<Missile> missiles){
        return missiles.stream().max(Comparator.comparingInt(Missile::getAoe)).get();
    }
//    Calcola la media della portata dei missili per nazione: Scrivi una funzione che calcoli la media della portata dei missili per ciascuna nazione di una lista e ritorni la nazione con la media più alta;

//    public static Nation strongestNation (List<Nation> nations){
//        var y = nations.stream().flatMap(Nation::getMissileStream).max(Comparator.comparingInt(Missile))
//    }

//    Trova le nazioni che hanno più missili di una certa portata Scrivi una funzione che, dato un valore di portata, ritorni le nazioni che possiedono almeno un missile con una portata superiore a tale valore.
//    Numero di missili per nazione Scrivi una funzione che ritorni una mappa che associa ogni nazione al numero di missili che possiede. La chiave della mappa è il nome della nazione e il valore è il numero di missili.
//    Raggruppa missili per anno di produzione Scrivi una funzione che raggruppi i missili per anno di produzione e ritorni una mappa, dove la chiave è l'anno e il valore è una lista di missili prodotti quell'anno.
//    Nazioni con almeno un missile lanciato prima di una data Scrivi una funzione che ritorni tutte le nazioni che hanno almeno un missile la cui data di lancio è precedente a una data specifica.
//    Nazioni con missile più vecchio Scrivi una funzione che, data una lista di nazioni, ritorni il nome della nazione con il missile più vecchio in base alla data di produzione del missile.
}