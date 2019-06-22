package ru.job4j.tree;
import java.util.Optional;
/**
 * Добавить элемент child в parent.
 * Parent может иметь список child.
 * @param parent parent.
 * @param child child.
 * @return
 */
public interface SimpleTree<E extends Comparable<E>> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
