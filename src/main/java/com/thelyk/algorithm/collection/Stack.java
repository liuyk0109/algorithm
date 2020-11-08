package com.thelyk.algorithm.collection;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    private Node<T> first;

    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<>(item, oldFirst);
        size++;
    }

    public T pop() {
        if (first == null) {
            throw new EmptyStackException();
        }
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
