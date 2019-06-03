package ru.job4j.list2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NodeLoop<T> implements Iterable<T> {
    private T value;
    private Node<T> next;
    private int modCount;

    public NodeLoop(T value) {
        this.value = value;
    }

    boolean hasCycle(Node first) {
        Node fast = first;
        Node slow = first;

        while(fast.next != null && fast.next.next != null && slow.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node <T> next) {
        this.next = next;
    }

    @Override
    public Iterator <T> iterator() {
        return new Iterator <T>() {
            private Node<T> node = next;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return node != null;
            }
            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = node.data;
                node = node.next;
                return result;
            }
        };
    }
}

