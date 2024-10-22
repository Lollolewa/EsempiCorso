package org.generation.italy.esempiCorso.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Libreria {

    List<Libro> libri = new ArrayList<>();

    public void addLibri(String titolo, String autore, int annoPubblicazione){
        libri.add(new Libro(titolo, autore, annoPubblicazione, true));
    }

    public String visualizzaElenco(){
        return getLibriDisponibili(true).toString();
    }

    public List<Libro> getLibriDisponibili(boolean isDisponibile){
        List<Libro> libriDisponibili = new ArrayList<>();
        for(Libro libro : libri){
            if(libro.isDisponibile() == isDisponibile){
                libriDisponibili.add(libro);
            }

        }
        return libriDisponibili;
    }

    // public List<Libro> ricercaLibroPerTitolo(String titolo){
    //     List<Libro> libriPerTitolo = new ArrayList<>();
    //     for(Libro libro : getLibriDisponibili(true)){
    //         if(libro.getTitolo().equals(titolo)){
    //             libriPerTitolo.add(libro);
    //         }
    //     }
    //     return libriPerTitolo;
    // }

    public List<Libro> ricercaLibro(String ricerca){
        List<Libro> libriPerAutore = new ArrayList<>();
        ricerca = ricerca.toLowerCase(Locale.ROOT);
        for(Libro libro : getLibriDisponibili(true)){
            if(libro.getAutore().toLowerCase(Locale.ROOT).contains(ricerca) || libro.getTitolo().toLowerCase(Locale.ROOT).contains(ricerca)){
                libriPerAutore.add(libro);
            }
        }
        return libriPerAutore;
    }

    public void prestareLibro(int indice){
        Libro libroScelto = getLibriDisponibili(true).get(indice);
        for(Libro libro : libri){
            if(libroScelto.equals(libro)){
                libro.setIsDisponibile(false);
            }
        }
    }
    public void restituireLibro(int indice){
        Libro libroScelto = getLibriDisponibili(false).get(indice);
        for(Libro libro : libri){
            if(libroScelto.equals(libro)){
                libro.setIsDisponibile(true);
            }
        }
    }


}
