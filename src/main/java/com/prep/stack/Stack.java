package com.prep.stack;

import lombok.Data;

@Data
public class Stack {
    private int size = 10;
    private int top;
    private int[] array;

    public Stack() {
        array = new int[size];
        top = -1;
    }

    public void push(int v) {
        array[++top] = v;
    }

    public int pop() {
        return array[top--];
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
