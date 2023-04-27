package model;

public interface IHeap<K extends Comparable<K>,V> {

    void max_Heapify(Pair<K,V>[] array, int index);
    void min_Heapify(Pair<K,V>[] array, int i);

    void sortAscending(Pair<K,V>[] array);
    void sortDescending(Pair<K,V>[] array);
    void minHeap(Pair<K,V>[] array);
    void maxHeap(Pair<K,V>[] array);

}