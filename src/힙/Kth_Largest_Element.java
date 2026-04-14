package 힙;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @link https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Kth_Largest_Element {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Kth_Largest_Element test = new Kth_Largest_Element();

        int result1 = test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(result1); // 기대값: 5

        int result2 = test.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(result2); // 기대값: 4
    }
}
