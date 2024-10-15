package org.generation.italy.esempiCorso.Slytherin.exercises.OperaDArte.Case;

import java.util.ArrayList;
import java.util.List;

public class Archivio{
    List<Appartamento> apartmentArchive = new ArrayList<>();
    List<Villa> villaArchive = new ArrayList<>();

    public void inserire(Casa h){
        if (h.getClass() == Appartamento.class) {
            apartmentArchive.add((Appartamento)h);
        } else if (h.getClass() == Villa.class) {
            villaArchive.add((Villa)h);
        } else {
            System.out.println("habemus problem");
        }
    }

    public int ApartmentAvarageValue(int n) {
        int apartmentsTotValue = 0;
        int counter = 0;
        for (Appartamento appartamento : apartmentArchive) {
            if (appartamento.surface > n) {
                apartmentsTotValue += appartamento.HouseValue();
                counter++;
            }
        }
        return apartmentsTotValue / counter;
    }

    public int VilleAvarageValue(int n) {
        int villeTotValue = 0;
        int counter = 0;
        for (Villa villa : villaArchive) {
            if (villa.surface > n) {
                villeTotValue += villa.HouseValue();
                counter++;
            }
        }
        return villeTotValue / counter;
    }
}
