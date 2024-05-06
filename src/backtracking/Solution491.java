package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:28 2024/5/5
 */
public class Solution491 {
    public static void main(String[] args) {
        Solution491 solution491 = new Solution491();
        System.out.println(solution491.findSubsequences(new int[]{4,6,7,7}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums){
        int n=nums.length;
//        boolean[] visited = new boolean[n];
//        dfs(nums,0,visited);
        dfs(nums,0);
        return result;
    }
//    public void dfs(int[] nums,int startIndex,boolean[] visited){
//        if(subResult.size()>=2){
//            result.add(new ArrayList<>(subResult));
//        }
//        for(int i=startIndex;i<nums.length;i++){
//            if(i>0&&nums[i]==nums[i-1]&&!visited[i-1])
//                continue;
//            if(subResult.size()==0){
//                subResult.add(nums[i]);
//                visited[i]=true;
//                dfs(nums,i+1,visited);
//                subResult.remove(subResult.size()-1);
//                visited[i]=false;
//            }
//            else {
//                if(nums[i]>=subResult.get(subResult.size()-1)){
//                    subResult.add(nums[i]);
//                    visited[i]=true;
//                    dfs(nums,i+1,visited);
//                    subResult.remove(subResult.size()-1);
//                    visited[i]=false;
//                }
//                else
//                    continue;
//            }
//        }
//    }
    public void dfs(int[] nums,int startIndex){
        if(subResult.size()>=2){
            result.add(new ArrayList<>(subResult));
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=startIndex;i<nums.length;i++){
            if((!subResult.isEmpty()&&subResult.get(subResult.size()-1)>nums[i])||hashSet.contains(nums[i]))
                continue;
            subResult.add(nums[i]);
            hashSet.add(nums[i]);
            dfs(nums,i+1);
            subResult.remove(subResult.size()-1);
        }
    }
}
