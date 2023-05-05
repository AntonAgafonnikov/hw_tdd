package ru.netology;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    public Map<String, String> phoneBook = new TreeMap<>();

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

    public void printAllNames() {
        StringBuilder stringBuilderNames = new StringBuilder();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            stringBuilderNames.append(entry.getKey()).append(" ");
        }
        String result = stringBuilderNames.toString().trim();
        System.out.print(result);
    }
}
