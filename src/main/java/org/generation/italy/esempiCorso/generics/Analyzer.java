package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Analyzer<E extends Comparable<E>> {

    private List<E> elements;

    public Analyzer(List<E> elements) {
        this.elements = new ArrayList<>(elements);
//        E x = this.elements.get(3);
//        x.modify();
    }

    public List<E> getElements() {
        return elements;
    }

    public E getMax(){
        return Collections.max(elements);
    }

    public void sort(){
        Collections.sort(elements);
    }


}
