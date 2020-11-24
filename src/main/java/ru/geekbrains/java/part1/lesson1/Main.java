package ru.geekbrains.java.part1.lesson1;

public class Main {

    public static void main(String[] args) {

        int intVarieble = 232133424;
        byte byteVarieble = 12;
        short shortVarieble = -123;
        boolean boolVarieble = false;
        long longVarieble = 534534534L;
        float floatVarieble = 3.5f;
        double doubleVarieble = 232.45d;
        char charVarieble = 'f';
        String stringVarieble = "Иван";

        System.out.println(task3(1, 2, 3, 2));
        System.out.println(task4(4, 6));
        task5(shortVarieble);
        System.out.println(task6(byteVarieble));
        task7(stringVarieble);
    }

    /*
    3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные
    параметры этого метода;
     */
    private static int task3(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    /*
    4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
    от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    */
    private static boolean task4(int a, int b) {
        int sum = a + b;
        return (sum <= 20) & (sum >= 10);
    }

    /*
    5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    */
    private static void task5(int a) {
        if (a >= 0) {
            System.out.println(String.format("Число '%d' положительное", a));
        } else {
            System.out.println(String.format("Число '%d' отрицательное", a));
        }
    }

    /*
    6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число
    отрицательное;
     */
    private static boolean task6(int a) {
        return a <= 0;
    }

    /*
    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести
    в консоль сообщение «Привет, указанное_имя!»;
     */
    private static void task7(String name) {
        System.out.println(String.format("Привет, %s!", name));
    }
}
