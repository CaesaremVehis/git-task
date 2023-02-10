import javax.management.InvalidAttributeValueException;
import java.util.Scanner;

public class Player{
    private String name;
    private int number;


    public Player(String name) {
            this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setNumber (int number) throws InvalidAttributeValueException{
           if(number>0&&number<=10) {
               this.number = number;
           }
           else {
               var e = new InvalidAttributeValueException();
           }
    }
    public int getNumber(){
        return number;
    }




}
