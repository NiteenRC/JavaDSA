package programs.custom;

import java.util.LinkedList;
import java.util.List;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private final double loadFactor;
    private int size;
    private int capacity;
    private List<Entry<K, V>>[] buckets;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public CustomHashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        this.buckets = new LinkedList[capacity];
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
        resizeIfNeeded();
        return null;
    }

    public V get(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    buckets[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity; // Ensure non-negative index
    }


    private void resizeIfNeeded() {
        if ((double) size / capacity > loadFactor) {
            capacity *= 2;
            List<Entry<K, V>>[] newBuckets = new LinkedList[capacity];
            for (List<Entry<K, V>> bucket : buckets) {
                if (bucket != null) {
                    for (Entry<K, V> entry : bucket) {
                        int index = getIndex(entry.key);
                        if (newBuckets[index] == null) {
                            newBuckets[index] = new LinkedList<>();
                        }
                        newBuckets[index].add(entry);
                    }
                }
            }
            buckets = newBuckets;
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class CustomHashMapNodeImpl {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Adding key-value pairs to the map
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        // Displaying the size of the map
        System.out.println("Size of the map: " + map.size());

        // Getting values from the map
        System.out.println("Value for key 'apple': " + map.get("apple")); // Output: 10
        System.out.println("Value for key 'banana': " + map.get("banana")); // Output: 20
        System.out.println("Value for key 'cherry': " + map.get("cherry")); // Output: 30

        // Removing a key-value pair from the map
        map.remove("banana");

        // Displaying the size of the map after removal
        System.out.println("Size of the map after removal: " + map.size());

        // Trying to get the value for the removed key
        System.out.println("Value for key 'banana' after removal: " + map.get("banana")); // Output: null
    }
}
