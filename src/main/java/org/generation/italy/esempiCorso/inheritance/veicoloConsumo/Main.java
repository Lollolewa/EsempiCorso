package org.generation.italy.esempiCorso.inheritance.veicoloConsumo;

public class Main {
    public static void main(String[] args) {
        Veicolo[] veicoli ={new Auto(2000,5),new Moto(3000,3),new Camion(1000,8)};

        for(int i = 0; i< veicoli.length;i++) {
            System.out.println(veicoli[i].calcolaConsumo());
        }

        }
    }
