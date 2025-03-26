package programs.hashmap;

import java.util.PriorityQueue;

public class KthSmallestElementMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = matrix.length;
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        while (k-- > 1) {
            int[] curr = minHeap.poll();
            int row = curr[1], col = curr[2];
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return minHeap.poll()[0];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(matrix, 8)); // 13
    }
}
