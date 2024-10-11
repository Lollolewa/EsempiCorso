package org.generation.italy.esempiCorso.inheritance.exercise;
/*
Voglio creare una classe player per rappresentare un gioco in cui vari personaggi fantasy possono combattere tra loro
Il player è un'entità che ha un nome e un cognome (che sono il nome e cognome del giocatore), ha il nome del personaggio, la data da cui ha iniziato
a giocare (data di iscrizione) e una password e una variabile booleana per dire se è loggato o no "isLogged", e ha i metodi login e logout
Il login riceve nome del personaggio e password e restituisce se sei loggato o no.
logout stamperà un messaggio che dirà che sei stato sloggato e cambierà la booleana in false.

La classe player viene estesa da una classe Character come tipo di personaggio,
Avrà un metodo getCharacterClass che restituisce la professione del personaggio,
vari int per Punti vita, forza, intelligenza, carisma, agilità;
Il character avrà dei metodi importanti che sono Attacca (che prende in input un altro character, colui che attacchi)
e un metodo Difendi (che prende in input un altro character da cui si difende)
e un metodo Scappa per interrompere il combattimento.
Attacca e difendi saranno abstract perchè ogni classe attaccherà e si difenderà in un modo diverso

ci saranno altre classi che estendono il character:
-Paladin, Mage, Amazon, Barbarian, Rogue;
Ognuna di questa classe avrà i propri metodi
-Paladin ad esempio avrà heal che gli permette di recuperare punti vita;
-Mage avrà il metodo throwFireball()
-Amazon avrà il metodo castrate()
-Barbarian avrà il metodo berserk() aumenta il danno ma gli impedisce di difendersi;
-Rogue ha il metodo steal() che gli permette di rubare le armi all'avversario

main = crea alcuni personaggi e li fa combattere tra loro
Il combattimento funziona cosi:
il ciclo while sarà in un metodo fight() che prenderà in imput (Character c1, Character c2)
ciclo while che va avanti finchè un giocatore muore o scappa;
Durante il ciclo while ogni giocatore può fare due azioni (possono essere attacca o difendi principalmente, e ogni tanto (1 volta su 5)
usa un attacco speciale);
 */
public class Player {

}
