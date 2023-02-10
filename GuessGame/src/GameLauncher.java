import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GameLauncher{
    public static void main(String[] args) {//        Choosing game
        while (true) {
            System.out.println("Выберите игру: ");
            System.out.println("Нажмите 1, чтобы сыграть в угадайку");
            System.out.println("Нажмите 2, чтобы сыграть в кости");
            int number = Tech.consoleInt();
            if (number == 1) {
                GuessGame game = new GuessGame();
                game.startGame();
                break;
            }/* else if (number == 2) {
                DiceGame game = new DiceGame();
                game.startDiceGame();
                break;
            }*/ else {
                System.out.println("Введите 1 или 2");
            }
        }
    }
    public static boolean repeat(){ //       ask the user to repeat the game
        System.out.println("Сыграть еще раз?");
//        Create two Sets with right ans.
        HashSet<String> ansYes = new HashSet<>(){{
            add("д");
            add("дд");
            add("да");
            add("yes");
            add("y");
            add("yy");
            add("ok");
            add("yep");
        }};
        HashSet<String> ansNo = new HashSet<>(){{
            add("н");
            add("нет");
            add("не");
            add("no");
            add("not");
            add("n");
            add("nn");
            add("nope");
            add("неть");
        }};

        Scanner console = new Scanner(System.in); //ask the user for  his answer
        do {
            String hasRepeat = console.nextLine();
            if (ansYes.contains(hasRepeat)) {
                return true;
            } else if (ansNo.contains(hasRepeat)) {
                return false;
            }
                System.out.println("Ответ непонятен, повторите");
        }
        while (true);
    }
}