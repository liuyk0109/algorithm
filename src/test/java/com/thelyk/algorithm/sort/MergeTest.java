package com.thelyk.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeTest {

    Random random = new Random();

    @Test
    void sort() {
        for (int i = 0; i < 100; i++) {
            Double[] a = new Double[100];
            for (int j = 0; j < 100; j++) {
                a[j] = random.nextDouble() * 10000;
            }
            Merge.sort(a);
            assertTrue(SortUtil.isSorted(a));
        }
    }

}