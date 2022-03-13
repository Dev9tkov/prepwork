package com.prep.mergetwosortedarrays;

import java.util.Arrays;

public class RecursiveSolution {

    public static void mergeSort(int[] array) {
        int[] supportArray = Arrays.copyOf(array, array.length);
        int startIndex = 0;
        int endIndex = array.length - 1;
        mergeSort(array, supportArray, startIndex, endIndex);
    }

    public static void mergeSort(int[] array, int[] support, int startIndex, int endIndex) {
        if (startIndex >= endIndex) { //condition of ending recursion
            return;
        }
        int h = startIndex + (endIndex - startIndex) / 2; //mid
        mergeSort(array, support, startIndex, h); //сортировка левой подпоследоввательности
        mergeSort(array, support, h + 1, endIndex); //сортировка правой подпоследоввательности
        merge(array, support, startIndex, h, h + 1, endIndex);
    }

    public static void merge(int[] array, int[] supportArray, int ls, int le, int rs, int re) {
        int l = ls;
        int r = rs;
        for (int i = ls; i <= re; i++) {
            if (l >= le) {
                supportArray[i] = array[r];
                r++;
            } else if (r >= re) {
                supportArray[i] = array[l];
                l++;
            } else if (array[l] < array[r]) {
                supportArray[i] = array[l];
                l++;
            } else {
                supportArray[i] = array[r];
                r++;
            }
        }
    }
}
