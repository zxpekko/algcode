package stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:24 2024/4/17
 */
public class Solution239 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] ints = solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!arrayDeque.isEmpty() && arrayDeque.peek() < i - k + 1) {
                arrayDeque.poll();
            }
            while (!arrayDeque.isEmpty() && nums[arrayDeque.peekLast()] < nums[i]) {
                arrayDeque.pollLast();
            }
            arrayDeque.offer(i);
            if (i >= k - 1)
                result[index++] = nums[arrayDeque.peek()];
        }
        return result;
    }
}
