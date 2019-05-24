package ru.job4j.list2;

import java.util.ConcurrentModificationException;

public class listNode<E> {

    private int size;
    private Node<E> node;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.node;
        this.node = newLink;
        this.size++;
    }
    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.node;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
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
//    final void checkForComodification() {
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
//    }
}
