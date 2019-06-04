package ru.job4j.list2;

public class Node<T> {

    private T data;
    Node<T> next;
    Node(T data) {
        this.data = data;
    }

    public Node <T> getNext() {
        return next;
    }

    public void setNext(Node <T> next) {
        this.next = next;
    }
}


