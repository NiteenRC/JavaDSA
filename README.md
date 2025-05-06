Top 40 Must-Do Array Interview Questions

1. Two Sum
   **Problem:** Find two numbers that add up to a given target.
   **Approach:** Use HashMap for O(N) time complexity.
   **Test Case:** [2,7,11,15], target = 9 → Output: [0,1]
   **Link:** https://leetcode.com/problems/two-sum/


2. Best Time to Buy and Sell Stock
   **Problem:** Find the maximum profit you can achieve from buying and selling a stock.
   **Approach:** Use one-pass tracking min-price & max-profit.
   **Test Case:** [7,1,5,3,6,4] → Output: 5
   **Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


3. Merge Intervals
   **Problem:** Merge overlapping intervals.
   **Approach:** Sort and merge adjacent intervals.
   **Test Case:** [[1,3],[2,6],[8,10],[15,18]] → Output: [[1,6],[8,10],[15,18]]
   **Link:** https://leetcode.com/problems/merge-intervals/


4. Product of Array Except Self
   **Problem:** Find product of all elements except self.
   **Approach:** Use prefix & suffix multiplication approach.
   **Test Case:** [1,2,3,4] → Output: [24,12,8,6]
   **Link:** https://leetcode.com/problems/product-of-array-except-self/


5. Maximum Subarray
   **Problem:** Find the contiguous subarray with the largest sum.
   **Approach:** Use Kadane's Algorithm.
   **Test Case:** [-2,1,-3,4,-1,2,1,-5,4] → Output: 6
   **Link:** https://leetcode.com/problems/maximum-subarray/


6. Find the Duplicate Number
   **Problem:** Find the duplicate number in an array.
   **Approach:** Use Floyd's Tortoise-Hare Cycle Detection.
   **Test Case:** [3,1,3,4,2] → Output: 3
   **Link:** https://leetcode.com/problems/find-the-duplicate-number/


7. Trapping Rain Water
   **Problem:** Find how much rainwater can be trapped between buildings.
   **Approach:** Use two-pointer or prefix-suffix max arrays.
   **Test Case:** [0,1,0,2,1,0,1,3,2,1,2,1] → Output: 6
   **Link:** https://leetcode.com/problems/trapping-rain-water/


8. Kth Largest Element in an Array
   **Problem:** Find the Kth largest element.
   **Approach:** Use Heap or QuickSelect.
   **Test Case:** [3,2,3,1,2,4,5,5,6], k=4 → Output: 4
   **Link:** https://leetcode.com/problems/kth-largest-element-in-an-array/


9. Sliding Window Maximum
   **Problem:** Find the max in every sliding window of size k.
   **Approach:** Use Monotonic Queue.
   **Test Case:** [1,3,-1,-3,5,3,6,7], k=3 → Output: [3,3,5,5,6,7]
   **Link:** https://leetcode.com/problems/sliding-window-maximum/


10. Longest Consecutive Sequence
    **Problem:** Find the longest consecutive sequence in an array.
    **Approach:** Use HashSet for O(N) time complexity.
    **Test Case:** [100,4,200,1,3,2] → Output: 4
    **Link:** https://leetcode.com/problems/longest-consecutive-sequence/


11. Set Matrix Zeroes
    **Problem:** Modify a matrix such that if an element is 0, its entire row and column become 0.
    **Approach:** Use first row/column as markers to track zeros.
    **Test Case:** [[1,1,1],[1,0,1],[1,1,1]] → Output: [[1,0,1],[0,0,0],[1,0,1]]
    **Link:** https://leetcode.com/problems/set-matrix-zeroes/


12. Spiral Matrix
    **Problem:** Traverse a matrix in spiral order.
    **Approach:** Use direction tracking with four pointers.
    **Test Case:** [[1,2,3],[4,5,6],[7,8,9]] → Output: [1,2,3,6,9,8,7,4,5]
    **Link:** https://leetcode.com/problems/spiral-matrix/


13. Rotate Image
    **Problem:** Rotate a matrix by 90 degrees clockwise.
    **Approach:** Transpose and then reverse each row.
    **Test Case:** [[1,2,3],[4,5,6],[7,8,9]] → Output: [[7,4,1],[8,5,2],[9,6,3]]
    **Link:** https://leetcode.com/problems/rotate-image/


