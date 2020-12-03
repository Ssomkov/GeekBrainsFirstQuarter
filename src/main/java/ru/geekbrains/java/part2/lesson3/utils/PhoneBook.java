package ru.geekbrains.java.part2.lesson3.utils;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<Integer, String> phones;

    public PhoneBook() {
        phones = new HashMap<>();
    }

    public void addUser(String userName, int phone) {
        if (!phones.containsKey(phone)) {
            phones.put(phone, userName);
        }
    }

    public String getUser(int phone) {
        return phones.get(phone);
    }

    public Map<Integer, String> getPhone(String userName) {
        Map<Integer, String> searchResult = new HashMap<>();
        for (Map.Entry<Integer, String> entry : phones.entrySet()) {
            if (entry.getValue().equals(userName)) {
                searchResult.put(entry.getKey(), entry.getValue());
            }
        }
        return searchResult;
    }
}
