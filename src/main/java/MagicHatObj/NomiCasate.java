package MagicHatObj;

import java.util.HashSet;
import java.util.Set;

public enum NomiCasate {
    GRYFFINDOR,SLYTHERIN,RAVENCLAW,HUFFLEPUFF;
    private static int maxStudents;
    public static void setMaxStudents(int max) {
        maxStudents = max;
    }
    private Set<Studente> students = new HashSet<>();
    public int add(Studente s) {
        students.add(s);
        return students.size();
    }
    @Override
    public String toString() {
        return students.toString();
    }
}
