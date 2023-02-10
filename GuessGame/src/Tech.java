import java.util.Scanner;

public class Tech {
    public static int consoleInt(){
        /**
         * Метод запрашивает у пользователя целое число. Другие типы не пропускает
         */
        int num;
        Scanner console = new Scanner(System.in);
        while(true) {
            if(console.hasNextInt()==true) {
                num = console.nextInt();
                return num;
            }
            else {
                System.out.println("Это не похоже на целое число. Попробуйте снова");
                console.next();
            }
        }
    }
    public static void pause (int pTime){
        /**
         * Пауза. Время передается в мс
         */
        try {
            Thread.sleep(pTime);
        } catch(InterruptedException ex) {}
    }
}
