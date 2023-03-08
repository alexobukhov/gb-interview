package ru.gb.gbinterview.list;

public class MyLinkedList<E> {

    int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        checkElement(index);

        if (index == size)
            linkAfter(element);
        else
            linkBefore(element, node(index));
    }

    public void delete(int index) {
        checkElement(index);
        unlink(node(index));
    }

    public E get(int index) {
        checkElement(index);
        return node(index).item;
    }

    private void checkElement(int index) {
        boolean check = index >= 0 && index <= size;
        if (!check) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void linkBefore(E element, Node<E> node) {
        final Node<E> prev = node.prev;
        final Node<E> current = new Node<>(prev, element, node);
        node.prev = current;
        if (prev == null)
            first = current;
        else
            prev.next = current;
        size++;
    }

    private void linkAfter(E element) {
        final Node<E> prev = last;
        final Node<E> current = new Node<>(prev, element, null);
        last = current;
        if (prev == null)
            first = current;
        else
            prev.next = current;
        size++;
    }

    void unlink(Node<E> node) {
        final E element = node.item;
        Node<E> next = node.next;
        final Node<E> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    int size() {
        return this.size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
