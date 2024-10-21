package MagicHatObj;

import java.util.*;

public class MagicHat extends Casata {
    NomiCasate nomiCasate;
    List<Studente> allStudents = new ArrayList<>();
    Casata gryffyndor;
    Casata slytherin;
    Casata hufflepuff;
    Casata ravenclaw;
    Random fate;

    public MagicHat(NomiCasate nomeCasate, List<Studente> casata, Casata gryffyndor,Casata slytherin, Casata hufflepuff, Casata ravenclaw) {
        super(nomeCasate, casata);
        this.gryffyndor = new Casata(NomiCasate.GRYFFINDOR, casata);
        this.slytherin = new Casata(NomiCasate.SLYTHERIN,casata);
        this.hufflepuff = new Casata(NomiCasate.HUFFLEPUFF,casata);
        this.ravenclaw = new Casata(NomiCasate.RAVENCLAW,casata);
        this.allStudents = Arrays.asList(new Studente("Mirko","Risuleo", Optional.of(NomiCasate.GRYFFINDOR)), new Studente("Marco", "Falconetti", Optional.of(NomiCasate.HUFFLEPUFF)), new Studente("Salvatore","Tavella", Optional.empty()), new Studente("Alessia" , "Pallavera", Optional.of(NomiCasate.SLYTHERIN)), new Studente("Alessia" , "Pallavera", Optional.of(NomiCasate.SLYTHERIN)));
        fate = new Random();
    }

    public void assignStudents() {
        final int numHouses = NomiCasate.values().length;
        final int standardNumStudents = allStudents.size()/numHouses*numHouses;
    }


}
/*"GianlucaPricopie", "MiryamMassa", "PamelaMilanese",
"EjranMustafoski", "AndreaMacellaro", "AlessandroMassa", "PietroMarinari",
"AlessandroStelitano", "StefanoPuro", "LucreziaLauri", "MarioPeccio", "LorenzoMasci",
"DaniloVulpiani", "CarlottaPisano", "IliesChikhaoui", "SamueleCelletti", "GabrieleSabatini",
"JoshuaCastellani", "MacaliRoberto", "LorenzoSalvatori", "MarcoFalconetti", "LucaGalimberti",
"MatteoFratti", "Mirko Risuleo"*/