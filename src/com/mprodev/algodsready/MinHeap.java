package com.mprodev.algodsready;
/* Mirshod created on 2/20/2021 */

import java.util.Arrays;
//binary min heap ds
//can be used lots of algo as base ds
//for example dijkstra
public class MinHeap {
    private final int capacity;
    private int heapSize;
    private final int[] heapArray;
    public MinHeap(int capacity) {
        this.capacity = capacity;
        heapArray = new int[capacity];
    }
//    **helper functions**
    void swap(int f, int s) {
        heapArray[f] = heapArray[f] + heapArray[s];
        heapArray[s] = heapArray[f] - heapArray[s];
        heapArray[f] = heapArray[f] - heapArray[s];
    }
    int parent(int i) {
        return (i - 1) / 2;
    }
//    left child of given index element
    int left(int i) {
        return 2 * i + 1;
    }
//    right child of given index element
    int right(int i) {
        return 2 * i + 2;
    }
//    **end of helper functions**
    int getMin() {
        return heapArray[0];
    }
//    swiftDown() method or sometimes minHeapify
    void swiftDown(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heapSize && heapArray[l] < heapArray[i])
            smallest = l;
        if (r < heapSize && heapArray[r] < heapArray[smallest])
            smallest = r;
        if (smallest !=i) {
            swap(smallest, i);
            swiftDown(smallest);
        }
    }
//    swiftUp() method
    void swiftUp(int i) {
        while (i >= 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    int extractMin() {
        if (heapSize <= 0)
            return Integer.MAX_VALUE;
        if (heapSize == 1) {
            heapSize--;
            return heapArray[0];
        }
        int min = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];
        heapSize--;
        swiftDown(0);
        return min;
    }
//    decrease value of key at index i to value
    void decreaseKey(int i, int value) {
        heapArray[i] = value;
        swiftUp(i);
    }
//    insert new element to the heap
    void insertKey(int k) {
        if (heapSize == capacity) {
            System.err.println("Overflow, not enough memory to store\n");
            return;
        }
        int i = heapSize;
        heapArray[i] = k;
        heapSize++;
        swiftUp(i);
    }
//    delete key at index i. logic decrease given index to MIN_VALUE
//    so definitely it will be in the root and then extractMin
    void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String[] args) {
        var h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        System.out.println(h.extractMin());
        System.out.println(h.getMin());
        h.decreaseKey(2, 1);
        System.out.println(h.getMin());
    }

}
