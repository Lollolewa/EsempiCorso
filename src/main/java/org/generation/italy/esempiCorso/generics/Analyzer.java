package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Analyzer <E extends Comparable<E>> {
    private List<E> elements;

    public Analyzer(List<E> elements) {
        //this.elements = null;
        //this.elements.add(e); //aggiungo un elemento
        //this.elements[0] = this.elements[1];
//        E x = this.elements.get(3);
//        x.modify();

        this.elements = new ArrayList<>(elements);//dentro le paratesi diamantate non ha necessità di specificare il tipo di nuovo, è già stato dichiarato prima <E> quindi sarebbe ridondante perchè il compilatore lo sa
    }
        //questa è una shallow-copy, cioè ci sono gli stessi oggetti che puntano a quelli dell'ArrayList
    public List<E> getElements() {
        return elements;
    }
    public void sort(){
        Collections.sort(elements);
    }
    public E getMaxElement(){
       return Collections.max(elements);
    }
}
