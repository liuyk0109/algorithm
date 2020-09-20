package com.thelyk.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

class SelectionTest {

	Random random = new Random();

	@Test
	void sort() {
		for (int i = 0; i < 100; i++) {
			Double[] a = new Double[100];
			for (int j = 0; j < 100; j++) {
				a[j] = random.nextDouble() * 10000;
			}
			Selection.sort(a);
			assertTrue(Selection.isSorted(a));
		}
	}
}