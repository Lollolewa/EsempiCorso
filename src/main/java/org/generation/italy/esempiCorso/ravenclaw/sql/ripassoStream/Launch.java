package org.generation.italy.esempiCorso.ravenclaw.sql.ripassoStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Launch {
    public static void main(String[] args) {
        Missile missile1 = new Missile("Bobby", "America", LocalDate.of(1996, 10, 10),
                10000, LocalDateTime.of(2024, 11, 8, 13, 19));
        Missile missile2 = new Missile("Franco", "America", LocalDate.of(1986, 2, 3),
                1000, LocalDateTime.of(2024, 11, 8, 13, 19));
        Missile missile3 = new Missile("Gennarino", "Israele", LocalDate.of(2000, 10, 11),
                7500, LocalDateTime.of(2024, 11, 8, 13, 0));
        Missile missile4 = new Missile("Topolin", "Russia", LocalDate.of(2009, 2, 9),
                10000, LocalDateTime.of(2024, 11, 8, 20, 0));

        Nation nation1 = new Nation("America", "Donald Trump", 300000000, 10000, List.of(missile3, missile4));
        Nation nation2 = new Nation("Russia", "Vladimir Putin", 250000000, 90000, List.of(missile1));
        Nation nation3 = new Nation("Israele", "Isaac Herzog", 100000000, 5000, List.of(missile2));

        System.out.println(getNumTargets(nation1));
        System.out.println(getTargets(nation1));
        System.out.println(isTargetingOther(nation2, nation3));
    }
    //data una nazione dice a quante nazioni sta sparando i missili
    public static long getNumTargets(Nation nation){
        return nation.getMissileStream()
                     //.map(new MissileMapper()) o così
                     //.map(m -> m.getLocation()) o così
                     .map(Missile::getLocation) //o così
                     .distinct()
                     .count();
    }
    //data una nazione dice i nomi delle nazioni dove sta sparando i missili
    public static List<String> getTargets(Nation nation){
        return nation.getMissileStream()
                     .map(Missile::getLocation)
                     .distinct()
                     .toList();
    }
    //un metodo che prende due nazioni dice se la prima ha come target la seconda
    public static boolean isTargetingOther(Nation source, Nation target){
        return source.getMissileStream()
                     //.map(Missile::getLocation) così carino ma meglio sotto
                     .anyMatch(m -> m.getLocation().equals(target.getName()));
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
}