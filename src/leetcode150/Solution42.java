package leetcode150;

import java.util.Map;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:14 2024/7/20
 */
public class Solution42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    public int trap(int[] height){
        int n=height.length;
        Stack<Integer> stack = new Stack<>();
        int result=0;
        for(int i=0;i< height.length;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                Integer mid = stack.pop();
                if(!stack.isEmpty()){
                    Integer left = stack.peek();
                    int h= Math.min(height[left],height[i])-height[mid];
                    int w=i-left-1;
                    result+=(h*w);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
