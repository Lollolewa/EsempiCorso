package org.generation.italy.esempiCorso.interfaces;

public class Accountant implements HumanBeing{
/*la relazione che esiste tra classe e interfacce è l'implementazione, le classi implementano interfacce
le interfacce sono un nuovo tipo di dato, che può contenere soltanto classi statiche e metodi astratti
class extends otherClass
class implements interface
differenza tra extends e implements è che la classe extends eredita stato e metodi, classe implements eredita soltanto metodi astratti
classe astratta = madre biologica (una sola)
interfaccia = madre adottiva (piu' di una)
*/

    //si può estendere solo una classe perchè se ci sono piu' metodi con lo stesso nome il compilatore non sa quale eseguire,
    //si possono implementare piu' interfacce perche' se ci sono piu' metodi con lo stesso nome non c'è sovrapposizione perchè sonoo astratti (il codice deve essere ancoora scritto)
    //se una classe estende una classe e implementa piu' interfacce, si scrive prima extends e poi implements

    @Override
    public void speak() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void work(int hours) {

    }
}
