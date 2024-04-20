package monotonicstack;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:06 2024/4/10
 */
public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
//        new ThreadPoolExecutor(20,100,5,TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(20),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.CallerRunsPolicy());
        int[] ints = solution49.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(Arrays.toString(ints));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int m=nums1.length;
        int n=nums2.length;
        int[] result = new int[m];
        int[] record = new int[n];
        Arrays.fill(record,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                Integer pop = stack.pop();
                record[pop]=nums2[i];
            }
            stack.push(i);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    result[i]=record[j];
                    break;
                }
            }
        }
        return result;
    }
}
