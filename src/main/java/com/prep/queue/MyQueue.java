package com.prep.queue;

public class MyQueue {
    private int[] array;
    private int size = 10;
    private int head;
    private int tail;
    private int count;

    public MyQueue() {
        this.array = new int[size];
        this.head = 0;
        this.tail = -1;
        this.count = 0;
    }

    public void insert(int v) {
        if (tail == size - 1) {
            tail = -1;
        }
        array[++tail] = v;
        count++;
    }

    public int remove() {
        if (head == size) {
            head = 0;
        }
        count--;
        return array[head++];
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
