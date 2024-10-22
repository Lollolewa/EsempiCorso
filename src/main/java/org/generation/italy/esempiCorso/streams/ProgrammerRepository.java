package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammerRepository {
    private List<Programmer> programmers = List.of(
            new Programmer("mario", "Cock", true, LocalDate.of(1980, 6,12),2000,
                    List.of("java", "javascript", "python") ),
            new Programmer("mario", "Cock", false, LocalDate.of(1980, 6,12),2000,
            List.of("java", "javascript", "python") ),
            new Programmer("mario", "Cock", true, LocalDate.of(1980, 6,12),2000,
            List.of("java", "javascript", "python") ),
            new Programmer("mario", "Cock", true, LocalDate.of(1980, 6,12),2000,
                    List.of("java", "javascript", "python") ),
            new Programmer("mario", "Cock", true, LocalDate.of(1980, 6,12),2000,
                    List.of("java", "javascript", "python") )
    );
    public List<Programmer> findFemales() {
        List<Programmer> femaleProgrammers = new ArrayList<>();
        for (Programmer p : programmers) {
            if (p.isMale()) {
                femaleProgrammers.add(p);

            }
        }
        return femaleProgrammers;

    }
    public List<Programmer> findFemalesWithStream(){
//        var ps = programmers.stream();
//        ProgrammerFilterbySex pFS = new ProgrammerFilterbySex();
//        var z = ps.filter(p -> !p.isMale());
//        var result = z.toList();
    return programmers.stream().filter(Programmer::isFemale).toList();
    }
    public List<Programmer> findBySalaryGreaterThan(double salary){
        return programmers.stream().filter(p -> p.getSalary() > salary).toList();
    }


}
