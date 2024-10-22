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

    public List<Programmer> findByAgeGreaterThan(int age) {
        return programmers.stream().filter(p -> p.getAge() > age).toList();
    }

    public double findTotalMaleSalary() {
        return programmers.stream().filter(Programmer :: isMale)
                                    .mapToDouble(Programmer::getSalary)
                                    .sum();
        // non posso fare uno stream di primitive, perchè gli generics lavorano con gli objects, non con le primitive
        // mapToQualcosa rappresenta una trasformazione da uno stream di un tipo a uno stream di un altro tipo
    }

    public List<String> findMaleSurnames() {
        return programmers.stream().filter(Programmer :: isMale)
                                    .map(Programmer::getSurname)
                                    .distinct()
                                    .toList();
    }

    public boolean isJusticeIsMade(){
//        var optPM = programmers.stream().filter(Programmer :: isMale)
//                                    .min((p1,p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
//        var optPF = programmers.stream().filter(Programmer :: isFemale)
//                                    .min((p1,p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
//        if(optPM.isEmpty() && optPF.isEmpty()){
//            return false;
//        } else {
//            return optPM.get().getSalary() > optPF.get().getSalary();
//        }
        var optMSal =programmers.stream().filter(Programmer :: isMale).mapToDouble(Programmer::getSalary).min();
        var optFSal = programmers.stream().filter(Programmer :: isFemale).mapToDouble(Programmer::getSalary).min();
        if(optMSal.isEmpty() && optFSal.isEmpty()){
            return false;
        } else {
            return optMSal.getAsDouble() > optFSal.getAsDouble();
        }
    }

    //dobbiamo stampare tutti programmatori in ordine decrescente per numero di linguaggi conosciuti
    public void printProgrammersByLanguages(){
        programmers.stream().sorted((p1, p2) -> p1.getNumLanguages() - p2.getNumLanguages()).forEach(p -> System.out.println(p));
    }
}
