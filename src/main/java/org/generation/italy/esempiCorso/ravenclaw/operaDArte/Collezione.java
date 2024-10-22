package org.generation.italy.esempiCorso.ravenclaw.operaDArte;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private String nome, luogo;
    List<OperaDArte> listaOpereMannaggiaADio = new ArrayList<>();

    public Collezione(String nome, String luogo, List<OperaDArte> listaOpereMannaggiaADio) {
        this.nome = nome;
        this.luogo = luogo;
        this.listaOpereMannaggiaADio = listaOpereMannaggiaADio;
    }

    public void inserisciOpere(OperaDArte o){
        listaOpereMannaggiaADio.add(o);

        }
    public void stampaCollezione(){
        System.out.println(nome);
        System.out.println(luogo);
        System.out.println(listaOpereMannaggiaADio);
    }
    }


