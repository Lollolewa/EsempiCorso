package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class ProgrammerRepository {
    private List<Programmer> programmers = List.of(
            new Programmer("Mario", "Rossi", true, LocalDate.of(1992, 12, 30), 2000.00, List.of("Java", "JavaScript", "Python", "C++")),
            new Programmer("Luigi", "Verdi", true, LocalDate.of(1992, 12, 30), 2200.00, List.of("Java", "JavaScript", "Python", "C++")),
            new Programmer("Gennaro", "Ciano", true, LocalDate.of(1992, 12, 30), 1700.00, List.of("Java", "Python", "C++")),
            new Programmer("Maria", "Grigi", false, LocalDate.of(1992, 12, 30), 1100.00, List.of("Java", "Swift", "C")),
            new Programmer("Pietro", "Blu", true, LocalDate.of(1992, 12, 30), 2000.00, List.of("Java", "JavaScript", "Python", "C++")),
            new Programmer("Lucia", "Neri", false, LocalDate.of(1992, 12, 30), 4000.00, List.of("Ruby", "Swift"))
    );

//    public List<Programmer> findFemales(){
//        List<Programmer> femalesProgrammers = List.of();
//        for (Programmer p : programmers){
//            if (!p.isMale()){
//                femalesProgrammers.add(p);
//            }
//        }
//        return femalesProgrammers;
//    }
    public List<Programmer> findFemalesWithStreams(){
//    var ps = programmers.stream();
//    ProgrammerFilterBySex pFS = new ProgrammerFilterBySex();
//    var z = ps.filter(p ->!p.isMale());
//    var result = z.toList();
//    return result;
    return programmers.stream().filter(p ->!p.isMale()).toList();
    }
    public List<Programmer> findProgrammersWithSalaryAbove(double salary){
        return programmers.stream().filter(p -> p.getSalary() > salary).toList();
    }
    public List<Programmer> findByAgeAbove(int age){
        return programmers.stream().filter(p -> p.getAge() > age).toList();
    }
    public double findSalarySumForMaleProgrammers(double salary) {
        return programmers.stream().filter(Programmer::isMale)
                                   .mapToDouble(Programmer::getSalary)
                                   .sum();
    }
    public List<String> findMaleSurname() {
        return programmers.stream().filter(Programmer::isMale)
                                   .map(Programmer::getSurname)
                                   .distinct()
                                   .toList();
    }
    public boolean justiceIsServed() { //programma che ritorna true se il salary massimo di una female è minore del salary minore di male
        var optPM = programmers.stream().filter(Programmer::isMale).min((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
        var optPF = programmers.stream().filter(Programmer::isFemale).max((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
        if(optPF.isPresent() && optPM.isPresent()){
            return optPM.get().getSalary() > optPF.get().getSalary();
        }
        return false;
    }
    //dobbiamo stampare tutti i programmatori in ordine decrescente per numero di linguaggi conosciuti
    public void findProgrammersByLanguageCountDescending() {
        programmers.stream()
                   .sorted(Comparator.comparingInt(Programmer::getLanguageCount))
                   .forEach(System.out::println);
    }
}
