package backtracking;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:12 2024/5/21
 */
public class Solution47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.permuteUnique(new int[]{1,1,2}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        boolean[] booleans = new boolean[nums.length];
        dfs(nums,booleans);
        return result;
    }
    public void dfs(int[] nums,boolean[] booleans){
        if(subResult.size()== nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        HashSet<Integer> record=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!record.contains(nums[i])&&!booleans[i]){
                subResult.add(nums[i]);
                record.add(nums[i]);
                booleans[i]=true;
                dfs(nums,booleans);
                subResult.remove(subResult.size()-1);
                booleans[i]=false;
            }
        }
    }
}
