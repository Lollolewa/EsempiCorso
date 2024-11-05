package org.generation.italy.esempiCorso.MagicHatOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicHat {
   private List<Studente> studenti;
   private Random fate;
   public MagicHat(List<Studente> studenti) {
       this.studenti = studenti;
       fate = new Random();
   }
   public void assignStudents() {
       final int numHouses = Houses.values().length;
       final int standardNumStudents = studenti.size() / numHouses * numHouses;
       int pos = fate.nextInt(studenti.size());
//       for(studenti : studenti){
//           if (studenti.size() < standardNumStudents) {
//           //studenti.add();
//           }
//       }
   }
}
