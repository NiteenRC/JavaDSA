package programs.custom;

class CustomArrayList {
    private static final int DEFAULT_CAPACITY = 1;
    private static final double DEFAULT_LOAD_FACTOR = 0.1F;
    private final double loadFactor;
    private int[] array;
    private int size;

    public CustomArrayList() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public CustomArrayList(int initialCapacity, double loadFactor) {
        this.array = new int[initialCapacity];
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    public void add(int data) {
        ensureArrayCapacity();
        this.array[size++] = data;
    }

    private void ensureArrayCapacity() {
        double currentLF = (double) this.size / array.length;

        if (currentLF >= loadFactor) {
            int newCapacity = array.length * 2;
            int[] newArray = new int[newCapacity];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
        }
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
    }

    public int get(int index) {
        return this.array[index];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.array.length == 0;
    }

}

public class CustomArrayListImpl {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(2, 0.5); // Initial capacity: 3, Load factor: 0.5
        list.add(1);
        list.add(2);
        list.add(3);
        list.display(); // Output: 1 2 3

        System.out.println("\nElement at index 1: " + list.get(1)); // Output: 2
        System.out.println("Size of the list: " + list.size()); // Output: 3
        System.out.println("Is the list empty? " + list.isEmpty()); // Output: false
    }
}
