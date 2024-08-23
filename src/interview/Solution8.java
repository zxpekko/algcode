package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @Author:zxp
 * @Description:一个数n和m，n的数位可以交换排列，请你计算出对n这个数的数位进行交换排列所得到的所有数中能够被n整除的数有多少个，不含前导零。
 * @Date:19:54 2024/8/21
 */
public class Solution8 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.get(522, 2));
    }
    int count=0;
    public int get(int n,int m){
        List<Integer> res=new ArrayList<>();
        int cur=n;
        while (cur>0){
            res.add(cur%10);
            cur/=10;
        }
        int[] candidates = new int[res.size()];
        for(int i=0;i<candidates.length;i++)
            candidates[i]=res.get(i);
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates,used,0,0,m);
        return count;
    }
    public void dfs(int[] cadidate,boolean[] used,int cur,int curWeishu,int m){
        if(curWeishu==cadidate.length){
            if(cur%m==0){
                count++;
            }
            return;
        }
        for(int i=0;i<cadidate.length;i++){
            if(cadidate[i]==0&&curWeishu==0)
                continue;
            if(used[i])
                continue;
            if(i>0&&cadidate[i]==cadidate[i-1]&&!used[i-1])
                continue;
            cur=cur*10+cadidate[i];
            curWeishu++;
            used[i]=true;
            dfs(cadidate,used,cur,curWeishu,m);
            cur/=10;
            curWeishu--;
            used[i]=false;
        }
    }
}