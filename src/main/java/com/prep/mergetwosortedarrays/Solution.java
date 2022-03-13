package com.prep.mergetwosortedarrays;

import java.util.Arrays;

public class Solution {

    //length left = length right
    public static int[] merge(int[] left, int[] right) {
        int[] supportArray = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < supportArray.length; i++) {
            if (l >= left.length) {
                supportArray[i] = right[r];
                r++;
            } else if (r >= right.length) {
                supportArray[i] = left[r];
                l++;
            } else if (left[l] < right[r]) {
                supportArray[i] = left[l];
                l++;
            } else {
                supportArray[i] = right[r];
                r++;
            }
        }
        return supportArray;
    }

    /**
     * @param array начальный массив
     * @param ls индекс начало первой подпоследовательности
     * @param le индекс конец первой подпоследовательности
     * @param rs индекс начало второй подпоследовательности
     * @param re индекс конец второй подпоследовательности
     *
     * array = {1, 3, 6, 9, --- 2, 4, 4, 7}
     * merge(array, 0, 3, 4, 7)
     */
    public static int[] merge(int[] array, int ls, int le, int rs, int re) {
        int[] supportArray = Arrays.copyOf(array, array.length);
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
        return supportArray;
    }

    public static void main(String[] args) {
        merge(new int[]{1, 3, 5, 6}, new int[]{2, 3, 4, 8});
    }
}
