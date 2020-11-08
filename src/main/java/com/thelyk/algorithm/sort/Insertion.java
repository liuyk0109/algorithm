package com.thelyk.algorithm.sort;

public class Insertion {

    public static <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && SortUtil.less(a[j], a[j - 1]); j--) {
                SortUtil.exchange(a, j, j - 1);
            }
        }
    }
}
