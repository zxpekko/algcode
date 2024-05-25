package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:46 2024/5/21
 */
public class Solution46Ⅰ {
    public static void main(String[] args) {
        Solution46Ⅰ solution46Ⅰ = new Solution46Ⅰ();
        System.out.println(solution46Ⅰ.permute(new int[]{1, 2, 3}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    HashSet<Integer> record=new HashSet<>();
    public List<List<Integer>> permute(int[] nums){
        dfs(nums);
        return result;
    }
    public void dfs(int[] nums){
        if(subResult.size()==nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!record.contains(nums[i])){
                record.add(nums[i]);
                subResult.add(nums[i]);
                dfs(nums);
                record.remove(nums[i]);
                subResult.remove(subResult.size()-1);
            }
        }
    }
}
