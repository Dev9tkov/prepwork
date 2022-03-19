package com.prep.queue.generalqueue;

import lombok.Data;

public class GeneralQueue<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T t) {
        Node<T> node = new Node<>(t);
        tail.next = node;
        this.tail = node;
        size++;
    }

    public T peek() {
        return head.value;
    }

    public void poll() {
        if (size == 0) {
            return;
        }
        head = head.next;
        size--;
    }

    @Data
    static class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
