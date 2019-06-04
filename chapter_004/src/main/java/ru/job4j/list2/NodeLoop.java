package ru.job4j.list2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NodeLoop<T> {

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
}

