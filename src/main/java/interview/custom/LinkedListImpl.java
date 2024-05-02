package interview.custom;

import java.util.NoSuchElementException;

class CustomLinkedList {
    private Node head;

    public void addToEnd(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void prepend(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public int findMiddle() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public void insertAtMiddle(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            node.next = slow; // Insert the new node after the middle node
            prev.next = node;
        } else {
            node.next = head; // Insert the new node at the beginning of the list
            head = node;
        }
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }

        Node node = new Node(data);
        if (position == 0) {
            node.next = head;
            head = node;
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            throw new NoSuchElementException("Position is out of bounds");
        }

        node.next = current.next;
        current.next = node;
    }

    public void removeAtPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }

        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        for (int i = 0; current != null && i < position; i++) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            throw new NoSuchElementException("Position is out of bounds");
        }

        previous.next = current.next;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

public class LinkedListImpl {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        // Adding elements to the list
        list.addToEnd(2);
        //list.addToEnd(4);
        //list.addToEnd(5);
        //list.addToEnd(7);
       // list.addToEnd(3);

        System.out.println("\nList before insert:");
        list.print();
        list.insertAtMiddle(1);
        System.out.println("\nList after insert:");
        list.print();

        System.out.println("\nList before insert at position:");
        list.print();
        list.insertAtPosition(9, 1);
        System.out.println("\nList after insert at position:");
        list.print();

        list.prepend(6);

        // Printing the list before removal
        System.out.println("\nList before removal:");
        list.print();

        try {
            // Removing an element at position 2
            list.removeAtPosition(2);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Error while removing element: " + e.getMessage());
        }

        // Printing the list after removal
        System.out.println("\nList after removal:");
        list.print();

        // Displaying the middle element
        try {
            System.out.println("\nMiddle element: " + list.findMiddle());
        } catch (NoSuchElementException e) {
            System.out.println("Error while finding middle element: " + e.getMessage());
        }
    }
}
