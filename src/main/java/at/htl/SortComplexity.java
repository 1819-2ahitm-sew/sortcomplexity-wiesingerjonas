package at.htl;

import java.util.Scanner;

public class SortComplexity {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Anzahl der zu sortierenden Arrays: ");
        int amount = scanner.nextInt();

        System.out.print("Größe der Arrays: ");
        int length = scanner.nextInt();

        System.out.println();

        long sum = 0;

        for (int i = 0; i < amount; i++) {
            long time = sortRandomArray(length);

            System.out.println("Laufzeit zur Sortierung des " + (i+1) + ". Arrays: " + time + "ms");

            sum = sum + (int) time;
        }

        long average = sum / amount;

        System.out.println();

        System.out.println("Durchschnittliche Laufzeit: " + average + "ms");
    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {

        int timeBefore = (int) System.currentTimeMillis();

        int[] array = generateRandomArray(length);

        sort(array);

        int timeAfter = (int) System.currentTimeMillis();

        return timeAfter-timeBefore;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 1000 + 1);
        }

        return array;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            for (int j = 0; j < array.length - i; j++) {

                if (array[j] > array[j+1]) {

                    swap(array, j, j+1);

                }
            }
        }
        return;
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {

        int help = array[i];
        array[i] = array[j];
        array[j] = help;

    }
}
