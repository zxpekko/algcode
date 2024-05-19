package monotonicstack;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:30 2024/5/12
 */
public class Solution42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    public int trap(int[] height){
        int n=height.length;
        Stack<Integer> stack=new Stack<>();
        int result=0;
        for(int i=0;i<n;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                if(stack.size()>1){
                    Integer pop = stack.pop();
                    result+=(i-stack.peek()-1)*(Math.min(height[i],height[stack.peek()])-height[pop]);
                }
                else {
                    Integer pop = stack.pop();
                }
            }
            stack.push(i);
        }
        return result;
    }
}