14. Word Search
    **Problem:** Check if a word exists in a 2D board by moving in 4 directions.
    **Approach:** Use DFS with backtracking.
    **Test Case:** Board=[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word='ABCCED' → Output: True
    **Link:** https://leetcode.com/problems/word-search/


15. Search in Rotated Sorted Array
    **Problem:** Find an element in a rotated sorted array.
    **Approach:** Use modified binary search.
    **Test Case:** [4,5,6,7,0,1,2], target=0 → Output: 4
    **Link:** https://leetcode.com/problems/search-in-rotated-sorted-array/


16. Combination Sum
    **Problem:** Find all unique combinations that sum to a target.
    **Approach:** Use backtracking.
    **Test Case:** [2,3,6,7], target=7 → Output: [[7],[2,2,3]]
    **Link:** https://leetcode.com/problems/combination-sum/


17. Jump Game
    **Problem:** Determine if you can reach the last index.
    **Approach:** Use greedy approach.
    **Test Case:** [2,3,1,1,4] → Output: True
    **Link:** https://leetcode.com/problems/jump-game/


18. Jump Game II
    **Problem:** Find the minimum jumps to reach the last index.
    **Approach:** Use BFS-like greedy approach.
    **Test Case:** [2,3,1,1,4] → Output: 2
    **Link:** https://leetcode.com/problems/jump-game-ii/


19. Majority Element
    **Problem:** Find the majority element appearing more than n/2 times.
    **Approach:** Use Boyer-Moore Voting Algorithm.
    **Test Case:** [3,2,3] → Output: 3
    **Link:** https://leetcode.com/problems/majority-element/


20. Sort Colors
    **Problem:** Sort an array of 0s, 1s, and 2s in place.
    **Approach:** Use Dutch National Flag Algorithm.
    **Test Case:** [2,0,2,1,1,0] → Output: [0,0,1,1,2,2]
    **Link:** https://leetcode.com/problems/sort-colors/


21. Insert Interval
    **Problem:** Insert an interval into a set of non-overlapping intervals.
    **Approach:** Use merging approach.
    **Test Case:** Intervals=[[1,3],[6,9]], newInterval=[2,5] → Output: [[1,5],[6,9]]
    **Link:** https://leetcode.com/problems/insert-interval/


22. Missing Number
    **Problem:** Find the missing number in a range 0 to n.
    **Approach:** Use XOR or sum formula.
    **Test Case:** [3,0,1] → Output: 2
    **Link:** https://leetcode.com/problems/missing-number/


23. Find All Duplicates in an Array
    **Problem:** Find all elements that appear twice.
    **Approach:** Use index marking trick.
    **Test Case:** [4,3,2,7,8,2,3,1] → Output: [2,3]
    **Link:** https://leetcode.com/problems/find-all-duplicates-in-an-array/


24. Game of Life
    **Problem:** Implement Conway’s Game of Life.
    **Approach:** Use in-place transformation.
    **Test Case:** Board=[[0,1,0],[0,0,1],[1,1,1],[0,0,0]] → Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    **Link:** https://leetcode.com/problems/game-of-life/


25. Subarray Sum Equals K
    **Problem:** Find count of subarrays with sum K.
    **Approach:** Use HashMap prefix sum technique.
    **Test Case:** [1,1,1], k=2 → Output: 2
    **Link:** https://leetcode.com/problems/subarray-sum-equals-k/


26. Next Permutation
    **Problem:** Find the next lexicographical permutation.
    **Approach:** Use swap and reverse approach.
    **Test Case:** [1,2,3] → Output: [1,3,2]
    **Link:** https://leetcode.com/problems/next-permutation/


27. Rotate Array
    **Problem:** Rotate array to the right by k steps.
    **Approach:** Use reversal method.
    **Test Case:** [1,2,3,4,5,6,7], k=3 → Output: [5,6,7,1,2,3,4]
    **Link:** https://leetcode.com/problems/rotate-array/


28. Contains Duplicate
    **Problem:** Check if array contains duplicate numbers.
    **Approach:** Use HashSet.
    **Test Case:** [1,2,3,1] → Output: True
    **Link:** https://leetcode.com/problems/contains-duplicate/


29. Max Product Subarray
    **Problem:** Find the contiguous subarray with max product.
    **Approach:** Use DP with min-max tracking.
    **Test Case:** [2,3,-2,4] → Output: 6
    **Link:** https://leetcode.com/problems/maximum-product-subarray/


30. Find Minimum in Rotated Sorted Array
    **Problem:** Find the minimum element in rotated sorted array.
    **Approach:** Use modified binary search.
    **Test Case:** [3,4,5,1,2] → Output: 1
    **Link:** https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/


31. Largest Rectangle in Histogram
    **Problem:** Find the largest rectangle in histogram.
    **Approach:** Use stack to track heights.
    **Test Case:** [2,1,5,6,2,3] → Output: 10
    **Link:** https://leetcode.com/problems/largest-rectangle-in-histogram/


32. Merge Sorted Array
    **Problem:** Merge two sorted arrays into one.
    **Approach:** Use two-pointer approach.
    **Test Case:** nums1=[1,2,3,0,0,0], nums2=[2,5,6] → Output: [1,2,2,3,5,6]
    **Link:** https://leetcode.com/problems/merge-sorted-array/


33. Find Peak Element
    **Problem:** Find a peak element in an array.
    **Approach:** Use binary search.
    **Test Case:** [1,2,1,3,5,6,4] → Output: 1 or 5
    **Link:** https://leetcode.com/problems/find-peak-element/


34. First Missing Positive
    **Problem:** Find the smallest missing positive integer.
    **Approach:** Use in-place index marking.
    **Test Case:** [1,2,0] → Output: 3
    **Link:** https://leetcode.com/problems/first-missing-positive/


35. Count Inversions in an Array
    **Problem:** Count how many inversions exist in an array.
    **Approach:** Use modified merge sort.
    **Test Case:** [8,4,2,1] → Output: 6
    **Link:** https://www.geeksforgeeks.org/counting-inversions/


36. Smallest Range Covering Elements from K Lists
    **Problem:** Find smallest range covering k lists.
    **Approach:** Use min-heap.
    **Test Case:** [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]] → Output: [20,24]
    **Link:** https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/


