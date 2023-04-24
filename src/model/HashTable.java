package model;

public class HashTable<K, V> {
    private static final int SIZE_TABLE = 10;
    private Node<K, V>[] table;

    public HashTable() {
        table = new Node[SIZE_TABLE];
    }

    // hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE_TABLE;
    }

    public String add(K key, V value) {
        String msj = "";

        int index = hash(key);
        Node<K, V> newNode = new Node<K, V>(key, value);
        // si no hay ninguna colision
        if (table[index] == null) {
            table[index] = newNode;
            msj = "New node added";
        } else {
            // si hay colison, se agrega el nodo al final
            Node<K, V> current = table[index];
            while (current.getNext() != null) {
                current = current.getNext();

            }
            current.setNext(newNode);
            msj = "New node added";
        }
        return msj;
    }

    public V getValue(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        } else {
            Node<K, V> current = table[index];
            while (current.getNext() != null) {
                if (current.getKey().equals(key)) {
                    return current.getValue();
                }
                current = current.getNext();

            }
            return null;
        }
    }

    public String remove(K key) {
        String msj = "";
        int index = hash(key);

        if (table[index] == null) {
            msj = "Value not found to delete";
        } else {
            if (table[index].getKey().equals(key)) {
                table[index] = table[index].getNext();
            } else {
                Node<K, V> current = table[index];
                while (current.getNext() != null && !current.getKey().equals(key)) {
                    current = current.getNext();
                }
                if (current.getNext() != null) {
                    current.setNext(current.getNext().getNext());

                }
            }
        }
        return msj;

    }

}
