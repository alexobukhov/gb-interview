package ru.gb.gbinterview.list;

import java.util.Arrays;

public class MyArrayList<E> {

    private static int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    public MyArrayList(Object[] elementData) {
        this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public void add(E element, int index) {
        checkRange(index);
        int initialSize = size;
        if (size == elementData.length) {
            size = (int) (size * 1.5);
            Arrays.copyOf(elementData, size);
        }
        System.arraycopy(elementData, index, elementData, index + 1, initialSize - index);
        elementData[index] = element;
    }

    public void delete(Object[] elements, int index) {
        if ((size - 1) > 1)
            System.arraycopy(elements, index + 1, elements, index, size - index);
        elements[size] = null;
    }

    private void checkRange(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}
