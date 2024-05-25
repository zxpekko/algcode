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
        Solution239Ⅰ solution239Ⅰ = new Solution239Ⅰ();
        int[] ints1 = solution239Ⅰ.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints1));
        Solution239Ⅱ solution239Ⅱ = new Solution239Ⅱ();
        int[] ints2 = solution239Ⅱ.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints2));
        Solution239Ⅲ solution239Ⅲ = new Solution239Ⅲ();
        int[] ints3 = solution239Ⅲ.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints3));
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
class Solution239Ⅰ{
    public int[] maxSlidingWindow(int[] nums, int k){
        int n=nums.length;
        int[] result = new int[n - k + 1];
        int index=0;
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while (!deque.isEmpty()&&deque.peek()<i-k+1)
                deque.poll();
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()])
                deque.pollLast();
            deque.offer(i);
            if(i>=k-1)
                result[index++]=nums[deque.peek()];
        }
        return result;
    }
}
class Solution239Ⅱ{
    public int[] maxSlidingWindow(int[] nums, int k){
        int n=nums.length;
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        int index=0;
        for(int i=0;i<n;i++){
            while (!deque.isEmpty()&&deque.peek()<i-k+1)
                deque.poll();
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()])
                deque.pollLast();
            deque.offer(i);
            if(i>=k-1)
                result[index++]=nums[deque.peek()];
        }
        return result;
    }
}
class Solution239Ⅲ{
    public int[] maxSlidingWindow(int[] nums, int k){
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        int n=nums.length;
        int[] result = new int[n - k + 1];
        int index=0;
        for(int i=0;i<n;i++){
            while (!deque.isEmpty()&&deque.peek()<i-k+1)
                deque.poll();
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()])
                deque.pollLast();
            deque.offer(i);
            if(i>=k-1)
                result[index++]=nums[deque.peek()];
        }
        return result;
    }
}