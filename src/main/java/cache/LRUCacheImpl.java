package cache;

import java.util.HashMap;
import java.util.Map;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return null;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            node = new Node<>(key, value);
            cache.put(key, node);
            addToHead(node);
            if (cache.size() > capacity) {
                Node<K, V> removed = removeTail();
                cache.remove(removed.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private Node<K, V> removeTail() {
        Node<K, V> removed = tail.prev;
        removeNode(removed);
        return removed;
    }

    public synchronized void clear() {
        cache.clear();
        head.next = tail;
        tail.prev = head;
    }

    public synchronized int size() {
        return cache.size();
    }

    public synchronized boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    @Override
    public synchronized String toString() {
        StringBuilder builder = new StringBuilder("{");
        Node<K, V> current = head.next;
        while (current != tail) {
            builder.append(current.key).append("=").append(current.value);
            current = current.next;
            if (current != tail) {
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}

public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println(cache); // Output: {3=Three, 2=Two, 1=One}

        cache.put(4, "Four"); // Entry 1 (One) is removed as it was least recently used

        System.out.println(cache); // Output: {4=Four, 3=Three, 2=Two}

        cache.get(2); // Entry 2 (Two) is accessed, moving it to the front

        System.out.println(cache); // Output: {2=Two, 4=Four, 3=Three}
    }
}