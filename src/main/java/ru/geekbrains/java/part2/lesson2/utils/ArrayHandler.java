package ru.geekbrains.java.part2.lesson2.utils;

import ru.geekbrains.java.part2.lesson2.ex.MyArrayDataException;
import ru.geekbrains.java.part2.lesson2.ex.MyArraySizeException;

public class ArrayHandler {

    public static int getSquareTableSum(String[][] arr, int size) throws MyArraySizeException, MyArrayDataException {
        checkArraySquareSize(arr, size);
        return getArrayElementsSum(arr);
    }

    private static int getArrayElementsSum(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(String.format("Incorrect value in position: [%d;%d]", i, j));
                }
            }
        }
        return sum;
    }

    private static void checkArraySquareSize(String[][] arr, int size) throws MyArraySizeException {
        boolean res = true;
        try {
            if (arr.length != size) {
                res = false;
            }
            for (int i = 0; i < size; i++) {
                if (arr[i].length != size) {
                    res = false;
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new MyArraySizeException("Array has incorrect size");
        }
        if (!res) {
            throw new MyArraySizeException("Array has incorrect size");
        }
    }
}
