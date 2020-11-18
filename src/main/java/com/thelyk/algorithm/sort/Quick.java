package com.thelyk.algorithm.sort;

import java.util.Random;

public class Quick {

    private static final Random random = new Random();

    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int randomIndex = random.nextInt(hi - lo) + lo;
        SortUtil.exchange(a, lo, randomIndex);
        T v = a[lo];
        while (true) {
            while (SortUtil.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (SortUtil.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            SortUtil.exchange(a, i, j);
        }
        SortUtil.exchange(a, lo, j);
        return j;
    }
}
