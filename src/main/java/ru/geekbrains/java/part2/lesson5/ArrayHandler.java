package ru.geekbrains.java.part2.lesson5;

public class ArrayHandler {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    float[] arr1 = new float[h];
    float[] arr2 = new float[h];

    public void handleWithSingleTread() {
        System.out.println("Handle with single tread ----->");
        arr = fillArrayWithSimpleCondition(arr);
        long firstTime = System.currentTimeMillis();
        arr = fillArrayWithAdvancedCondition(arr);
        long secondTime = System.currentTimeMillis();
        System.out.println("Time of simple thread method (fillArrayWithAdvancedCondition): " + (secondTime - firstTime));
    }

    public void handleWithMultiTreads() {
        System.out.println("Handle with multi tread ----->");
        long firstTime = System.currentTimeMillis();
        cutArray();
        long secondTime = System.currentTimeMillis();
        System.out.println("Time of multi thread method (cutArray): " + (secondTime - firstTime));

        firstTime = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> arr1 = fillArrayWithSimpleCondition(arr1));
        Thread thread2 = new Thread(() -> arr1 = fillArrayWithSimpleCondition(arr1));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        secondTime = System.currentTimeMillis();
        System.out.println("Time of multi thread method (fillArrayWithSimpleCondition): " + (secondTime - firstTime));

        firstTime = System.currentTimeMillis();
        mergeArray();
        secondTime = System.currentTimeMillis();
        System.out.println("Time of multi thread method (mergeArray): " + (secondTime - firstTime));

        firstTime = System.currentTimeMillis();
        Thread thread3 = new Thread(() -> arr1 = fillArrayWithAdvancedCondition(arr1));
        Thread thread4 = new Thread(() -> arr2 = fillArrayWithAdvancedCondition(arr2));

        thread3.start();
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        secondTime = System.currentTimeMillis();
        System.out.println("Time of multi thread method (fillArrayWithAdvancedCondition): " + (secondTime - firstTime));
    }

    private void cutArray() {
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
    }

    private void mergeArray() {
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
    }

    private float[] fillArrayWithSimpleCondition(float[] arr) {
        float[] array = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = 1;
        }
        return array;
    }

    private float[] fillArrayWithAdvancedCondition(float[] arr) {
        float[] array = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return array;
    }
}
