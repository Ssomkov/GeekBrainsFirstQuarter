package ru.geekbrains.java.part2.lesson3.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsHandler {

    public static void printUniqueWordsWithCount(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int count = 1;
            if (!map.containsKey(word)) {
                map.put(word, count);
            } else {
                count = map.get(word);
                count++;
                map.put(word, count);
            }
        }
        printMap(map);
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("Word '%s' is repeated '%d'%n", entry.getKey(), entry.getValue());
        }
    }
}
