package org.generation.italy.esempiCorso.slytherin.exercises.sortingHat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingHat {
    private List<Student> gryffindor = new ArrayList<>(), hufflepuff = new ArrayList<>(), ravenclaw = new ArrayList<>(), slytherin = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public SortingHat(List<Student> gryffindor, List<Student> hufflepuff, List<Student> ravenclaw, List<Student> slytherin) {
        this.gryffindor = gryffindor;
        this.hufflepuff = hufflepuff;
        this.ravenclaw = ravenclaw;
        this.slytherin = slytherin;
    }

    public void askSetPreference(Student s) {
        String answer;
        System.out.println("Benvenuti al sorteggio del Cappello Parlante!");
        do{
            System.out.println(s.getName() + ", hai una preferenza? ('si' o 'no')");
            answer = sc.nextLine();
        }while(answer == null || !answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("no"));

        if(answer.equalsIgnoreCase("si")) {
            System.out.println("Qual'è la tua preferenza?");
            String preference = sc.nextLine();
            boolean boo = false;
            for (House h : House.values()) {
                if (preference.equalsIgnoreCase(h.name())) {
                    s.setPreference(h);
                    boo = true;
                }
            }
            if (!boo) {
                System.out.println("risposta non valida, riprova");
                askSetPreference(s);
            }
        } else if (answer.equalsIgnoreCase("no")) {
            System.out.println("booooring");
        } else {
            System.out.println("risposta non valida, riprova");
            askSetPreference(s);
        }
    }

    public SortingHat sortingHat(Students students) {
        Collections.shuffle(students.getStudentList());
        int standardHouseSize = students.getStudentList().size() / (House.values().length - 1);
        int extendedHousesNum = students.getStudentList().size() % (House.values().length - 1);
        SortingHat listedStudents = new SortingHat(gryffindor, hufflepuff, ravenclaw, slytherin);
        int gryffindorCount = 0,  hufflepuffCount = 0, ravenclawCount = 0, slytherinCount = 0;

        for (Student s : students.getStudentList()) {
            askSetPreference(s);
            boolean validPlacement = false;
            do {
                if (s.getPreference() != House.NONE && Math.random() > 0.5) {
                    switch (s.getPreference().name()) {
                        case "GRYFFINDOR" -> {
                            if (gryffindorCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.gryffindor.add(s);
                                gryffindorCount++;
                                validPlacement = true;
                                System.out.println("Che fortuna, sei stato assegnato a gryffindor!!!");
                                if (gryffindorCount > standardHouseSize) {
                                    extendedHousesNum --;
                                    gryffindorCount ++;
                                }
                            }
                        }
                        case "HUFFLEPUFF" -> {
                            if (hufflepuffCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.hufflepuff.add(s);
                                hufflepuffCount++;
                                validPlacement = true;
                                System.out.println("Sei stato assegnato a hufflepuff!!!");
                                if (hufflepuffCount > standardHouseSize) extendedHousesNum--;
                            }
                        }
                        case "RAVENCLAW" -> {
                            if (ravenclawCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.ravenclaw.add(s);
                                ravenclawCount++;
                                validPlacement = true;
                                System.out.println("Sei stato assegnato a ravenclaw!!!");
                                if (ravenclawCount > standardHouseSize) {
                                    extendedHousesNum--;
                                    ravenclawCount ++;
                                }
                            }
                        }
                        case "SLYTHERIN" -> {
                            if (slytherinCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.slytherin.add(s);
                                slytherinCount++;
                                validPlacement = true;
                                System.out.println("Sei stato assegnato a slytherin!!!");
                                if (slytherinCount > standardHouseSize) {
                                    extendedHousesNum--;
                                    slytherinCount ++;
                                }
                            }
                        }
                    }
                } else {
                    int temp = (int) (Math.random() * 4);
                    switch (temp) {
                        case 0 -> {
                            if (gryffindorCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.gryffindor.add(s);
                                gryffindorCount++;
                                validPlacement = true;
                                System.out.println("Sei stato assegnato a gryffindor!!!");
                                if (gryffindorCount > standardHouseSize) {
                                    extendedHousesNum--;
                                    gryffindorCount ++;
                                }
                            }
                        }
                        case 1 -> {
                            if (hufflepuffCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.hufflepuff.add(s);
                                hufflepuffCount++;
                                validPlacement = true;
                                System.out.println("Sei stato assegnato a hufflepuff!!!");
                                if (hufflepuffCount > standardHouseSize) {
                                    extendedHousesNum--;
                                    hufflepuffCount ++;
                                }
                            }
                        }
                        case 2 -> {
                            if (ravenclawCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.ravenclaw.add(s);
                                ravenclawCount++;
                                validPlacement = true;
                                System.out.println("Sei stato assegnato a ravenclaw!!!");
                                if (ravenclawCount > standardHouseSize) {
                                    extendedHousesNum--;
                                    ravenclawCount ++;
                                }
                            }
                        }
                        case 3 -> {
                            if (slytherinCount < standardHouseSize + (extendedHousesNum > 0 ? 1 : 0)) {
                                listedStudents.slytherin.add(s);
                                slytherinCount++;
                                validPlacement = true;
                                System.out.println("Sei stato assegnato a slytherin!!!");
                                if (slytherinCount > standardHouseSize) {
                                    extendedHousesNum--;
                                    slytherinCount ++;
                                }
                            }
                        }
                    }
                }
            } while (!validPlacement);
        }
        return listedStudents;
    }
    @Override
    public String toString(){
        String temp = "\n\n";
        temp += "GRYFFINDOR: \n\n" + gryffindor.toString() + "\n============================================================================================================================================================================================================================================================================================================================================================================================================\n\n";
        temp += "HUFFLEPUFF: \n\n" + hufflepuff.toString() + "\n============================================================================================================================================================================================================================================================================================================================================================================================================\n\n";
        temp += "RAVENCLAW: \n\n" + ravenclaw.toString() + "\n============================================================================================================================================================================================================================================================================================================================================================================================================\n\n";
        temp += "SLYTHERIN: \n\n" + slytherin.toString() + "\n============================================================================================================================================================================================================================================================================================================================================================================================================\n\n";
        return temp;
    }
}
