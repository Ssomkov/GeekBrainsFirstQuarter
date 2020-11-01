package ru.geekbrains.java.lesson2;

public class Main {

    public static void main(String[] args) {

        int binaryArray[] = {0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1};
        int eightLengthArray[] = new int[8];
        int arrayForMultiply[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int arrayForMinAndMax[] = {7, 1, -3, 13, 9, -44, 5, 0, 14, 8, -9, 21, 5};
        int arrayForSum[] = {1, 9, 5, 5};

        printArray(binaryArray);

        printArray(invertBinaryArrayValues(binaryArray));

        printArray(fillSimpleArray(eightLengthArray));

        printArray(multiplyArrayNumbers(arrayForMultiply));

        printArray(getFilledDiagonalsInTable(9));

        System.out.println("Array min: ".concat(String.valueOf(getArrayMinimumValue(arrayForMinAndMax))));
        System.out.println("Array max: ".concat(String.valueOf(getArrayMaximumValue(arrayForMinAndMax))));

        System.out.println(hasEqualsParts(arrayForSum));

    }

    //task1
    public static int[] invertBinaryArrayValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 1:
                    array[i] = 0;
                    break;
                case 0:
                    array[i] = 1;
                    break;
                default:
                    break;
            }
        }
        return array;
    }

    //task2
    public static int[] fillSimpleArray(int[] array) {
        int step = 3;
        array[0] = 0;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + step;
        }
        return array;
    }

    //task3
    public static int[] multiplyArrayNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    //task4
    public static int[][] getFilledDiagonalsInTable(int size) {
        int resultTable[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    resultTable[i][j] = 1;
                }
                if (j == size - 1 - i) {
                    resultTable[i][j] = 1;
                }
            }
        }
        return resultTable;
    }

    //task5
    public static int getArrayMinimumValue(int[] array) {
        int minimum = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < minimum) {
                minimum = array[i + 1];
            }
        }
        return minimum;
    }

    //task5
    public static int getArrayMaximumValue(int[] array) {
        int maximum = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] > maximum) {
                maximum = array[i + 1];
            }
        }
        return maximum;
    }

    //task6
    public static boolean hasEqualsParts(int[] array) {

        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < array.length; i++) {

            if (array.length <= 3) {
                return false;
            }

            if (((array.length - i) >= 2) & (i != 0)) {
                //calculate first sum
                for (int j = 0; j <= i; j++) {
                    firstSum = firstSum + array[j];
                }
                //calculate second sum
                for (int j = i + 1; j < array.length; j++) {
                    secondSum = secondSum + array[j];
                }
                //check sum equals
                if (firstSum == secondSum) {
                    return true;
                }
                firstSum = 0;
                secondSum = 0;
            }
        }
        return false;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printArray(int[][] array) {
        for (int[] anArray : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(anArray[j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
