/// Gioco testuale in cui vari personaggi del mondo fantasy possono combattere tra loro.
/// Player ha:
/// nome/cognome che sono quelli del giocatore,
/// nome del personaggio,
/// una password,
/// una variabile isLocked (bool) che dice se è loggato
/// la data da cui ha iniziato a giocare
/// ha i metodi login/logout
/// Login: nome pers e pass, se sono uguali dice che sei loggato, sennò dice che hai sbagliato (return string)
/// Logout: dice sei stato sloggato e mette false alla bool
/// LA CLASSE PLAYER è ESTETSA DALLA CLASSE character che ha
/// forza, intelligenza, carisma, destrezza e punti vita (int)
/// metodo getCharacterClass
/// ALTRE CLASSI che estendono character
/// PALADIN, MAGE, AMAZON, BARBARIAN, ROGUE
/// METODO CHARACTER
/// ATTACK: prende un character in input (chi è attaccato) -> astratto
/// DEFEND (input character che ti sta attacndo) -> astratto
/// ESCAPE (lascia combattimento)
/// Alcuni giocatori hanno metodi loro: paladin ha metodo HEAL, mage -> throw fireball, amazon -> castrate, barbarian -> berserk (aumenta danno che infligge ma non può difendersi), rogue -> steal (ruba armi)
///
/// Main fa combattere personaggi con ciclo while che va a avanti o fino a che uno dei due muore o fino a che uno dei due scappa, nel ciclo ognuno dei 2 giocatori può fare 2 azioni (attacca e difendi o abilità speciale al posto di attacca)
/// fight(c1, c2) // polimorfismo
/// trova il modo che 1/5 il character usa abilità speciale!!

package org.generation.italy.esempiCorso.inheritance.exercise;

public class Player {
}
