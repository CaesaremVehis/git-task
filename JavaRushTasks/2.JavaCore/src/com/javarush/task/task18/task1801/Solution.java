package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
         try (Scanner scanner = new Scanner(System.in);
               FileInputStream input = new FileInputStream(scanner.nextLine())) {
            int max=0;
            while (input.available()>0){
                int tmp = input.read();
                if(tmp>max){
                    max=tmp;
                }
            }
            System.out.println(max);
        }
    }
}
