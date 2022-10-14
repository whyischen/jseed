package com.whyischen.algorithm;

import java.util.List;

public class ArrayStack {

    private Object[] stack;
    private int size;
    private int head;

    private final int maxIndex;

    public ArrayStack(int initCapacity) {
        stack = new Object[initCapacity];
        maxIndex = initCapacity - 1;
        size = 0;
        head = 0;
    }

    public void push(Object val) {
        if (size >= maxIndex) {
            throw new RuntimeException();
        }

        if (++head > maxIndex) {
            head = 0;
        }
        stack[head] = val;
        size++;
    }

    public Object pop() {
        if (size <= 0) {
            throw new RuntimeException();
        }

        var val = stack[head];
        head--;
        size--;
        return null;
    }

}
