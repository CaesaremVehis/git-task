package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Find and print the rarest bytes in a file
 */
public class Solution {
    public static void main(String[] args) {
        HashMap<Integer, Integer> bytesFromFile = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream input = new FileInputStream(scanner.nextLine())) {
            while (input.available()>0){
                Integer tmp = input.read();
                if(bytesFromFile.containsKey(tmp)) {
                    bytesFromFile.put(tmp, bytesFromFile.get(tmp) + 1);
                }
                else{
                    bytesFromFile.put(tmp, 1);
                }
                printRarestBytes(bytesFromFile);
            }
        }
        catch (IOException e){
            System.out.println("O-o-o-o-o-ops, something went wrong");
            e.printStackTrace();
        }

    }
    private static void printRarestBytes(Map<Integer,Integer> bytesFromFile){
        Optional<Map.Entry<Integer,Integer>> optionalMinValue = bytesFromFile.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue());
        if(optionalMinValue.isEmpty()){
            System.out.println("The file is empty");
        }
        else {
            Integer minValue = optionalMinValue
                    .get()
                    .getValue();
            bytesFromFile.entrySet().stream()
                    .filter(a -> a.getValue() == minValue)
                    .forEach(a -> System.out.print(a.getKey() + " "));
        }
    }
}