package ru.geekbrains.java.part2.lesson3;

import ru.geekbrains.java.part2.lesson3.utils.PhoneBook;
import ru.geekbrains.java.part2.lesson3.utils.WordsHandler;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //task1
        System.out.println("Handle words array:");
        WordsHandler.printUniqueWordsWithCount(getWords());
        //task2
        System.out.println("Handle phone book:");
        PhoneBook phoneBook = new PhoneBook();
        fillPhoneBook(phoneBook);
        System.out.println(phoneBook.getUser(12344));
        System.out.println(phoneBook.getPhone("Vasya"));
    }

    private static List<String> getWords() {
        List<String> words = Arrays.asList("Orange", "Yellow", "Black", "Blue", "White", "Red", "Purple", "Black",
                "White", "Green", "Yellow", "Pink", "Orange", "Silver");
        return words;
    }

    private static void fillPhoneBook(PhoneBook phoneBook) {
        phoneBook.addUser("Ivan", 16544);
        phoneBook.addUser("Vasya", 34567);
        phoneBook.addUser("Petya", 12344);
        phoneBook.addUser("Vasya", 46786);
    }
}
