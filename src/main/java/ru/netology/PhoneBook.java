package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public Map<String, String> phoneBook = new HashMap<>();

    public int add(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneNumber);
            System.out.println("Контакт " + name + " успешно добавлен в телефонную книгу");
        } else {
            System.out.println("ОШИБКА! Дубликат контакта: " + name + " " + phoneBook.get(name));
        }
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        return phoneBook.keySet()
                .stream()
                .filter(key -> number.equals(phoneBook.get(key)))
                .findFirst().orElse("ОШИБКА! Контакт не найден!");
    }

    public String findByName(String name) {
        return phoneBook.getOrDefault(name, "ОШИБКА! Контакт не найден!");
    }
}
