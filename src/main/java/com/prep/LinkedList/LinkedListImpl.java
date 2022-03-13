package com.prep.LinkedList;

import lombok.Data;

@Data
public class LinkedListImpl<E> {

    private Node<E> first;
    private int size;

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void addLast(E element) {
        if (first == null) {
            first = new Node<>(element);
        } else {
            Node<E> curNode = first;
            while (first.next != null) {
                curNode = curNode.next;
            }
            curNode.next = new Node<>(element);
        }
    }

    public void deleteFirst() {
        Node<E> tmp = first;
        this.first = first.next;
        size--;
    }

    public E getElement(int index) {
        Node<E> res = first;
        for (int i = 0; i < index; i++) {
            res = first.next;
        }
        return res.data;
    }

    public void remove(E data) {
        if (first == null) {
            return;
        }
        if (first.data == data) {
            first = first.next;
        }
        Node<E> curNode = first;
        while (first.next != null) {
            if (first.next.data == data) {
                first.next = first.next.next;
                return;
            }
            curNode = curNode.next;
        }
    }

    public Node<E> reverseList() {
        if (first == null) {
            return null;
        }
        Node<E> curNode = first;
        Node<E> prev = null;
        while (curNode != null) {
            Node<E> nextNode = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = nextNode;
        }
        return prev;
    }

    @Data
    static class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
