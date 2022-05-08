package com.geekbrains.homeworklesson3;

import java.util.Set;

public class Homework3Task2 {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Petrov", "346");
        phoneBook.add("Petrov", "346-2");
        phoneBook.add("Petrov", "346-3");
        phoneBook.add("Sidorov", "132");
        phoneBook.add("Ivanov", "435");

        Set<String> surnames = phoneBook.allSurnames();
        for(String surname : surnames) {
            System.out.printf("Пользователь %s имеет номер(а) телефонов %s %n", surname, phoneBook.get(surname));
        }
    }
}
