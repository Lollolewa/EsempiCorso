package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammerRepository {
    private List<Programmer> programmers = List.of(
            new Programmer("Mario", "Rossi", true, LocalDate.of(1980, 6, 12), 1700, List.of("java", "javascript", "python")),
            new Programmer("Maria", "Verdi", false, LocalDate.of(1985, 6, 12), 1700, List.of("java", "ruby")),
            new Programmer("Pietro", "Marinari", true, LocalDate.of(2001, 6, 12), 1300, List.of("java")),
            new Programmer("Marco", "DeRossi", true, LocalDate.of(1975, 6, 12), 2000, List.of("java", "ruby")),
            new Programmer("Franca", "Pappa", false, LocalDate.of(1988, 6, 12), 1700, List.of("java", "ruby", "c"))
    );

    public List<Programmer> findFemales(){
        List<Programmer> femalesProgrammers = new ArrayList<>();
        for (Programmer p: programmers) {
            if (!p.isMale()) {
                femalesProgrammers.add(p);
            }
        }
        return femalesProgrammers;
    }
    public List<Programmer> findFemalesWithStreams(){
//        var ps = programmers.stream();
//        ProgrammerFilterBySex pFS = new ProgrammerFilterBySex();
//        var z = ps.filter(p -> !p.isMale());
//        var result = z.toList();
//        return result;
        return programmers.stream().filter(Programmer::isFemale).toList();
    }
    public List<Programmer> findBySalaryGreaterThan(double salary) {
        return programmers.stream().filter(p -> p.getSalary() > salary).toList();
    }
}
