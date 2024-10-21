package org.generation.italy.esempiCorso.slytherin.exercises.sortingHat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<String> temp = new ArrayList<>(Arrays.asList(
                "MirkoRisuleo", "AlessiaPallavera", "EleonoraSiciliano", "GianlucaPricopie",
                "MiryamMassa", "PamelaMilanese", "EjranMustafoski", "AndreaMacellaro",
                "AlessandroMassa", "PietroMarinari", "AlessandroStelitano", "StefanoPuro", "LucreziaLauri",
                "MarioPeccio", "LorenzoMasci", "DaniloVulpiani", "CarlottaPisano", "IliesChikhaoui",
                "SamueleCelletti", "GabrieleSabatini", "JoshuaCastellani", "LorenzoSalvatori",
                "MarcoFalconetti", "LucaGalimberti", "MatteoFratti"));
        for (String s : temp) {
            studentList.add(new Student(s, House.NONE));
        }
        Students students = new Students(studentList);
        SortingHat x = new SortingHat(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        System.out.println(x.sortingHat(students));
    }
}
