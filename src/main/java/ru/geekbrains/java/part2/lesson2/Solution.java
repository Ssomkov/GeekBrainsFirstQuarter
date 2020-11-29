package ru.geekbrains.java.part2.lesson2;

import ru.geekbrains.java.part2.lesson2.ex.MyArrayDataException;
import ru.geekbrains.java.part2.lesson2.ex.MyArraySizeException;
import ru.geekbrains.java.part2.lesson2.utils.ArrayHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        for (String[][] array : getArrays()) {
            handleArray(array);
        }
    }

    public static void handleArray(String[][] arr) {
        try {
            System.out.printf("Sum of elements equals: %d%n", ArrayHandler.getSquareTableSum(arr, 4));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static List<String[][]> getArrays() {
        return Arrays.asList(
                new String[][]
                        {
                                {"5", "7", "3", "1"},
                                {"7", "0", "1", "12"},
                                {"8", "1", "3", "3"},
                                {"8", "-21", "2", "3"}
                        },
                new String[][]
                        {
                                {"5", "7", "3", "1"},
                                {"7", "0", "g", "12"},
                                {"8", "1", "3", "3"},
                                {"8", "-21", "2", "3"}
                        },
                new String[][]
                        {
                                {"5", "7", "3"},
                                {"7", "0", "1", "12"},
                                {"8", "1", "3", "3"},
                                {"8", "-21", "2", "3"}
                        });
    }
}
