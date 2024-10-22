package org.generation.italy.esempiCorso.esercizioOperaDarte;

public class OpereManagement {
    public static void main(String[] args) {

        Collezione collezioneModerna = new Collezione("Collezione moderna", "Milano");

        // Quadro q1 = new Quadro("La morte", "Pallavera", 20, 14);
        // Quadro q2 = new Quadro("Quando mai", "Alessia", 12, 12);
        // Scultura s1 = new Scultura("David", "Michelangelo", 14, 12, 7);
        // Scultura s2 = new Scultura("Pensatore", "Buonarroti", 11, 17, 7);

        collezioneModerna.inserisciOpera(new Quadro("La morte", "Pallavera", 20, 14));
        collezioneModerna.inserisciOpera(new Quadro("Quando mai", "Alessia", 12, 12));
        collezioneModerna.inserisciOpera(new Scultura("David", "Michelangelo", 14, 12, 7));
        collezioneModerna.inserisciOpera(new Scultura("Pensatore", "Buonarroti", 11, 17, 7));

        collezioneModerna.stampaCollezione();
    }
}
