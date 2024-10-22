package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammerRepository {
    private List<Programmer> programmers = List.of(

            new Programmer("Cristoforo", "Colombo", true, LocalDate.of(1980, 10, 15), 10000, List.of("Java", "C++")),
            new Programmer("Natasha", "Carrara", false, LocalDate.of(1987, 12, 22), 12000, List.of("C#", "Python")),
            new Programmer("Alice", "Lanza", false, LocalDate.of(1981, 1, 13), 11000, List.of("JavaScript", "PHP", "Python")),
            new Programmer("Pietro", "Marinari", true, LocalDate.of(1999, 5, 6), 21000, List.of("JavaScript", "PHP")),
            new Programmer("Naruto", "Uzumaki", true, LocalDate.of(1995, 5, 5), 30000, List.of("C#", "Python"))
    );

    public List<Programmer> findFemales() {
        List<Programmer> females = new ArrayList<>();
        for(Programmer programmer : programmers) {
            if(!programmer.isMale()){
                females.add(programmer);
            }
        }
        return females;
    }

    public List<Programmer> findFemalesWithStreams() {
        var ps = programmers.stream(); //assegno tramite var la lista in uno stream (dichiarato nella Collection)
        // un oggetto di una classe che implementa un'interfaccia viene implementato tramite la lambda
        // l'interfaccia usata dalla lambda deve avere solo un metodo astratto, quindi nelle lambda non posso implementare interfacce con più metodi astratti

        ProgrammerFilterBySex pFS = new ProgrammerFilterBySex();
        ps.filter(pFS);
    }
}
