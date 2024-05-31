package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:15 2024/5/29
 */
public class Solution31 {
    public static void main(String[] args) {

    }
    List<Integer> subResult=new ArrayList<>();
    public void nextPermutation(int[] nums){
        int[] copy = new int[nums.length];
        int flag=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                flag=1;
                break;
            }
        }
        if(flag==0)
            return;
        for(int i=0;i<nums.length;i++)
            copy[i]=nums[i];
        dfs(nums,0,copy);
    }
    public void dfs(int[] nums,int start,int[] copy){
        if(subResult.size()==nums.length){

        }
    }
    public boolean judgeSame(int[] nums1,int[] nums2){
        return false;
    }
}
