package com.thelyk.algorithm.sort;

public class MergeBU {

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (SortUtil.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
