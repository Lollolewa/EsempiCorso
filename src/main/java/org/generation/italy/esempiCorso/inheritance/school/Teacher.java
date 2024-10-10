package org.generation.italy.esempiCorso.inheritance.school;
//ereditarietà è il rapporto più stretto tra due classi (is_a la domanda per capire se ha senso l'ereditarietà), ogni cambiamento che fai nella madre si ripercuote nelle figlie
public class Teacher extends Person{

    //teacher è una sottoclasse/sottotipo di person (che è il supertipo/superclasse di teacher)
    //la sottoclasse eredita le proprietà e i metodi visibili della superclasse
    //tutto quello che è privato nella superclasse rimane visibile ma non direttamente accessibile
    //esempio sul nome, non posso accedere al nome ma posso usare la getNome
    //quindi teacher ha nome ma non ci può accedere direttamente
    //in java non c'è ereditarietà multipla, una classe ne estende solamente un'altra
    private String subject;
    private int yearOfService;

    public Teacher(String name, String surname, int age, String subject, int yearOfService){
        //this non funziona con le superclassi
        //nuova keyword: super
        super(name, surname, age); //richiama metodi della superclasse, se non specifico niente chiama il costruttore
        this.subject = subject;
        this.yearOfService = yearOfService;

    }



    // va a riprendere il metodo della superclasse e lo sovrascrive, non necessario scriverlo ma serve per star sicuri che il compilatore controllli
    //obbliga il compilatore a verificare se esiste realmente la funzione nel padre
    @Override
    public String toString(){
        return super.toString() + "Insegno " + subject + " da " + yearOfService + " anni.";

    }

}
