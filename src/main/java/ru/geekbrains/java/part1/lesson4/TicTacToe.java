package ru.geekbrains.java.part1.lesson4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe {

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static int SIZE = 3;
    private static int DOTS_TO_WIN = 3;
    private static char[][] desk;

    private static Scanner scanner = new Scanner(System.in);

    private static boolean isDeskFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (desk[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static void computerTurn() {
        int x, y;
        do {
            x = getRandomIntFromZeroToIncludedBorder(SIZE);
            y = getRandomIntFromZeroToIncludedBorder(SIZE);
        } while (!isCellValid(x, y));
        System.out.printf("Computer marked point: [%d, %d]", (x + 1), (y + 1));
        System.out.println();
        desk[y][x] = DOT_O;
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Input point [X Y]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        desk[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return desk[y][x] == DOT_EMPTY;
    }

    private static void initDesk() {
        desk = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                desk[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printDesk() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(desk[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getRandomIntFromZeroToIncludedBorder(int border) {
        return ThreadLocalRandom.current().nextInt(border + 1);
    }

    private static boolean checkWinnerHorizontal() {
        int countX;
        int countO;
        for (int i = 0; i < SIZE; i++) {
            countX = 0;
            countO = 0;
            for (int j = 0; j < SIZE; j++) {
                if (desk[i][j] == DOT_X) {
                    countX++;
                    countO = 0;
                } else {
                    if (desk[i][j] == DOT_O) {
                        countO++;
                        countX = 0;
                    }
                }
            }
            if ((countO == DOTS_TO_WIN) || (countX == DOTS_TO_WIN)) {
                System.out.printf("Winning combination in '%d' line", i + 1);
                System.out.println();
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinnerVertical() {
        int countX;
        int countO;
        for (int i = 0; i < SIZE; i++) {
            countX = 0;
            countO = 0;
            for (int j = 0; j < SIZE; j++) {
                if (desk[j][i] == DOT_X) {
                    countX++;
                    countO = 0;
                } else {
                    if (desk[j][i] == DOT_O) {
                        countO++;
                        countX = 0;
                    }
                }
            }
            if ((countO == DOTS_TO_WIN) || (countX == DOTS_TO_WIN)) {
                System.out.printf("Winning combination in '%d' column", i + 1);
                System.out.println();
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinnerDiagonal() {
        int countX = 0;
        int countO = 0;
        //[left top corner -> right bottom corner]
        for (int i = 0; i < SIZE; i++) {
            if (desk[i][i] == DOT_X) {
                countX++;
                countO = 0;
            } else {
                if (desk[i][i] == DOT_O) {
                    countO++;
                    countX = 0;
                }
            }
        }
        if ((countO == DOTS_TO_WIN) || (countX == DOTS_TO_WIN)) {
            System.out.printf("Winning combination in diagonal [left top corner -> right bottom corner]");
            System.out.println();
            return true;
        }
        countX = 0;
        countO = 0;
        //[right top corner -> left bottom corner]
        for (int i = 0; i < SIZE; i++) {
            if (desk[SIZE - i - 1][i] == DOT_X) {
                countX++;
                countO = 0;
            } else {
                if (desk[SIZE - i - 1][i] == DOT_O) {
                    countO++;
                    countX = 0;
                }
            }
        }
        if ((countO == DOTS_TO_WIN) || (countX == DOTS_TO_WIN)) {
            System.out.printf("Winning combination in diagonal [right top corner -> left bottom corner]");
            System.out.println();
            return true;
        }
        return false;
    }

    public static void runGame() {
        initDesk();
        printDesk();
        while (true) {
            humanTurn();
            printDesk();
            if (checkWinnerHorizontal() || checkWinnerVertical() || checkWinnerDiagonal()) {
                System.out.println("You won!");
                break;
            }
            if (isDeskFull()) {
                System.out.println("There are no available moves");
                break;
            }
            computerTurn();
            printDesk();
            if (checkWinnerHorizontal() || checkWinnerVertical() || checkWinnerDiagonal()) {
                System.out.println("Computer won!");
                break;
            }
            if (isDeskFull()) {
                System.out.println("There are no available moves");
                break;
            }
        }
        System.out.println("Game over");
    }
}
