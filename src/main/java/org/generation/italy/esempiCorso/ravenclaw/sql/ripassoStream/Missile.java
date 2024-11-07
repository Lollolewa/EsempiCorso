package org.generation.italy.esempiCorso.ravenclaw.sql.ripassoStream;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Missile {
    private String name, location;
    private int aoe;
    private LocalDate doc;
    private LocalDateTime dol;

    public Missile(String name, String location, LocalDate doc, int aoe, LocalDateTime dol) {
        this.name = name;
        this.location = location;
        this.doc = doc;
        this.aoe = aoe;
        this.dol = dol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDoc() {
        return doc;
    }

    public void setDoc(LocalDate doc) {
        this.doc = doc;
    }

    public int getAoe() {
        return aoe;
    }

    public void setAoe(int aoe) {
        this.aoe = aoe;
    }

    public LocalDateTime getDol() {
        return dol;
    }

    public void setDol(LocalDateTime dol) {
        this.dol = dol;
    }
}
