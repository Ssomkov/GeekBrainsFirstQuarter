package ru.geekbrains.java.part1.lesson3;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Games {

    private static StringBuilder maskWord;

    //task1
    public static void gessNumber() {

        byte generatedNumber;
        byte userCommand;
        byte attemptCount;
        boolean isFound;
        int userNumber;

        try (Scanner scanner = new Scanner(System.in)) {
            do {

                attemptCount = 0;
                isFound = false;
                generatedNumber = (byte) getRandomIntFromInterval(0, 9);

                do {
                    System.out.println("Input a number in interval [0, 9]: ");
                    try {
                        userNumber = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input data");
                        return;
                    }

                    if (compareUserNumbers(userNumber, generatedNumber) < 0) {
                        System.out.println(String.format("Number '%d' is less than generated number", userNumber));
                    } else if (compareUserNumbers(userNumber, generatedNumber) > 0) {
                        System.out.println(String.format("Number '%d' is greater than generated number", userNumber));
                    } else {
                        System.out.println("You won!");
                        isFound = true;
                    }
                    attemptCount++;
                } while ((attemptCount < 3) && (!isFound));

                System.out.println("Game over. Do you want to continue? (1 - yes / 0 - no)");

                try {
                    userCommand = Byte.parseByte(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input data");
                    return;
                }

            } while (userCommand == 1);
        }
    }

    //task2
    public static void gessWord() {

        byte generatedWordIndex;
        String generatedWord;
        boolean isFound = false;

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        maskWord = new StringBuilder(getStringTemplate("#", 15));

        try (Scanner scanner = new Scanner(System.in)) {

            generatedWordIndex = (byte) getRandomIntFromInterval(0, 24);
            generatedWord = words[generatedWordIndex];

            do {
                System.out.println("Input a word: ");
                String userWord = scanner.nextLine();
                System.out.println(getComparedUserWord(generatedWord, userWord));

                if (userWord.equals(generatedWord) | (generatedWord.equals(maskWord.substring(0, generatedWord.length())))) {
                    System.out.println("Generated word: " + generatedWord);
                    System.out.println("You won!");
                    isFound = true;
                }
            }
            while (!isFound);
        }

    }

    private static String getComparedUserWord(String correctAnswer, String userAnswer) {
        for (int i = 0; i < userAnswer.length(); i++) {
            if (correctAnswer.charAt(i) == userAnswer.charAt(i)) {
                maskWord.replace(i, i + 1, String.valueOf(correctAnswer.charAt(i)));
            }
        }
        return maskWord.toString();
    }

    private static String getStringTemplate(String charValue, int length) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            resultString.append(charValue);
        }
        return resultString.toString();
    }

    private static int compareUserNumbers(int a, int b) {
        Integer first = a;
        Integer second = b;
        return first.compareTo(second);
    }

    private static int getRandomIntFromInterval(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
