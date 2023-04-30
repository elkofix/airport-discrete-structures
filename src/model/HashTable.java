package model;
import java.util.*;

public class HashTable<K, V> {
	private int capacity;
	private float loadFactor;
	private int size;
	private Map<K, V>[] table;

	public HashTable(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.table = new HashMap[capacity];
		for (int i = 0; i < capacity; i++) {
			table[i] = new HashMap<K, V>();
		}
	}

	public void put(K key, V value) {
		int index = hash(key);
		Map<K, V> bucket = table[index];
		if (!bucket.containsKey(key)) {
			size++;
		}
		bucket.put(key, value);
		if (size > capacity * 0.75f) {
			resize();
		}
	}
	public V get(K key) {
		int index = hash(key);
		Map<K, V> bucket = table[index];
		return bucket.get(key);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		Arrays.fill(table, new HashMap<K, V>());
		size = 0;
	}

	private int hash(K key) {
		return Math.abs(key.hashCode() % capacity);
	}

	private void resize() {
		int newCapacity = capacity * 2;
		Map<K, V>[] newTable = new HashMap[newCapacity];
		for (int i = 0; i < newCapacity; i++) {
			newTable[i] = new HashMap<K, V>();
		}
		for (Map<K, V> bucket : table) {
			for (Map.Entry<K, V> entry : bucket.entrySet()) {
				K key = entry.getKey();
				V value = entry.getValue();
				int index = Math.abs(key.hashCode() % newCapacity);
				newTable[index].put(key, value);
			}
		}
		capacity = newCapacity;
		table = newTable;
	}

	public void printTable() {

		for (Map<K, V> bucket : table) {
			for (Map.Entry<K, V> entry : bucket.entrySet()) {
				K key = entry.getKey();
				V value = entry.getValue();


				System.out.println(value + " -> " + key);
			}
		}
	}

	public Map<K, V>[] getTable() {
		return table;
	}

}
