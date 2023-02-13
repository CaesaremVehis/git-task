package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);
            FileInputStream input = new FileInputStream(scanner.nextLine())) {
            int min=Integer.MAX_VALUE;
            while (input.available()>0){
                int tmp = input.read();
                if(tmp<min){
                    min=tmp;
                }
            }
            System.out.println(min);
        }
    }
}
