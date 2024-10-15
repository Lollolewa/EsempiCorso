package org.generation.italy.esempiCorso.interfaces;

import org.generation.italy.esempiCorso.utilities.StringUtilities;

public class Start {
    public static void main(String[] args) {
        //StringUtilities st = new StringUtilities(); //non serve fare questo perchè mi darebbe lo stesso risultato per qualsiasi oggetto farebbe;
                                                     //  -> lo faccio statico

        String result = StringUtilities.invert("ciao");
    }
}
