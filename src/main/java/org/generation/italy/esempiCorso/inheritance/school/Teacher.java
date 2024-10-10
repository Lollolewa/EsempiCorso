package org.generation.italy.esempiCorso.inheritance.school;

//ereditarietà è il rapposrto più stretto tra classi (is_a)
public class Teacher extends Person {
    //teacher è una sottoclasse/sottotipo di una person (supertipo/superclasse) la sottoclasse eredita le propietà e i metodi della superclasse, i metodi restano privati, non sono direttamente raggiungibili

    private String subject;
    private int yearsOfService;

    public Teacher(String name, String surname, int age, String subject, int yearsOfService) {
        super(name, surname, age);
        this.subject = subject;
        this.yearsOfService = yearsOfService;

    }
    @Override //riprende il metodo della superclasse e lo sovrascrive (padre e madre) quindi fa ereditare gli attributi di Person
    public String toString(){       //riesco a richiamare il to String della classe estesa quindi di Person
        return super.toString() + " Insegno " + subject + " da " + yearsOfService;
    }

}
