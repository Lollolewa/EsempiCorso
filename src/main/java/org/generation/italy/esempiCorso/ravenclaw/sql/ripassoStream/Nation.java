package org.generation.italy.esempiCorso.ravenclaw.sql.ripassoStream;

import java.util.List;
import java.util.stream.Stream;

public class Nation {
    private String name, president;
    private int population, area;
    private List<Missile> missiles;

    public Nation(String name, String president, int population, int area, List<Missile> missiles) {
        this.name = name;
        this.president = president;
        this.population = population;
        this.area = area;
        this.missiles = missiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void setMissiles(List<Missile> missiles) {
        this.missiles = missiles;
    }

    public Stream<Missile> getMissileStream(){
        return missiles.stream();
    }
}
