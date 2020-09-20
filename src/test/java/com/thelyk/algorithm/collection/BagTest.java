package com.thelyk.algorithm.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class BagTest {

	@Test
	void testAll() {
		Bag<String> bag = new Bag<>();
		Iterator<String> iterator = bag.iterator();
		assertThrows(NoSuchElementException.class, iterator::next);
		assertTrue(bag.isEmpty());
		assertEquals(0, bag.size());

		int i = 100;
		for (int j = 1; j <= i; j++) {
			bag.add(String.valueOf(j));
		}
		assertFalse(bag.isEmpty());
		assertEquals(i, bag.size());
		iterator = bag.iterator();
		assertTrue(iterator.hasNext());
		while (iterator.hasNext()) {
			String next = iterator.next();
			assertEquals(String.valueOf(i--), next);
		}
	}
}