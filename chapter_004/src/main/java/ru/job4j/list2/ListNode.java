package ru.job4j.list2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListNode<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private int modCount;

    public ListNode(int size, Node <E> first, int modCount) {
        this.size = size;
        this.first = first;
        this.modCount = modCount;
    }

    /**
     * Метод вставляет в начало списка данные.
     */

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        modCount++;
        this.size++;
    }
    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }
    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }
    @Override
    public Iterator <E> iterator() {
        return new Iterator <E>() {
            private Node<E> node = first;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return node != null;
            }
            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = node.data;
                node = node.next;
                return result;
            }
        };
    }
}
