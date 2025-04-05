package programs.cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache; // HashMap for O(1) access
    private Node head;
    private final Node tail;          // Dummy head and tail for Doubly Linked List

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;          // Initialize pointers
        tail.prev = head;
    }

    // Get method to fetch value from the cache
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node); // Mark as recently used
            return node.value;
        }
        return -1; // Key not found
    }

    // Put method to insert or update a value
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update existing node's value and move to head
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // Create a new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);

            if (cache.size() > capacity) {
                // Remove least recently used node
                Node lru = removeTail();
                cache.remove(lru.key);
            }
        }
    }

    // Add a new node right after the head
    private void addNodeToHead(Node node) {
        node.next = head;
        head.prev = node;
        head = node;
    }

    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Move an existing node to the head
    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    // Remove the tail node (Least Recently Used)
    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }

    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        System.out.println("Step 1: Add key=1, value=1 to the cache.");
        lruCache.put(1, 1);  // Cache: {1=1}
        System.out.println();

        System.out.println("Step 2: Add key=2, value=2 to the cache.");
        lruCache.put(2, 2);  // Cache: {1=1, 2=2}
        System.out.println();

        System.out.println("Step 3: Access key=1 (should return value=1).");
        System.out.println("Result: " + lruCache.get(1));  // Returns 1, Cache: {2=2, 1=1}
        System.out.println();

        System.out.println("Step 4: Add key=3, value=3 (should evict key=2).");
        lruCache.put(3, 3);  // Evicts key 2, Cache: {1=1, 3=3}
        System.out.println();

        System.out.println("Step 5: Access key=2 (should return -1, as it's evicted).");
        System.out.println("Result: " + lruCache.get(2));  // Returns -1
        System.out.println();

        System.out.println("Step 6: Add key=4, value=4 (should evict key=1).");
        lruCache.put(4, 4);  // Evicts key 1, Cache: {3=3, 4=4}
        System.out.println();

        System.out.println("Step 7: Access key=1 (should return -1, as it's evicted).");
        System.out.println("Result: " + lruCache.get(1));  // Returns -1
        System.out.println();

        System.out.println("Step 8: Access key=3 (should return value=3).");
        System.out.println("Result: " + lruCache.get(3));  // Returns 3, Cache: {4=4, 3=3}
        System.out.println();

        System.out.println("Step 9: Access key=4 (should return value=4).");
        System.out.println("Result: " + lruCache.get(4));  // Returns 4, Cache: {3=3, 4=4}
        System.out.println();
    }
}