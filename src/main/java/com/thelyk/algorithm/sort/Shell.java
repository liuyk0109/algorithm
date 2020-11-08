package com.thelyk.algorithm.sort;

public class Shell {

    public static <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && SortUtil.less(a[j], a[j - h]); j -= h) {
                    SortUtil.exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
