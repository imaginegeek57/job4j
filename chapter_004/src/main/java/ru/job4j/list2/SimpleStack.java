package ru.job4j.list2;

import java.util.NoSuchElementException;

public class SimpleStack<E>  {

    private ListNode <E> node = null;

    public SimpleStack(ListNode <E> node) {
        this.node = node;
    }
    public void push(E value) {
        ListNode <E> last = new ListNode <>();
        last.add(value);
    }
    public E poll() {
        ListNode <E> last = new ListNode <>();
        if (node.getSize() == 0) {
            throw new NoSuchElementException(); // здесь другое исключение?
        }
        E result = node. ;  //

        return result;
    }
}
