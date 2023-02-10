import java.util.Scanner;

/**
 *The <b>class</b> contents dice game. There is only 1 method in the class.
 */

public class DiceGame {
    /**
     * Method completes full game cycle
     */
    public void startDiceGame() {
        /**
         * Introduce the players
         * */
//       Player  p1 = new Player();
//       Player p2 = new Player();
//        p1.meet(1);
//        p2.meet(2);

        boolean hasRepeat=true;
        while(hasRepeat == true){
/**
 *  Create a dice roll
 */
//        int p1Result = rollDice.roll(p1);
//        int p2Result = rollDice.roll(p2);
            System.out.println();
/**
 *  Choose the winner
 */
//           if(p1Result==p2Result) {
//               System.out.println("Игроки выбросили одинаковые значения. Бросьте кубики заново");
//           }
//           else if(p1Result>p2Result){
//               System.out.println(p1.name+" победил(а), выбросив "+p1Result+" очков");
//           }
//           else{
//               System.out.println(p2.name+" победил(а), выбросив "+p2Result+" очков");
//           }
/**
 *  Ask the user to repeat the game
 */
           hasRepeat = GameLauncher.repeat();

        }
    }
}

