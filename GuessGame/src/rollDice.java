public class rollDice {
    public static int roll(Player player){
//        System.out.println(player.name+" бросает кости...");
        Tech.pause(1500);
        int rollDice1 = (int)(Math.random()*6)+1;
        int rollDice2 = (int)(Math.random()*6)+1;
        int sum=rollDice1+rollDice2;
        System.out.format("Значения на костях: %s, %s\n", rollDice1, rollDice2);
        Tech.pause(1000);
//        System.out.format("%s получает %d очков\n\n",player.name, sum);
        Tech.pause(1500);
        return sum;
    }
}
