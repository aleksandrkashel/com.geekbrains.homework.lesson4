package com.geekbrains.homework.lesson5;

import java.util.Arrays;

public class Homework5 {
    public static void main(String[] args) throws InterruptedException {
        int size = 10_000_000;
        int half = size / 2;
        float[] arr =new float[size];
        Arrays.fill(arr, 1.0f);

        firstMethod(arr);
        secondMethod(arr, size, half);
    }

    public static void firstMethod(float[] arr) {
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
        System.out.println("One thread time:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void secondMethod(float[] arr, int size, int half) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        float[] leftHalf = new float[half];
        float[] rightHalf = new float[half];

        System.arraycopy(arr, 0, leftHalf, 0, half);
        System.arraycopy(arr, half, rightHalf, 0, half);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0)
                        * Math.cos(0.4f + i / 2.0));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0)
                        * Math.cos(0.4f + i / 2.0));
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        float[] mergedArray = new float[size];
        System.arraycopy(leftHalf, 0, mergedArray, 0, half);
        System.arraycopy(rightHalf, 0, mergedArray, half, half);

        System.out.println("Two thread time:" + (System.currentTimeMillis() - startTime) + "ms");

    }
}
