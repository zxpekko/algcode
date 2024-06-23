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
        Solution42Ⅰ solution42Ⅰ = new Solution42Ⅰ();
        System.out.println(solution42Ⅰ.trap(new int[]{4, 2, 0, 3, 2, 5}));
        Solution42Ⅱ solution42Ⅱ = new Solution42Ⅱ();
        System.out.println(solution42Ⅱ.trap(new int[]{4, 2, 0, 3, 2, 5}));
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
class Solution42Ⅰ{
    public int trap(int[] height){
        Stack<Integer> stack = new Stack<>();//递增栈，从栈口向里依次递增
        int n=height.length;
        int result=0;
        for(int i=0;i<n;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                Integer mid = stack.pop();
                if(!stack.isEmpty()){
                    Integer left = stack.peek();
                    int h=Math.min(height[i],height[left])-height[mid];
                    int w=i-left-1;
                    result+=(h*w);
                }
            }
            stack.push(i);
        }
        return result;
    }
}
class Solution42Ⅱ{
    public int trap(int[] height){
        Stack<Integer> stack=new Stack<>();
        int result=0;
        for(int i=0;i<height.length;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int mid=height[stack.pop()];
                if(stack.size()>0){
                    int right=height[i];
                    int left=height[stack.peek()];
                    int h=Math.min(right,left)-mid;
                    int w=i-stack.peek()-1;
                    result+=h*w;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
