package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable <E>> implements SimpleTree<E> {

    private Node root = null;
    private Node[] nodes;

    @Override
    public boolean add(E parent, E child) {
        Node<E> t = root;
        if (t == null) {
            root = new Node<E>(parent);
            return true;
        }
     return false;
    }

    @Override
    public Optional <Node <E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

}
