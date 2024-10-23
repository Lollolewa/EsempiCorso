package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.*;

public class ProgrammerRepository {
    private List<String> linguaggi = new ArrayList<>(List.of("java", "c++"));
    private List<Programmer> programmers = List.of(
            new Programmer("Mario", "Rossi", true, LocalDate.of(1980, 6, 12), 1700, List.of("java", "javascript", "python")),
            new Programmer("Maria", "Verdi", false, LocalDate.of(1985, 6, 12), 1700, List.of("java")),
            new Programmer("Pietro", "Marinari", true, LocalDate.of(2001, 6, 12), 1300, List.of("java")),
            new Programmer("Marco", "DeRossi", true, LocalDate.of(1975, 6, 12), 2000, List.of("java")),
            new Programmer("Franca", "Pappa", false, LocalDate.of(1988, 6, 12), 1700, List.of("java", "c"))
    );

    public List<Programmer> findFemales(){
        //linguaggi.clear();
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
    public List<Programmer> findByAgeGreaterThan(int age){
        return programmers.stream().filter(p -> p.getAge() > age).toList();
    }
    public double findTotalMaleSalary(){
       return programmers.stream().filter(Programmer::isMale)
                                  .mapToDouble(Programmer::getSalary)
                                  .sum();
    }
    public List<String> findMaleSurnames(){  //map sostituisce il programmatore con il suo cognome
      return programmers.stream().filter(Programmer::isMale)
                                 .map(Programmer::getSurname)
                                 .distinct()
                                 .toList();
    }
    //una booleana che ritorna true quando lo stipendio massimo di una female è minore del minimo stipendio di un male
    public boolean justiceIsMade(){
//        Optional<Programmer> optPM = programmers.stream().filter(Programmer::isMale).min((p1, p2) ->Double.compare(p1.getSalary(), p2.getSalary()));
//        Optional<Programmer> optPF = programmers.stream().filter(Programmer::isFemale).max((p1, p2) ->Double.compare(p1.getSalary(), p2.getSalary()));
//        if(optPM.isPresent() && optPF.isPresent()){
//            return optPM.get().getSalary() > optPF.get().getSalary();
//        }
//        return false;
        OptionalDouble optMSal = programmers.stream().filter(Programmer::isMale).mapToDouble(Programmer::getSalary).min();
        OptionalDouble optFSal = programmers.stream().filter(Programmer::isFemale).mapToDouble(Programmer::getSalary).max();
        if(optMSal.isPresent() && optFSal.isPresent()){
            return optMSal.getAsDouble() > optFSal.getAsDouble();
        }
        return false;
    }
    //dobbiamo stampare tutti i programmatori in ordine decrescente per numero di linguaggi conosciuti
    public void printProgrammersByLangueges(){
        programmers.stream().sorted(Comparator.comparingInt(Programmer::getNumLanguages)).forEach(System.out::println);
    }

}
