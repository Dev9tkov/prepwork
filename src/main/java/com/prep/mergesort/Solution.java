package com.prep.mergesort;

import java.util.Arrays;

public class Solution {

    public static void mergeSort(int[] array) {
        int[] supportArray = Arrays.copyOf(array, array.length); // копия начального массива
        int n = array.length;
        for (int size = 1; size < n; size *= 2) { //цикл. Начальный размер подпоследовательности = 1, каждый раз увеличиваем в 2 раза
            for (int j = 0; j < n - size; j += 2 * size) {
                merge(array, supportArray, j, j + size - 1, j + size, Math.min(j + 2 * size - 1, n - 1));
            }
        }
    }

    /**
     * Слияние отсортированных подпоследовательностей
     * @param array начальный массив
     * @param supportArray вспомогательный массив
     * @param ls индекс начало первой подпоследовательности
     * @param le индекс конец первой подпоследовательности
     * @param rs индекс начало второй подпоследовательности
     * @param re индекс конец второй подпоследовательности
     *
     * array = {1, 3, 6, 9, --- 2, 4, 5, 7}
     * merge(array, supportArray, 0, 3, 4, 7)
     */
    public static void merge(int[] array, int[] supportArray, int ls, int le, int rs, int re) {
        for (int i = ls; i <= re; i++) {
            supportArray[i] = array[i];
        }
        int l = ls;//0
        int r = rs;//4
        for (int i = ls; i <= re; i++) {
            if (l > le) {
                array[i] = supportArray[r];
                r++;
            } else if (r > re) {
                array[i] = supportArray[l];
                l++;
            } else if (supportArray[l] < supportArray[r]) {
                array[i] = supportArray[l];
                l++;
            } else {
                array[i] = supportArray[r];
                r++;
            }
        }
    }
}
