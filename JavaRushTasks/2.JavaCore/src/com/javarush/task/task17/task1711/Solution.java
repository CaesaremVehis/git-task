package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        int count = 0;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = count; count < args.length / 3; i = i + 3) {
                        System.out.print(addPeople(args[i + 1], args[i + 2], args[i + 3]) + " ");
                        count++;
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        System.out.println(allPeople.get(Integer.parseInt(args[i])));
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = count; count < args.length / 4; i = i + 4) {
                        addPeople(args[i + 2], args[i + 3], args[i + 4], Integer.parseInt(args[i + 1]));
                        count++;
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setBirthDate(null);
                        person.setSex(null);
                    }
                }
        }
    }
    public static int addPeople(String name, String sex, String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Person person=null;
        try {
            if (sex.equals("м")) {
                person = Person.createMale(name, format.parse(date));
            } else if (sex.equals("ж")) {
                person = Person.createFemale(name, format.parse(date));
            } else {
                throw new IllegalArgumentException("Wrong argument");
            }
        } catch (ParseException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        allPeople.add(person);
        return allPeople.size()-1;
    }
    public static void addPeople(String name, String sex, String date, int index) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Person person=null;
        try {
            if (sex.equals("м")) {
                person = Person.createMale(name, format.parse(date));
            } else if (sex.equals("ж")) {
                person = Person.createFemale(name, format.parse(date));
            } else {
                throw new IllegalArgumentException("Wrong argument");
            }
        } catch (ParseException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        allPeople.set(index,person);
    }
}
