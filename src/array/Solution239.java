package array;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:53 2024/6/4
 */
public class Solution239 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] ints = solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }
    public int[] maxSlidingWindow(int[] nums, int k){
        int n=nums.length;
        int[] result = new int[n - k + 1];
        int index=0;
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while (!arrayDeque.isEmpty()&&arrayDeque.peek()<i-k+1)
                arrayDeque.poll();
            while (!arrayDeque.isEmpty()&&nums[i]>nums[arrayDeque.peekLast()])
                arrayDeque.pollLast();
            arrayDeque.offer(i);
        if(i>=k-1)
            result[index++]=nums[arrayDeque.peek()];
        }
        return result;
    }
}
