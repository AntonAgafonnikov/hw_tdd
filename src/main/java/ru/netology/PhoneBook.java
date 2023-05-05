package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    static final Map<String, String> phoneBook = new HashMap<>();
    static int contactCounter = 0;

    public static int add(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneNumber);
            contactCounter++;
            System.out.println("Контакт " + name + " успешно добавлен в телефонную книгу");
        } else {
            System.out.println("ОШИБКА! Дубликат контакта: " + name + " " + phoneBook.get(name));
        }
        return contactCounter;
    }

    public static String findByNumber(String number) {
        return null;
    }
}
