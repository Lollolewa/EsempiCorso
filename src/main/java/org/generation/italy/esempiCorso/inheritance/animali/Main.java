package org.generation.italy.esempiCorso.inheritance.animali;

public class Main {
    public static void main(String[] args) {
        Animale[] listaAnimali = {new Cane("Fido"),new Gatto("Lessy"),new Uccello("Fein")};

        for(int i=0;i< listaAnimali.length;i++){
            System.out.println(listaAnimali[i].verso());
            System.out.println(listaAnimali[i].presentati());
        }
    }
}
