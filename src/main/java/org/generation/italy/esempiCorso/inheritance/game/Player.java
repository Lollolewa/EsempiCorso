package org.generation.italy.esempiCorso.inheritance.game;

import java.net.PasswordAuthentication;
import java.time.LocalDate;

public abstract class Player {

    protected String username, name, lastName;
    protected LocalDate doc;
    protected PasswordAuthentication password;
    protected boolean isLogged;

    public Player(String username, String name, String lastName, LocalDate doc, PasswordAuthentication password, boolean isLogged) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.doc = doc;
        this.password = password;
        this.isLogged = isLogged;
    }

    public void login(String username, PasswordAuthentication password){

        if (this.username.equals(username) && this.password.equals(password)){
            isLogged = true;
            System.out.println("Welcome back!");
        } else {
            isLogged = false;
            System.out.println("Wrong username or password.");
        }

    }

    public void logout(){
        if(isLogged){
            isLogged = false;
            System.out.println("You successfully logged out!");
        }else{
            System.out.println("You are not logged in.");
        }
    }

}
