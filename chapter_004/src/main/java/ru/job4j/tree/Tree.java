package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable <E>> implements SimpleTree<E> {

    private Node root;
    private Node[] nodes;

    public Tree(E root) {
        this.root = new Node<>(root);
    }
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
      Optional<Node<E>> byParent = findBy(parent);   //ошибка
      if(byParent.isPresent()) {
          Optional<Node<E>> byChild = findBy(child);
          if (byChild.isEmpty()) {
              byParent.get().add(new Node <>(child));
              result = true;
          }
      }
     return result;
    }

    @Override
    public Optional <Node <E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {  //ошибка
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    Iterator it = new Iterator() {
        int ind;
        @Override
        public boolean hasNext() {
            return ind < nodes.length;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) nodes[ind++];
        }
    };
}
