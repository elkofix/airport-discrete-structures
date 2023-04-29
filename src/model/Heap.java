package model;

public class Heap<K extends Comparable<K>, V> implements IHeap<K,V>{

    private int size;
    private int heapSize;

    private Pair<K,V>[] array;

    public Heap(int size, int heapSize) {
        this.array = array;
        int heSize = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                heSize++;
            }
        }
        this.heapSize = heSize;
    }
    public void changePair(int i1, int i2) {
        Pair<K,V> temp = new Pair<K,V>(array[i1].getKey(), array[i1].getValue());
        Pair<K,V> temp2 = new Pair<K,V>(array[i2].getKey(), array[i2].getValue());
        array[i1] = temp2;
        array[i2] = temp;
    }


    @Override
    public void max_Heapify(Pair<K,V>[] array, int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest = index;

        if (left < heapSize && array[left].getKey().compareTo(array[index].getKey()) > 0) {
            largest = left;
        }
        if (right < heapSize && array[right].getKey().compareTo(array[largest].getKey()) > 0) {
            largest = right;
        }
        if (largest != index) {

            changePair(index, largest);
            max_Heapify(array, largest);
        }
    }

    @Override
    public void min_Heapify(Pair<K, V>[] array, int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int smallest = index;

        if (left < heapSize && array[left].getKey().compareTo(array[index].getKey()) < 0) {
            smallest = left;
        }
        if (right < heapSize && array[right].getKey().compareTo(array[smallest].getKey()) < 0) {
            smallest = right;
        }
        if (smallest != index) {

            changePair(index, smallest);
            min_Heapify(array, smallest);
        }
    }

    @Override
    public void sortAscending(Pair<K, V>[] array) {
        for (int i = heapSize - 1; i >= 1; i--) {
            changePair(0, i);
            heapSize--;
            max_Heapify(array, 0);
        }
    }

    @Override
    public void sortDescending(Pair<K, V>[] array) {
        for (int i = heapSize - 1; i >= 1; i--) {
            changePair(0, i);
            heapSize--;
            min_Heapify(array, 0);
        }
    }

    @Override
    public void minHeap(Pair<K, V>[] array) {
        for (int i = Math.floorDiv(array.length, 2); i >= 0; i--) {
            min_Heapify(array, i);
        }
    }

    @Override
    public void maxHeap(Pair<K, V>[] array) {
        for (int i = Math.floorDiv(array.length, 2); i >= 0; i--) {
            max_Heapify(array, i);
        }
    }

    public int getLeft(int i) {
        if (i == 0) {
            return 1;
        }
        return 2 * i;
    }
    public int getRight(int i) {
        if (i == 0) {
            return 2;
        }
        return 2 * i + 1;
    }
    public int getParent(int i) {
        if (i == 0) {
            return 0;
        }
        return Math.floorDiv(i, 2);
    }


}
