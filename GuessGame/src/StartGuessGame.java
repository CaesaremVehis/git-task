import java.util.*;

/**
 * Create n Players and meet them
 */
public class StartGuessGame {
    private static int playersCount;
    static List <Player> playersList = new ArrayList<>(); //Создаем список игроков

    public static void createPlayers () {
        Scanner console = new Scanner(System.in);
        System.out.println("Сколько будет игроков?\n Введите значени от 1 до 4");
        while (true) {
            if (console.hasNextInt() == true) {
                playersCount = console.nextInt();
                if (playersCount > 0 && playersCount <= 10) {
                    break;
                } else {
                    System.out.println("Число должно быть от 1 до 4 \nПопробуйте еще раз");
                }
            } else {
                System.out.println("Вы должны ввести целое число. \n Попробуйте еще раз");
            }
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < playersCount; i++) {
            System.out.printf("Введите имя игрока %d: ", i + 1);
            while (true) {
                    String name = scanner.nextLine();
                if (name != null && !name.isEmpty()) {
                    playersList.add(i, new Player(name));
                    break;
                } else {
                    System.out.println("Имя не может быть пустым");
                }
            }
        }
    }



}
