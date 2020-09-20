package com.thelyk.algorithm.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testAll() {
		Queue<String> queue = new Queue<>();
		assertNull(queue.dequeue());
		Iterator<String> iterator = queue.iterator();
		assertThrows(NoSuchElementException.class, iterator::next);
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
		queue.enqueue("something");
		assertFalse(queue.isEmpty());
		assertEquals(1, queue.size());
		assertEquals("something", queue.dequeue());

		int i = 100;
		for (int j = 1; j <= i; j++) {
			queue.enqueue(String.valueOf(j));
		}
		assertEquals(i, queue.size());
		iterator = queue.iterator();
		assertTrue(iterator.hasNext());
		while (iterator.hasNext()) {
			String next = iterator.next();
			assertEquals(String.valueOf(100 - --i), next);
		}
	}
}