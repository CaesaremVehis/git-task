package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Find and print the most used bytes in a file
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
            }
                printRarestBytes(bytesFromFile);
        }
        catch (IOException e){
            System.out.println("O-o-o-o-o-ops, something went wrong");
            e.printStackTrace();
        }

    }
    private static void printRarestBytes(Map<Integer,Integer> bytesFromFile){
        Optional<Map.Entry<Integer,Integer>> optionalMaxValue = bytesFromFile.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        if(optionalMaxValue.isEmpty()){
            System.out.println("The file is empty");
        }
        else {
            Integer MaxValue = optionalMaxValue
                    .get()
                    .getValue();
            bytesFromFile.entrySet().stream()
                    .filter(a -> a.getValue() == MaxValue)
                    .forEach(a -> System.out.print(a.getKey() + " "));
        }
    }
}


