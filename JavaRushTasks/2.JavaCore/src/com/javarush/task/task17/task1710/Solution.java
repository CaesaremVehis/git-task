package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args[0].equals("-c")) {
            System.out.println(addPeople(args[1], args[2], args[3]));
        } else if (args[0].equals("-r")) {
            System.out.println(allPeople.get(Integer.parseInt(args[1])));
        } else if (args[0].equals("-u")) {
            addPeople(args[2], args[3], args[4], Integer.parseInt(args[1]));
        } else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setBirthDate(null);
            person.setSex(null);
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

