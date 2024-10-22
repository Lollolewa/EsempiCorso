package MagicHatObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MagicHat extends Casata {
    NomiCasate nomiCasate;
    List<Studente> allStudents = new ArrayList<>();
    Casata gryffyndor;
    Casata slytherin;
    Casata hufflepuff;
    Casata ravenclaw;

    public MagicHat(NomiCasate nomeCasate, List<Studente> casata, Casata gryffyndor,Casata slytherin, Casata hufflepuff, Casata ravenclaw) {
        super(nomeCasate, casata);
        this.gryffyndor = new Casata(NomiCasate.GRYFFINDOR, casata);
        this.slytherin = new Casata(NomiCasate.SLYTHERIN,casata);
        this.hufflepuff = new Casata(NomiCasate.HUFFLEPUFF,casata);
        this.ravenclaw = new Casata(NomiCasate.RAVENCLAW,casata);

    }


}
//KarenRusso", "SalvatoreTavella", "AlessiaPallavera", "PierluigiMicozzi", "EleonoraSiciliano", "GianlucaPricopie", "MiryamMassa", "PamelaMilanese", "EjranMustafoski", "AndreaMacellaro", "AlessandroMassa", "PietroMarinari", "AlessandroStelitano", "StefanoPuro", "LucreziaLauri", "MarioPeccio", "LorenzoMasci", "DaniloVulpiani", "CarlottaPisano", "IliesChikhaoui", "SamueleCelletti", "GabrieleSabatini", "JoshuaCastellani", "MacaliRoberto", "LorenzoSalvatori", "MarcoFalconetti", "LucaGalimberti", "MatteoFratti");