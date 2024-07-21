package leetcode150;

import backtracking.Solution216;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:23 2024/7/17
 */
public class Solution45 {
    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(new int[]{2, 3, 1, 1, 4}));
        Solution45Ⅱ solution45Ⅱ = new Solution45Ⅱ();
        System.out.println(solution45Ⅱ.jump(new int[]{3, 2, 1, 0, 4}));

    }
    public int jump(int[] nums){
        int steps=0,n=nums.length;
        int position=n-1;
        while (position>0){
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    position=i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
class Solution45Ⅰ{
    public int jump(int[] nums){
        int n=nums.length;
        int steps=0,position=n-1;
        while (position>0){
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    position=i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
class Solution45Ⅱ{
    public int jump(int[] nums){
        int n=nums.length;
        int position=n-1,steps=0;
        while (position>0){
            boolean flag=false;
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    position=i;
                    steps++;
                    flag=true;
                    break;
                }
            }
            if(!flag)
                return -1;
        }
        return steps;
    }
}
