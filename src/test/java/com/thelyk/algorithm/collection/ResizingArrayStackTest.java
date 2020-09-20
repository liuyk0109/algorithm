package com.thelyk.algorithm.collection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class ResizingArrayStackTest {

	@Test
	void testAll() {
		ResizingArrayStack<String> stack = new ResizingArrayStack<>();
		assertThrows(EmptyStackException.class, stack::pop);
		Iterator<String> iterator = stack.iterator();
		assertThrows(NoSuchElementException.class, iterator::next);
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
		stack.push("something");
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
		assertEquals("something", stack.pop());

		int i = 100;
		for (int j = 1; j <= i; j++) {
			stack.push(String.valueOf(j));
		}
		assertEquals(i, stack.size());
		iterator = stack.iterator();
		assertTrue(iterator.hasNext());
		while (iterator.hasNext()) {
			String next = iterator.next();
			assertEquals(String.valueOf(i--), next);
		}
	}
}