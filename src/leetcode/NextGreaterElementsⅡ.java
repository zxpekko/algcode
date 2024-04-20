package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * @Date:10:15 2023/11/22
 */
public class NextGreaterElementsⅡ {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        NextGreaterElementsⅡ nextGreaterElementsⅡ = new NextGreaterElementsⅡ();
        int[] ints = nextGreaterElementsⅡ.nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));
    }
    public int[] nextGreaterElements(int[] nums){
        int n= nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[stack.peek()]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()&&nums[i]>nums[stack.peek()]){
                    result[stack.peek()]=nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]<=nums[stack.peek()]){
                stack.push(i);
            }
            else{
                while (!stack.isEmpty()&&nums[i]>nums[stack.peek()]){
                    if(result[stack.peek()]==-1){
                        result[stack.peek()]=nums[i];
                    }
                    stack.pop();
                }
                stack.push(i);

            }
        }
        return result;
    }
}
