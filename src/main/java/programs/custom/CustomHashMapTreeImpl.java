package programs.custom;

class CustomHashMapTree<K extends Comparable<K>, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private final double loadFactorThreshold;
    private Node<K, V>[] buckets;
    private int size = 0;

    public CustomHashMapTree() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public CustomHashMapTree(int capacity, double loadFactorThreshold) {
        this.buckets = new Node[capacity];
        this.loadFactorThreshold = loadFactorThreshold;
    }

    public V put(K key, V value) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new Node<>(key, value);
            size++;
            resizeIfNeeded();
            return null;
        } else {
            V oldValue = buckets[index].put(key, value);
            if (oldValue == null) {
                size++;
                resizeIfNeeded();
            }
            return oldValue;
        }
    }

    public V get(Object key) {
        int index = getIndex((K) key);
        if (buckets[index] != null) {
            return buckets[index].get((K) key);
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    // Used to calculate the hashcode of given string
    public int hashCode(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * 31 + s.charAt(i);
        }
        return hash;
    }

    private void resizeIfNeeded() {
        if ((double) size / buckets.length >= loadFactorThreshold) {
            int newCapacity = buckets.length * 2; // Double the capacity
            Node<K, V>[] newBuckets = new Node[newCapacity];

            // Rehash elements into the new buckets array
            for (Node<K, V> node : buckets) {
                rehash(node, newBuckets);
            }
            buckets = newBuckets; // Update to the new buckets array
        }
    }

    private void rehash(Node<K, V> node, Node<K, V>[] newBuckets) {
        if (node != null) {
            int index = getIndex(node.key, newBuckets.length);
            if (newBuckets[index] == null) {
                newBuckets[index] = new Node<>(node.key, node.value);
            } else {
                newBuckets[index].put(node.key, node.value);
            }
            rehash(node.left, newBuckets);
            rehash(node.right, newBuckets);
        }
    }

    private int getIndex(K key, int capacity) {
        return key == null ? 0 : Math.abs(key.hashCode()) % capacity;
    }

    private static class Node<K extends Comparable<K>, V> {
        private final K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V put(K key, V value) {
            if (key.compareTo(this.key) == 0) {
                V oldValue = this.value;
                this.value = value;
                return oldValue;
            } else if (key.compareTo(this.key) < 0) {
                if (left == null) {
                    left = new Node<>(key, value);
                    return null;
                } else {
                    return left.put(key, value);
                }
            } else {
                if (right == null) {
                    right = new Node<>(key, value);
                    return null;
                } else {
                    return right.put(key, value);
                }
            }
        }

        public V get(K key) {
            if (key.compareTo(this.key) == 0) {
                return value;
            } else if (key.compareTo(this.key) < 0) {
                if (left == null) {
                    return null;
                } else {
                    return left.get(key);
                }
            } else {
                if (right == null) {
                    return null;
                } else {
                    return right.get(key);
                }
            }
        }
    }
}

public class CustomHashMapTreeImpl {
    public static void main(String[] args) {
        CustomHashMapTree<String, Integer> hashMap = new CustomHashMapTree<>();
        // Adding key-value pairs to the HashMap
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Four", 4);
        hashMap.put("Five", 5);

        // Retrieving values from the HashMap
        System.out.println("Value of 'One': " + hashMap.get("One"));
        System.out.println("Value of 'Two': " + hashMap.get("Two"));
        System.out.println("Value of 'Three': " + hashMap.get("Three"));
        System.out.println("Value of 'Four': " + hashMap.get("Four"));
        System.out.println("Value of 'Five': " + hashMap.get("Five"));

        // Updating value
        hashMap.put("Three", 33);

        // Retrieving updated value
        System.out.println("Updated value of 'Three': " + hashMap.get("Three"));

        // Retrieving value that doesn't exist
        System.out.println("Value of 'Six': " + hashMap.get("Six"));
    }
}