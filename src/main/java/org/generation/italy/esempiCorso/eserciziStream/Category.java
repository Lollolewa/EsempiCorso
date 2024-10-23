package org.generation.italy.esempiCorso.eserciziStream;

import java.util.Arrays;

public enum Category {
    ADVENTURE, SCIENCE_FICTION, NARRATIVE, CLASSICS, HORROR;

    public static int indexOf(Category categoriaDaTrovare) {
        return (int) Arrays.stream(Category.values())
                .filter(categoria -> categoria == categoriaDaTrovare)
                .map(Category::ordinal)
                .findFirst()
                .orElse(-1); // Restituisce -1 se non trovata
    }
}
