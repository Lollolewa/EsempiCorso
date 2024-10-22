package org.generation.italy.esempiCorso.altro;

public class WhileTrue {
    public static void main(String[] args) {

        int i = 0;

        while(true){
            System.out.println("Ciao");
            i++;
            if(i >= 10){
                break;
            }
        }
    }
}
