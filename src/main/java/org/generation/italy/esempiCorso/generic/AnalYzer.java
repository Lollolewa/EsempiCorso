package org.generation.italy.esempiCorso.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnalYzer <E extends Comparable<E>>{//facendo cosi implementiamo un ulteriore interfaccia che lavora sugli elementi di E, aggiungendoci ulteriori metodi come possiamo vedere nella funzione sotto;
    //facendo cosi (<E extends Modifiable>, sto andando a specificare ulteriormente la generic aggiungendo un metodo che viene implementato da un interfaccia;
    private List<E> elements;//ora questa classe è specializzata e puo lavorare solo sui tipi specifici;

    public AnalYzer(List<E> elements, E e) {
        this.elements = new ArrayList<>(elements); //dentro i <> ci va sempre il tipo;
        //this.elements = null;
        //this.elements.add(e);
        //this.elements.get(0)=this.element.get(1); facendo tutte queste cose non modifichiamo mai l'array originale, ma solo la copia (ricorda che l'arraylist ha all'interno puntatori ad elementi);
        // E x= this.elements.get(3);
        // x.modify(); //facnendo cosi, adesso le funzioni che invoco sugli oggetti stessi verranno modificati, poichè a prescindire se ciò che mi punta l'oggeto sia o non si una copia, punteranno tutti e due allo stesso oggetto;
    } //questa è una shallowCopy, poichè ciò che copio sono gli indici presenti negli array list e no gli oggetti;

    public List<E> getElements() {
        return elements;
    }
    public E getMaxElements(){
        return Collections.max(elements);
            }
    public  void  sort(){
        Collections.sort(elements);
    }

    public void add(E element) {
        elements.add(element);
    }
}
