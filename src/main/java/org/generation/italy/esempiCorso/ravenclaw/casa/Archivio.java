package org.generation.italy.esempiCorso.ravenclaw.casa;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    public Archivio(List<Casa> ville, List<Casa> appartamenti) {
        this.ville = ville;
        this.appartamenti = appartamenti;
    }

    List<Casa> ville = new ArrayList<>();
    List<Casa> appartamenti = new ArrayList<>();

    public int mediaCosti(int n){
        int q = 0;
        int sPrezzi = 0;
        for(Casa c : ville){
            if (c.getSuperfice()>n){
                sPrezzi += c.costoCasa();
                q++;
            }
        }
        for(Casa c : appartamenti){
            if (c.getSuperfice()>n){
                sPrezzi += c.costoCasa();
                q++;
            }
        }
        return sPrezzi/q;
    }


}
