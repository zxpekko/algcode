package monotonicstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:32 2024/5/11
 */
public class Solution739 {
    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] ints = solution739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));

    }
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack=new Stack<>();
        int n=temperatures.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                Integer pop = stack.pop();
                result[pop]=i-pop;
            }
            stack.push(i);
        }
        return result;
    }
}
