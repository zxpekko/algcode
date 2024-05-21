package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @Date:13:19 2024/5/19
 */
public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(new int[]{0,1}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    HashSet<Integer> record=new HashSet<>();
    public List<List<Integer>> permute(int[] nums){
        dfs(nums);
        return result;
    }
    public void dfs(int[] nums){
        if(subResult.size()== nums.length){
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