37. Find K Pairs with Smallest Sums
    **Problem:** Find k smallest sum pairs from two arrays.
    **Approach:** Use min-heap.
    **Test Case:** nums1=[1,7,11], nums2=[2,4,6], k=3 → Output: [[1,2],[1,4],[1,6]]
    **Link:** https://leetcode.com/problems/find-k-pairs-with-smallest-sums/


38. Median of Two Sorted Arrays
    **Problem:** Find the median of two sorted arrays.
    **Approach:** Use binary search on shorter array.
    **Test Case:** [1,3], [2] → Output: 2.0
    **Link:** https://leetcode.com/problems/median-of-two-sorted-arrays/

# Java Programming Tasks

This repository contains solutions to various Java programming tasks.

1. **LRU cache implementation**: Implementation of an LRU (Least Recently Used) cache using doubly linked lists. Doubly
   linked lists are used for efficient removal and reinsertion of elements when they are accessed.

   [Solution](https://github.com/NiteenRC/JavaDSA/blob/master/src/main/java/cache/LRUCacheImpl.java)

2. **Search in a rotated sorted array**: Solution to the problem of searching in a rotated sorted array.

   [Solution](https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1223265018/)

3. **Cron job to message friends every Friday of the last week of the month**: Implementation of a cron job to send
   messages to friends every Friday of the last week of the month.

   [Solution](https://github.com/NiteenRC/JavaDSA/blob/master/src/main/java/date/LastFridayOfMonth.java)

4. **Sort students by total marks**: Program to sort students by their total marks in descending order and print the
   sorted list of students with their respective total marks.

   [Solution](https://github.com/NiteenRC/JavaDSA/blob/master/src/main/java/sorting/SortStudentsByMarks.java)

5. **Find maximum average of students**: Given an array of students and their marks in different subjects, find the
   maximum average of the student.

   [Solution](https://github.com/NiteenRC/JavaDSA/blob/master/src/main/java/freq/StudentMaxMarksAvg.java)

6. **Remove duplicates from sorted array**: Given an integer array sorted in non-decreasing order, remove the duplicates
   in-place such that each unique element appears only once.

   [Solution](https://github.com/NiteenRC/JavaDSA/blob/master/src/main/java/duplicate/RemoveDuplicates.java)

7. **Sort characters by frequency**: Sort the characters in a string by their frequency in descending order.

   [Solution](https://leetcode.com/problems/sort-characters-by-frequency/submissions/1217971453)

8. **Count words and characters from a file**: Program to count the words and characters from a file.

   [Solution](#) (No specific link provided)

9. **Find the missing element in an unsorted list of natural numbers**: Program to find the missing element in an
   unsorted list of natural numbers.

   [Solution](#) (No specific link provided)

10. **Reverse 32-bit integer**: Solution to the problem of reversing a 32-bit integer.

    [Solution](https://leetcode.com/problems/reverse-integer/submissions/1171436930/)

11. **Check balanced expression**: Program to check if an expression with parentheses is balanced.

    [Solution](https://leetcode.com/problems/valid-parentheses/submissions/1175786382/)

12. **Sort Users by firstName and then by lastName, and Group by gender**: program sorts a list of users by their
    firstName and then by lastName, and then groups them by gender.

    [solution](https://github.com/NiteenRC/JavaDSA/blob/master/src/main/java/sort/SortAndGroupByGender.java)
