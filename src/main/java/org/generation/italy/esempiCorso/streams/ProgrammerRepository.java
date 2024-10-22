package org.generation.italy.esempiCorso.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammerRepository {
    private List<Programmer> programmers = List.of(
            new Programmer("Mario", "Rossi", true, LocalDate.of(1980, 6, 20), 1700, List.of("java", "python", "javascript")),
            new Programmer("Luigi", "Verdi", true, LocalDate.of(1975, 6, 20), 1400, List.of("ruby", "c++")),
            new Programmer("Pietro", "Gialli", true, LocalDate.of(1960, 6, 20), 1900, List.of("java")),
            new Programmer("Patrizio", "Azzurri", true, LocalDate.of(1995, 6, 20), 1500, List.of("c++", "javascript")),
            new Programmer("Francesco", "Violi", true, LocalDate.of(1989, 6, 20), 1600, List.of("python", "javascript"))
    );

    public List<Programmer> findFemales() {
        List<Programmer> females = new ArrayList<>();
        for (Programmer p : programmers) {
            if (!p.isMale()) {
                females.add(p);
            }
        }
        return females;
    }

    public List<Programmer> findFemalesWithStream() {
        programmers.stream(); //metodo dichiarato nell'interfaccia Collection
        //var è un tipo dedotto , ti dice il tipo di quello che c'è a destra dell'uguale
        //var ps = programmers.stream();
        //ProgrammerFilterBySex pfs = new ProgrammerFilterBySex();
        //ps.filter(pfs); //operatore di secondo ordine, una funzione che ha bisogno di un altra funzione per poter funzionare
        //ps.filter(p->!p.isMale());
        //var z = ps.filter(p -> !p.isMale()); // var in questo caso è di tipo Stream
        //var result = z.toList(); //result è una Lista di Programmatori
        //return result;
        return programmers.stream().filter(p -> !p.isMale()).toList(); //con lambda
        //riassunto di tutto quello che c'è sopra in una riga
        //return programmers.stream().filter(Programmer::isFemale).toList() // con method reference
    }
    //lambda = un oggetto di una classe che implementa un interfaccia, il metodo da implementare viene implementato secondo il codice che dice la lambda
    //con una lambda posso implementare oggetti di una classe che implementa un interfaccia che ha un solo metodo astratto
    //sam interfaces o functional interfaces = singol abstract method;

    public List<Programmer> findBySalaryGreatestThan(double salary) {
        return programmers.stream().filter(p -> p.getSalary() > salary).toList();
    }

    public List<Programmer> findByAgeGreaterThan(int age) {
        return programmers.stream().filter(p -> p.getAge() > age).toList();
    }

    public double findTotalMaleSalary() {
        return programmers.stream().filter(Programmer::isMale)
                .mapToDouble(Programmer::getSalary)
                .sum(); //mapToDouble trasforma l'oggetto in una primitiva double
    }

    public List<String> findMaleSurnames() {
        return programmers.stream().filter(Programmer::isMale)
                .map(p -> p.getSurname()) //prende in input il programmatore e torna il cognome
                .distinct()
                .toList();
    }
    public boolean justiceIsMade(){
        //return programmers.stream().filter(Programmer::isMale).min(Comparator.comparingDouble()::get)
        var optPM= programmers.stream().filter(Programmer::isMale).min((p1,p2)->Double.compare(p1.getSalary(),p2.getSalary()));
        var optPF= programmers.stream().filter(Programmer::isFemale).max((p1,p2)->Double.compare(p1.getSalary(),p2.getSalary()));
        if(optPM.isPresent()&&optPF.isPresent()){
            return optPM.get().getSalary()>optPF.get().getSalary();
            //.get() metodo che si chiama sull'optional per chiedere il suo contenuto
        }
        return false;
    }
    //stampa i programmatori in ordine decrescente per nnumero di linguaggi conosciuti
    public void printProgrammersByLanguages(){
        programmers.stream().sorted((p1,p2)->p1.getNumLanguages()- p2.getNumLanguages()).forEach(System.out::println);
        //programmers.stream().sorted(Comparator.comparingInt(Programmer::getNumLanguages).forEach(System.out::println);
    }
}
