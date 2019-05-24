package ru.job4j.list2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class listNode<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
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
            int str;
            @Override
            public boolean hasNext() {
                return str < size;
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return first.data;
            }
        };
    }
}
