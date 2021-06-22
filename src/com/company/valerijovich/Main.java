package com.company.valerijovich;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(999);
        }

        System.out.println("Initial array is: " + Arrays.toString(array));

        array = sortArray(array);

        System.out.println("Sorted array is: " + Arrays.toString(array));
    }

    private static int[] sortArray(int[] array1) {

        if (array1 == null)
            return null;

        if (array1.length  < 2)
            return array1;

        int[] array2 = new int[array1.length / 2];
        System.arraycopy(array1, 0, array2, 0, array1.length / 2);

        int[] array3 = new int[array1.length - array1.length / 2];
        System.arraycopy(array1, array1.length / 2, array3, 0, array1.length - array1.length / 2);

        array2 = sortArray(array2);
        array3 = sortArray(array3);

        return mergeArray(array2, array3);
    }

    private static int[] mergeArray(int[] array1, int[] array2) {

        int[] array3 = new int[array1.length + array2.length];
        int position1 = 0, position2 = 0;

        for (int i = 0; i < array3.length; i++) {

            if (position1 == array1.length) {
                array3[i] = array2[position2];
                position2++;
            } else if (position2 == array2.length) {
                array3[i] = array1[position1];
                position1++;
            } else if (array1[position1] <= array2[position2]) {
                array3[i] = array1[position1];
                position1++;
            } else {
                array3[i] = array2[position2];
                position2++;
            }
        }
        return array3;
    }
}
