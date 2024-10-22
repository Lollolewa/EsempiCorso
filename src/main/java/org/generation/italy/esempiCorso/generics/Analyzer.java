package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Analyzer <E extends Comparable<E>> {
    private List<E> elements;

    public Analyzer(List<E> elements) {
        this.elements = new ArrayList<>(elements); //dentro i < > ci va il tipo - shallowcopy, questo serve per evitare che gli elementi della lista siano modificati da altre classi
        //this.elements = null;
        //this.elements.add(e);
        //this.elements[0] = this.elements[1];
        //E x = this.elements.get(3);
        //x.modify(🚀);
    }
    public E getMaxElement(){
        return Collections.max(elements);
    }

    public void sort(){
        Collections.sort(elements);
    }

    public List<E> getElements(){
        return elements;
    }
}