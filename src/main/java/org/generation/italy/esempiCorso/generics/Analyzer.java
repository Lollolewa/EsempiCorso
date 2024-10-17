package org.generation.italy.esempiCorso.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// prima <E extends Modifiable>
public class Analyzer<E extends Comparable<E>> {
    /// quando creo oggetti di classe Analyzer, non li posso crare su tipo qualsiasi,
    /// deve essere classe che impelementa modifiable, String non va bene, p.e.
    /// extends e impements in questo caso sono equivalenti (sono SINONIMI)
    /// ORA POSSO CHIAMARE ANCHE I METODI DI MODIFIABLE
    private List<E> elements;

    public Analyzer(List<E> elements) {
        this.elements = new ArrayList<>(elements); // ArrayList<E>(elements) // shallow copy (ha new)
        // this.elements.add(e); // la lista originaria non ha elem in più, e elem di tipo E
        //this.elements[0] = this.elements[1]; // no effetto sull'originale, primo eleme punta al secondo
        /// può cambiare
//        E x = this.elements.get(3); // per ora E è solo object non ha i suoi metodi ancora
//        x.modify(); // modifica l'oggetto perché entro nei valori così
        /// elements protegge l'array originale ma non gli elementi stessi

     }

     public E getMaxElement() {
        // Classe Collections != Collection!
         /// di norma le classi hanno nome singolare ma non le classi di utilità, che contengono i metodi statici
         /// che non so dove ficcare
         return Collections.max(elements); // il pb è che non sa cosa definisca e > e sono tipo E ??
         /// posso dire che l'ememento e con E extends Comparable<E>, intefaccia Comparable si specializza su E
         /// ora i tipi implementono Comparable che è interfaccia (ovveride dai tipi)
         // compareTo() è metodo che deve essere implementato dai tipi
    }

}
