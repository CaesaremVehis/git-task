package com.javarush.task.task17.task1711;

public enum Sex {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        if(this==MALE){
            return "м";
        }
        else return "ж";
    }
}
