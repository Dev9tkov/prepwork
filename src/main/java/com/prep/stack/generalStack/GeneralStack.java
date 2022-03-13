package com.prep.stack.generalStack;

import lombok.Data;

@Data
public class GeneralStack<T> {
    private Node<T> head;

    //return top value
    public T peek() {
        return head.value;
    }

    //return top value and delete them
    public T pop() {
        T value = head.value;
        head = head.next;
        return value;
    }

    //add value
    public void push(T t) {
        Node<T> curHead = new Node<>(t);
        curHead.next = head;
        head = curHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Data
    static class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T t) {
            this.value = t;
        }
    }
}
