package com.prep.ArrayList;

import java.util.Arrays;
import lombok.Data;

@Data
public class ArrayListImpl<T> {

    private int size;
    private int capacity = 4;
    private int index;
    private T[] container;

    public ArrayListImpl() {
        container = (T[]) new Object[capacity];
    }

    public void addElement(T element) {
        if (index == container.length) {
            growUp();
        } else {
            size++;
        }
        container[index++] = element;
    }

    public void deleteElement(int index) {
        container[index] = null;
        /**
         * src – the source array.
         * srcPos – starting position in the source array.
         * dest – the destination array.
         * destPos – starting position in the destination data.
         * length – the number of array elements to be copied.
         */
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        size--;
        this.index--;
    }

    public T getElement(int index) {
        return container[index];
    }

    private void growUp() {
        container = Arrays.copyOf(container, capacity * 2);
    }
}
