package model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueueMethod<T extends Comparable<T>> {

    private ArrayList<T> heap;

    public PriorityQueueMethod() {
        heap = new ArrayList<T>();
    }

    public void insert(T item) {
        heap.add(item);
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0 && heap.get(currentIndex).compareTo(heap.get(parentIndex(currentIndex))) > 0) {
            swap(currentIndex, parentIndex(currentIndex));
            currentIndex = parentIndex(currentIndex);
        }
    }

    public T remove() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }

        T root = heap.get(0);
        if (heap.size() == 1) {
            heap.remove(0);
            return root;
        }

        heap.set(0, heap.remove(heap.size() - 1));
        heapify(0);

        return root;
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }

        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public T get(int i){

        return heap.get(i);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapify(int index) {
        int largestIndex = index;

        int leftIndex = leftChildIndex(index);
        if (leftIndex < heap.size() && heap.get(leftIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = leftIndex;
        }

        int rightIndex = rightChildIndex(index);
        if (rightIndex < heap.size() && heap.get(rightIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            heapify(largestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    public void printQueue() {
        PriorityQueueMethod<T> tempQueue = new PriorityQueueMethod<T>();
        while (!isEmpty()) {
            T item = remove();
            System.out.println(item);
            tempQueue.insert(item);
        }
        heap = tempQueue.heap;
    }
}
