package programs.companies;

public class FindFirstAndLastOcc {
    public int[] findFirstAndLast(int[] arr, int target) {
        int first = findOccurrence(arr, target, true);
        int last = findOccurrence(arr, target, false);
        return new int[]{first, last};
    }

    private int findOccurrence(int[] arr, int target, boolean findFirst) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

}
