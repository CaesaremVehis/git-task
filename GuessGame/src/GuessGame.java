import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;

public class GuessGame {
    private boolean isNewGame = true;
    private boolean isNewRound =true;
    private boolean isRepeat = true;
    int targetNumber;
    public List<Player> winnersList = new ArrayList<>();
    public void startGame() {
        var playersList = StartGuessGame.playersList;
        while(isRepeat){
            if(isNewRound) {
                if (isNewGame) {
                    playersList = StartGuessGame.playersList;
                    playersList.clear();
                    StartGuessGame.createPlayers();
                }
                isNewGame=false;
//        Загадываем число
                targetNumber = (int) (Math.random() * 10) + 1;
                System.out.println("Загадываю число от 1 до 10...\n Попробуйте угадать");
                Tech.pause(1000);
            }
            isNewRound=false;

//            Собираем варианты ответов участников и записываем в переменные
                Tech.pause(1000);
                for (Player player : playersList
                ) {
                    System.out.printf("%s думает, что это... %d\n", player.getName(), guess(player));
                    Tech.pause(1000);
                }
                System.out.println();
                Tech.pause(1000);

// Объявляем победителя
                for (Player player : playersList
                ) {
                    if (player.getNumber() == targetNumber) {
                        System.out.printf("%s угадал, это число %d\n", player.getName(), targetNumber);
                        winnersList.add(player);
                    }
                }
                if (winnersList.isEmpty()) {
                    System.out.println("Никто не смог угадать. \nИгроки должны попробовать еще раз");
                    isRepeat=true;
                    isNewGame=false;
                } else if (winnersList.size() == 1) {
                    System.out.printf("Поздравим победителя! %s \n", winnersList.get(0).getName());

                    Tech.pause(1000);
                    System.out.println("Конец игры.");
                    Tech.pause(1000);
                    isRepeat = GameLauncher.repeat();
                    isNewRound=true;
                    isNewGame=true;
                } else {
                    for (Player player : playersList
                    ) {
                        if (!winnersList.contains(player)) {
                            System.out.printf("%s выбывает из игры!\n", player.getName());
                        } else {
                            System.out.printf("Игрок %s проходит в следующий тур\n", player.getName());
                        }
                    }
                isNewRound=true;
                }
            if(!winnersList.isEmpty()) {
                playersList.clear();
                playersList = winnersList;
                winnersList= new ArrayList<>();
            }
        }
    }

    /**
     * Get numbers from players
     * @param player
     * @return number
     */
    public int guess(Player player){
        System.out.println(player.getName()+", ваш вариант? Введите целое число от 1 до 10");
        Tech.pause(1000);
        while(true) {
            try {
                player.setNumber(Tech.consoleInt());
                return player.getNumber();
            }
            catch(InvalidAttributeValueException e) {
                System.out.println("Число должно быть от 1 до 10. Попробуйте снова");
            }
        }
    }
}

