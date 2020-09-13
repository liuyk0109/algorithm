package com.thelyk.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<T> implements Iterable<T> {

	private T[] a = (T[]) new Object[1];
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void resize(int max) {
		a = Arrays.copyOf(a, max);
	}

	public void push(T item) {
		if (size == a.length) {
			resize(2 * a.length);
		}
		a[size++] = item;
	}

	public T pop() {
		T item = a[--size];
		a[size] = null;
		if (size > 0 && size == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<T> {
		private int i = size;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			if (i == 0) {
				throw new NoSuchElementException();
			}
			return a[--i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
