package programs.duplicate;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Example input array sorted in non-decreasing order
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 5};
        int uniqueCount = removeDuplicates(nums);
        System.out.println("Number of unique elements: " + uniqueCount);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0; // Pointer to track the position of the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i]; // Place the unique element at the next available position
            }
        }

        // Print the unique elements
        for (int i = 0; i <= uniqueIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(); // Add a newline after printing all unique elements

        return uniqueIndex + 1; // Return the count of unique elements
    }
}