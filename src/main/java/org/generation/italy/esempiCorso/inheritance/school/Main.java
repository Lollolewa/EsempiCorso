package org.generation.italy.esempiCorso.inheritance.school;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Eleonora", "Siciliano", 22, 2500, 12, "Informatica", 7);
        Personnel personnel = new Personnel("Amio", "Gvng", 22, 3500, 5, "Arte", 420);
        //teacher.eat();
        //teacher.teach();
        System.out.println(teacher);
        System.out.println(personnel);
        Person x = new Teacher("Michael", "Jordan", 50, 2500, 12, "basket", 20);
        x.eat(); //questa può puntare a oggetti di tipo person o sottoclassi come teacher
        //static binding ( è il processo di kegare l'invocazione di un metodo alla sua esecuzione)
        teacher.teach(); //guarda solo i metodi della classe person ma non quelli delle sue sottoclassi
        //Personnel y = new Teacher("Michael", "Jordan", 50, 2500, 12, "basket", 20);
        //y.doAdministration(); questo no
        Person p1;
        if (Math.random() > .5) {
            p1 = new Teacher("Michael", "Jordan", 50, 2500, 12, "basket", 20);
        } else {
            p1 = new Personnel("Amio", "Gvng", 22, 3500, 5, "Arte", 420);
        }
        p1.eat();//qua non c'è static binding perchè il comnpilatore non prevede il futuro
        //in java i metodi sono in dynamic binding che sono fatti in realtime dalla virtual machine
        Person[] ps = {teacher, p1};
        makeIntervalForAll(ps); //polimorifsmo, principio S.O.L.I.D.
    }
    public static void makeInterval(Teacher t){
        t.eat();
        t.chat();
    }
    public static void makeInterval(Personnel p){
        p.eat();
        p.chat();
    }
    //commento nerd: one reference to role them all
    public static void makeInterval(Person q){
        q.eat();
        q.chat();
    }
    public static void makeIntervalForAll(Person[] ps){
        for(int i=0;i<ps.length;i++){ // array con più di un tipo, tutte sottoclassi di Person
            ps[i].eat();
            ps[i].chat();
        }
        // S: principio di responsabilità singole(ogni classe deve avere una sola responsabilità
        //1.motivo diventa una classe grassa
        //2.motivo quando modifichi la classe cambia anche tutto quello che viene dopo
        // O: open.closed (il codice deve essere aperto all'estensione ma chiuso alla modifica
        // (rendere possiibile aumentare le funzioni del programma, modificare il meno possibile il codice già esistente)
        // L:
        // I:
        // D:
    }
    public static void startWorkDay(Employee e){
        e.chat();
        e.doWork(3);
        e.eat();
        e.chat();
        e.doWork(3);
    }
}
